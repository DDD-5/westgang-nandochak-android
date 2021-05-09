package kr.co.west_gang.nan_do_chak.data.user

import androidx.room.Dao
import androidx.room.Query
import kr.co.west_gang.nan_do_chak.data.BaseDao

/*
* Created by JJJoonngg
*/

@Dao
interface UserDao : BaseDao<UserEntity> {
    @Query("SELECT * FROM user WHERE uid =:userId")
    suspend fun readUser(userId: String): UserEntity
}