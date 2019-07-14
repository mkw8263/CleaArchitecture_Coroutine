package com.common

sealed class Either<out L, out R> {
    data class Left<out L>(val a: L) : Either<L, Any>()
    data class Right<out R>(val b: R) : Either<Any, R>()

    val isRight get() = this is Right<R>
    val isLeft get() = this is Left<L>

    fun either(fL: (L) -> Any, fR: (R) -> Any): Any = {
        when (this) {
            is Left -> fL(a)
            is Right -> fR(b)
        }
    }
}