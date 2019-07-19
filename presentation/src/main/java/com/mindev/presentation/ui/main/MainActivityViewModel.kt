package com.mindev.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.common.Result
import com.mindev.domain.entity.DomainEntity
import com.mindev.domain.news.NewsUseCase
import com.mindev.presentation.MinDevViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel
@Inject constructor(private val newsUseCase: NewsUseCase) : MinDevViewModel() {

    sealed class ResultState {
        data class ToastMessage(val message: String) : ResultState()
        data class NewsList(val items: List<DomainEntity.NewsInfo>) : ResultState()
    }

    val inputValueOB = MutableLiveData<String>()

    private val _resultStateLive = MutableLiveData<ResultState>()
    val resultStateLive: LiveData<ResultState> get() = _resultStateLive

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading


    fun getDelivery(input: String) {
        if (input == "") {
            _resultStateLive.postValue(ResultState.ToastMessage("입력해주세요."))
            return
        }
        viewModelScope.launch(Dispatchers.Default + errorHandler) {
            _isLoading.postValue(true)
            // 병렬 호출을 위한 async 호출
            val first = async { newsUseCase.execute(NewsUseCase.Params(1)) }
            // 병렬 호출을 위헤 이런식으로 설계 진행...
            val second = async { newsUseCase.execute(NewsUseCase.Params(10)) }

            val totalResult = Pair(first.await(), second.await())
            _isLoading.postValue(false)

            totalResult.let {
                if (it.first is Result.Success && it.second is Result.Success) {
                    val firstResponse =
                        (it.first as Result.Success<List<DomainEntity.NewsInfo>>).value
                    val secondResponse =
                        (it.second as Result.Success<List<DomainEntity.NewsInfo>>).value
                    firstResponse.toMutableList().apply {
                        addAll(count(), secondResponse)
                    }.also {
                        _resultStateLive.postValue(ResultState.NewsList(it))
                    }
                } else {
                    _resultStateLive.postValue(ResultState.ToastMessage((it.first as Result.Error).error.message.orEmpty()))
                }
            }
        }
    }
}

