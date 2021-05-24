package kr.co.west_gang.nan_do_chak.data.dto

/*
* Created by JJJoonngg
*/

data class UserInfoDto(
    var kakaoId: String,
    var nickname: String,
    var averageReadyTime: String,
    var earlyArrivedTime: String
) {
    constructor() : this(
        kakaoId = "",
        nickname = "",
        averageReadyTime = "",
        earlyArrivedTime = ""
    )
}