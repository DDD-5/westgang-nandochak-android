package kr.co.west_gang.nan_do_chak.data.table.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
* Created by JJJoonngg
*/

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val uid: String,
    @ColumnInfo(name = "kakao_id") val kakaoId: String,
    val nickname: String,
    @ColumnInfo(name = "average_ready_time") val averageReadyTime: String,
    @ColumnInfo(name = "early_arrive_time") val earlyArrivedTime: String,
    @ColumnInfo(name = "market_terms") val marketTerms: Boolean,
    @ColumnInfo(name = "third_party_terms") val thirdPartyTerms: Boolean
)