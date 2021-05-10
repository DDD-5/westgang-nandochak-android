package kr.co.west_gang.nan_do_chak.di

import android.content.Context
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import kr.co.west_gang.nan_do_chak.data.table.bookmark.BookmarkDao
import kr.co.west_gang.nan_do_chak.data.table.currentcourse.CurrentCourseDao
import kr.co.west_gang.nan_do_chak.data.table.user.UserDao
import kr.co.west_gang.nan_do_chak.util.NanDoChakApplication

/*
* Created by JJJoonngg
*/

@InstallIn(SingletonComponent::class)
@EntryPoint
interface DatabaseEntryPoint {
    fun userDao(): UserDao
    fun currentCourseDao(): CurrentCourseDao
    fun bookmarkDao(): BookmarkDao
}

fun getUserDao(): UserDao {
    return EntryPointAccessors.fromApplication(
            NanDoChakApplication.getAppContext(), DatabaseEntryPoint::class.java
    ).userDao()
}

fun getCurrentCourseDao(): CurrentCourseDao {
    return EntryPointAccessors.fromApplication(
            NanDoChakApplication.getAppContext(), DatabaseEntryPoint::class.java
    ).currentCourseDao()
}

fun getBookmarkDao(): BookmarkDao {
    return EntryPointAccessors.fromApplication(
            NanDoChakApplication.getAppContext(), DatabaseEntryPoint::class.java
    ).bookmarkDao()
}