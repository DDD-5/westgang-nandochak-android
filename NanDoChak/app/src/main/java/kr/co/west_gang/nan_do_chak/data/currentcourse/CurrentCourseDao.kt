package kr.co.west_gang.nan_do_chak.data.currentcourse

import androidx.room.Dao
import androidx.room.Query
import kr.co.west_gang.nan_do_chak.data.BaseDao

/*
* Created by JJJoonngg
*/

@Dao
interface CurrentCourseDao : BaseDao<CurrentCourseEntity> {

    @Query("SELECT * FROM current_course WHERE course_id =:courseId")
    suspend fun readCurrentCourse(courseId: String): CurrentCourseEntity

    @Query("SELECT * FROM current_course WHERE uid =:userId")
    suspend fun readAllCurrentCourseByUserId(userId: String): List<CurrentCourseEntity>

    @Query("DELETE FROM current_course WHERE course_id=:courseId")
    suspend fun deleteCurrentCourse(courseId: String)
}