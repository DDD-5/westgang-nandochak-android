package kr.co.west_gang.nan_do_chak.data.dto

import kr.co.west_gang.nan_do_chak.util.AppConfig.TAG_DEBUG
import kr.co.west_gang.nan_do_chak.util.logD

/*
* Created by JJJoonngg
*/

object UserInfoDto {
    var kakaoToken = ""
    var nickname = ""
    var averageReadyTime = ""
    var earlyArrivedTime = ""

    fun printUserInfo() {
        logD(
            TAG_DEBUG,
            "UserInfo : kakaoToken : $kakaoToken , nickName : $nickname , averageReadyTime: $averageReadyTime, earlyArrivedTime:  $earlyArrivedTime"
        )
    }
}