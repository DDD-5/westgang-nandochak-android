package kr.co.west_gang.nan_do_chak.util

import kr.co.west_gang.nan_do_chak.R

/*
* Created by JJJoonngg
*/

object AppConfig {
    var isDebugMode = NanDoChakApplication.getBoolean(R.bool.isDebug)

    const val TAG_DEBUG = "TAG_DEBUG"
    const val UNCAUGHT_EXCEPTION = "uncaught_exception"
}