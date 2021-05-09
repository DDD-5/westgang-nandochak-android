package kr.co.west_gang.nan_do_chak.data

import androidx.room.Database
import androidx.room.RoomDatabase
import kr.co.west_gang.nan_do_chak.data.bookmark.BookmarkEntity
import kr.co.west_gang.nan_do_chak.data.currentcourse.CurrentCourseDao
import kr.co.west_gang.nan_do_chak.data.currentcourse.CurrentCourseEntity
import kr.co.west_gang.nan_do_chak.data.user.UserDao
import kr.co.west_gang.nan_do_chak.data.user.UserEntity

/*
* Created by JJJoonngg
*/

@Database(
    entities = [
        UserEntity::class,
        CurrentCourseEntity::class,
        BookmarkEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class NanDoChakDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun currentCourseDao(): CurrentCourseDao

}