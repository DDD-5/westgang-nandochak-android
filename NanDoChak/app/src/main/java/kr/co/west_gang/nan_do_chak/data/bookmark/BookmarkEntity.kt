package kr.co.west_gang.nan_do_chak.data.bookmark

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kr.co.west_gang.nan_do_chak.data.user.UserEntity

/*
* Created by JJJoonngg
*/

@Entity(
    tableName = "bookmark",
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = arrayOf("uid"),
        childColumns = arrayOf("uid"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class BookmarkEntity(
    @PrimaryKey @ColumnInfo(name = "document_id") val documentId: String,
    val uid: String,
    val name: String,
    @ColumnInfo(name = "course_id") val courseId: String
)