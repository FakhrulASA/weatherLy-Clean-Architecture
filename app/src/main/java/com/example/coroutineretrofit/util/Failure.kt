package com.example.coroutineretrofit.util

/**
 * Base Class for handling errors/failures/exceptions.
 * Every feature specific failure should extend [FeatureFailure] class.
 */

const val NO_INTERNET = "Device is not connected to the internet"
const val NOT_LOGGED_IN = "You are not logged in"
const val SOMETHING_WENT_WRONG = "Something went wrong"

sealed class Failure {
    companion object {
        fun getNoInternetFailureMessage(isLanguageEnglish: String): String =
            when (isLanguageEnglish == "en") {
                true -> {
                    "Internet not available."
                }
                else -> {
                    "ইন্টারনেট সংযোগ নেই"
                }
            }

        fun getNoInternetFailureMessage(isLanguageEnglish: Boolean): String =
            when (isLanguageEnglish) {
                true -> {
                    "Internet not available."
                }
                else -> {
                    "ইন্টারনেট সংযোগ নেই"
                }
            }
    }


    class NetworkConnection(val message: String = NO_INTERNET) : Failure()
    class Exception(val message: String = SOMETHING_WENT_WRONG) : Failure()
    class UnauthorizedError(val message: String = SOMETHING_WENT_WRONG) : Failure()
    class RequestError(var httpCode: Int = 0, val message: String = SOMETHING_WENT_WRONG) :
        Failure()

    class ServerError(val httpCode: Int = 0, val message: String = SOMETHING_WENT_WRONG) : Failure()
    class GenericError(val httpCode: Int = 0, val message: String = SOMETHING_WENT_WRONG) :
        Failure()


    /** * Extend this class for feature specific failures.*/
    sealed class FeatureFailure : Failure() {
        class LoginFailure(var message: String = "Failed to login. Make sure to entered your valid information") :
            FeatureFailure()
    }


}