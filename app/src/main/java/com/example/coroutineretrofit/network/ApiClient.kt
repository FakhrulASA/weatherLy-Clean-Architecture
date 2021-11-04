package com.example.coroutineretrofit.network

import com.example.coroutineretrofit.util.Either
import com.example.coroutineretrofit.util.Failure
import com.example.coroutineretrofit.util.SOMETHING_WENT_WRONG
import retrofit2.Call

class ApiClient {
    fun <T, R> request(
        call: Call<T>,
        transform: (T) -> R,
        default: T,
        postRequest: (R) -> Unit = {}
    ): Either<Failure, R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> {
                    val transformed = transform((response.body() ?: default))
                    postRequest(transformed)
                    Either.Right(transformed)
                }
                false -> Either.Left(
                    getFailureType(
                        response.code(),
                        response.errorBody()?.string()!!
                    )
                )
            }
        } catch (exception: Throwable) {
            exception.printStackTrace()
            Either.Left(Failure.Exception(exception.message ?: SOMETHING_WENT_WRONG))
        }
    }

    private fun getFailureType(httpCode: Int, message: String): Failure {
        return when (httpCode) {
            401 -> return Failure.UnauthorizedError(message)
            400 -> return Failure.RequestError(httpCode, message)
            in 402..409 -> return Failure.RequestError(httpCode, message)
            in 500..509 -> return Failure.ServerError(httpCode, message)
            else -> Failure.GenericError(httpCode, message)
        }
    }

}