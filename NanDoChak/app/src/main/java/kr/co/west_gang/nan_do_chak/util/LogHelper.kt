package kr.co.west_gang.nan_do_chak.util

import com.orhanobut.logger.Logger

/*
* Created by JJJoonngg
*/

fun logD(tag: String, any: Any?) {
    Logger.t(tag)
    Logger.d(any)
}

fun logD(tag: String, message: String?, arg: Any?) {
    Logger.t(tag)
    Logger.d("$message, %s", arg)
}

fun logD(any: Any?) {
    Logger.d(any)
}

fun logE(tag: String, message: String?) {
    Logger.t(tag)
    if (message != null) {
        Logger.e(message)
    }
}

fun logE(message: String?) {
    if (message != null) {
        Logger.e(message)
    }
}

fun logE(tag: String, message: String?, arg: Any?) {
    Logger.t(tag)
    Logger.e("$message, %s", arg)
}

fun logW(tag: String, message: String?) {
    Logger.t(tag)
    if (message != null) {
        Logger.w(message)
    }
}


fun logW(tag: String, message: String?, arg: Any?) {
    Logger.t(tag)
    Logger.w("$message, %s", arg)
}

fun logI(tag: String, message: String?) {
    Logger.t(tag)
    if (message != null) {
        Logger.i(message)
    }
}

fun logI(tag: String, message: String?, arg: Any?) {
    Logger.t(tag)
    Logger.i("$message, %s", arg)
}


fun logV(tag: String, message: String?) {
    Logger.t(tag)
    if (message != null) {
        Logger.v(message)
    }
}

fun logV(tag: String, message: String?, arg: Any?) {
    Logger.t(tag)
    Logger.v("$message, %s", arg)
}

fun logWtf(tag: String, message: String?) {
    Logger.t(tag)
    if (message != null) {
        Logger.wtf(message)
    }
}

fun logWtf(tag: String, message: String?, arg: Any?) {
    Logger.t(tag)
    Logger.wtf("$message, %s", arg)
}
