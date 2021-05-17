package kr.co.west_gang.nan_do_chak.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.co.west_gang.nan_do_chak.data.NanDoChakDatabase
import kr.co.west_gang.nan_do_chak.data.table.bookmark.BookmarkDao
import kr.co.west_gang.nan_do_chak.data.table.currentcourse.CurrentCourseDao
import kr.co.west_gang.nan_do_chak.data.table.user.UserDao
import javax.inject.Singleton

/*
* Created by JJJoonngg
*/

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideBookmarkDao(database: NanDoChakDatabase): BookmarkDao = database.bookmarkDao()

    @Provides
    fun provideCurrentCourseDao(database: NanDoChakDatabase): CurrentCourseDao = database.currentCourseDao()

    @Provides
    fun provideUserDao(database: NanDoChakDatabase): UserDao = database.userDao()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): NanDoChakDatabase {
        return Room.databaseBuilder(
                appContext,
                NanDoChakDatabase::class.java,
                "NanDoChak.db"
        ).build()
    }
}