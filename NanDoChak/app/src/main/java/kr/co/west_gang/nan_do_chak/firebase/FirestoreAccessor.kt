package kr.co.west_gang.nan_do_chak.firebase

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withTimeout
import kr.co.west_gang.nan_do_chak.data.dto.UserInfoDto
import kr.co.west_gang.nan_do_chak.firebase.FirestoreConfig.FIRESTORE_PATH_USER
import kr.co.west_gang.nan_do_chak.firebase.FirestoreConfig.FIRESTORE_READ_TIMEOUT
import kr.co.west_gang.nan_do_chak.firebase.FirestoreConfig.UserExistCheck
import kr.co.west_gang.nan_do_chak.util.AppConfig.TAG_DEBUG
import kr.co.west_gang.nan_do_chak.util.logD
import java.lang.Exception

/*
* Created by JJJoonngg
*/

object FirestoreAccessor {
    private fun getFirestoreInstance() = FirebaseFirestore.getInstance()

    suspend fun isExistUserTokenInFireStore(kakaoId: String): UserExistCheck {
        return try {
            withTimeout(FIRESTORE_READ_TIMEOUT) {
                val data = getFirestoreInstance()
                    .collection(FIRESTORE_PATH_USER)
                    .document(kakaoId)
                    .get()
                    .await()
                if (data.exists()) {
                    UserExistCheck.EXIST
                } else {
                    UserExistCheck.NOT_EXIST
                }
            }
        } catch (e: CancellationException) {
            logD(TAG_DEBUG, "timeout when user exist judge : $e")
            UserExistCheck.ERROR
        } catch (e: Exception) {
            FirebaseCrashlyticsAccessor.reportWithException(e)
            UserExistCheck.ERROR
        }
    }

    suspend fun createUserInfoInFirestore(userInfoDto: UserInfoDto): Boolean {
        return try {
            withTimeout(FIRESTORE_READ_TIMEOUT) {
                getFirestoreInstance()
                    .collection(FIRESTORE_PATH_USER)
                    .document(userInfoDto.kakaoId)
                    .set(userInfoDto).await()
                true
            }
        } catch (e: Exception) {
            FirebaseCrashlyticsAccessor.reportWithException(e)
            false
        }
    }

    suspend fun readUserInfoInFirestore(token: String): UserInfoDto? {
        return try {
            withTimeout(FIRESTORE_READ_TIMEOUT) {
                val data = getFirestoreInstance()
                    .collection(FIRESTORE_PATH_USER)
                    .document(token)
                    .get()
                    .await()
                data.toObject(UserInfoDto::class.java)
            }
        } catch (e: Exception) {
            FirebaseCrashlyticsAccessor.reportWithException(e)
            null
        }
    }
}

object FirestoreConfig {
    const val FIRESTORE_PATH_USER = "user"
    const val FIRESTORE_PATH_BOOK_MARK = "book_mark"
    const val FIRESTORE_PATH_COURSE = "course"

    const val FIRESTORE_READ_TIMEOUT = 60L * 1000L

    enum class UserExistCheck {
        NONE,
        EXIST,
        NOT_EXIST,
        ERROR
    }
}