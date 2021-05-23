package kr.co.west_gang.nan_do_chak.data

import kr.co.west_gang.nan_do_chak.util.AppConfig.TAG_DEBUG
import kr.co.west_gang.nan_do_chak.util.logD

/*
* Created by JJJoonngg
*/

object UserInfo {
    var kakaoId = ""
    var nickname = ""
    var averageReadyTime = ""
    var earlyArrivedTime = ""

    fun printUserInfo() {
        logD(
            TAG_DEBUG,
            "UserInfo : kakaoToken : $kakaoId , nickName : $nickname , averageReadyTime: $averageReadyTime, earlyArrivedTime:  $earlyArrivedTime"
        )
    }
}