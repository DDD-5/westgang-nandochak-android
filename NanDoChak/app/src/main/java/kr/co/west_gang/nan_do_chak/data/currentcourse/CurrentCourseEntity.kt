package kr.co.west_gang.nan_do_chak.data.currentcourse

import android.content.IntentSender
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kr.co.west_gang.nan_do_chak.data.user.UserEntity

/*
* Created by JJJoonngg
*/

@Entity(
    tableName = "current_course",
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = arrayOf("uid"),
        childColumns = arrayOf("uid"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class CurrentCourseEntity(
    @PrimaryKey @ColumnInfo(name = "course_id") val courseId: String,
    val uid: String,
    @ColumnInfo(name = "start_point") val startPoint: String,
    @ColumnInfo(name = "end_point") val endPoint: String,
    val arrived: Boolean,
    @ColumnInfo(name = "promise_time") val promiseTime: String,
    @ColumnInfo(name = "progress_time") val progressTime: String,
    @ColumnInfo(name = "time_safe") val timeSafe: Boolean,
    val finished: Boolean
)