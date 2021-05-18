package kr.co.west_gang.nan_do_chak.data.table.bookmark

import androidx.room.Dao
import androidx.room.Query
import kr.co.west_gang.nan_do_chak.data.table.BaseDao

/*
* Created by JJJoonngg
*/

@Dao
interface BookmarkDao :
    BaseDao<BookmarkEntity> {
    @Query("SELECT * FROM bookmark WHERE document_id =:documentId")
    suspend fun readBookmark(documentId: String): BookmarkEntity

    @Query("SELECT * FROM bookmark WHERE uid =:userId")
    suspend fun readAllBookmarkByUserId(userId: String): List<BookmarkEntity>

    @Query("DELETE FROM bookmark WHERE document_id=:documentId")
    suspend fun deleteBookmark(documentId: String)
}