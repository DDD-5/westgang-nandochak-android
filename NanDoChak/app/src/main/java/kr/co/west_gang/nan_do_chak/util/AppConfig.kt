package kr.co.west_gang.nan_do_chak.util

import kr.co.west_gang.nan_do_chak.R

/*
* Created by JJJoonngg
*/

object AppConfig {
    var isDebugMode = NanDoChakApplication.getBoolean(R.bool.isDebug)

    const val TAG_DEBUG = "TAG_DEBUG"
    const val UNCAUGHT_EXCEPTION = "uncaught_exception"

    const val FRAGMENT_ID_HOME = "homeFragment"
    const val FRAGMENT_ID_ALARM = "alarmFragment"
    const val FRAGMENT_ID_ACCOUNT = "accountFragment"

    const val INTENT_PARAM_NICK_NAME = "nickName"
}