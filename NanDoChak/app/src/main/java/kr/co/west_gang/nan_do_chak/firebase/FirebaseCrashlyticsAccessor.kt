package kr.co.west_gang.nan_do_chak.firebase

import com.google.firebase.crashlytics.FirebaseCrashlytics
import kr.co.west_gang.nan_do_chak.util.AppConfig
import kr.co.west_gang.nan_do_chak.util.AppConfig.TAG_DEBUG
import kr.co.west_gang.nan_do_chak.util.logE
import java.util.concurrent.CancellationException

/*
* Created by JJJoonngg
*/


object FirebaseCrashlyticsAccessor {
    private val crashlyticsInstance = FirebaseCrashlytics.getInstance()

    fun reportWithException(exception: Exception, params: Map<String, Any> = mapOf()) {
        if (AppConfig.isDebugMode) {
            printExceptionDebugMode(exception, params)
            return
        }

        for ((key, value) in convertCustomKeys(params)) {
            setCustomKey(key, value)
        }

        // TODO : User NickName 입력하기.
        //crashlyticsInstance.setUserId()
        crashlyticsInstance.recordException(exception)
    }

    private fun printExceptionDebugMode(exception: Exception, params: Map<String, Any>) {
        logE(TAG_DEBUG, "error message: ${exception.stackTraceToString()}")
        for (param in params) {
            logE(TAG_DEBUG, "params: (${param.key}, ${param.value})")
        }
    }

    private fun convertCustomKeys(params: Map<String, Any>): MutableMap<String, Comparable<*>> {
        val convertedParams: MutableMap<String, Comparable<*>> = mutableMapOf()
        params.forEach { (key, value) ->
            if (value is Comparable<*>) {
                convertedParams[key] = value
            }
        }

        return convertedParams
    }

    private fun <T> setCustomKey(customKeyName: String, customKeyValue: Comparable<T>): Boolean {
        return when (customKeyValue) {
            is String -> {
                crashlyticsInstance.setCustomKey(customKeyName, customKeyValue)
                true
            }
            is Int -> {
                crashlyticsInstance.setCustomKey(customKeyName, customKeyValue)
                true
            }
            is Long -> {
                crashlyticsInstance.setCustomKey(customKeyName, customKeyValue)
                true
            }
            is Boolean -> {
                crashlyticsInstance.setCustomKey(customKeyName, customKeyValue)
                true
            }
            is Float -> {
                crashlyticsInstance.setCustomKey(customKeyName, customKeyValue)
                true
            }
            is Double -> {
                crashlyticsInstance.setCustomKey(customKeyName, customKeyValue)
                true
            }
            else -> {
                logE(TAG_DEBUG, "Invalid InputData : ", customKeyValue)
                false
            }
        }
    }

}