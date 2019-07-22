package com.mindev.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.common.ErrorMessage
import com.common.Result
import com.mindev.domain.entity.DomainEntity
import com.mindev.domain.news.NewsUseCase
import com.mindev.presentation.MinDevViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

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

    // not used
    override fun errorListener(coroutineContext: CoroutineContext, message: Throwable) {
        // sample errorListener
    }

    fun getNewsInfo(input: String) {
        if (input.isEmpty()) {
            _resultStateLive.postValue(ResultState.ToastMessage(ErrorMessage.ERROR_EMPTY_INPUT))
            return
        }
        viewModelScope.launch(Dispatchers.Default + errorHandler) {
            _isLoading.postValue(true)
            val request = newsUseCase.execute(NewsUseCase.Params(1))
            _isLoading.postValue(false)
            if (request is Result.Success) _resultStateLive.postValue(ResultState.NewsList(request.value))
            else _resultStateLive.postValue(ResultState.ToastMessage(ErrorMessage.ERROR_NETWORK))
        }
    }
}

