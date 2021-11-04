package com.example.coroutineretrofit.interactor

import com.example.coroutineretrofit.util.Either
import com.example.coroutineretrofit.util.Failure
import kotlinx.coroutines.*

abstract class UseCase<out Type, in Params> where Type : Any {

    private val mainJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + mainJob)

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) =
        uiScope.launch { onResult(withContext(Dispatchers.IO) { run(params) }) }

    class None
}