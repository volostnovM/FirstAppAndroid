package ru.netology.nmedia.workers

import android.app.Application
import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.tasks.await
import ru.netology.nmedia.api.PostsApiService
import ru.netology.nmedia.dto.PushToken
import javax.inject.Inject

class SendPushTokenWorker @Inject constructor(
    @ApplicationContext
    private val context: Context,
    workerParametrs: WorkerParameters
) : CoroutineWorker(
    context,
    workerParametrs
) {
    companion object {
        const val NAME_WORKER = "SendPushTokenWorker"
        const val TOKEN_KEY = "TOKEN_KEY"
    }

    @InstallIn(SingletonComponent::class)
    @EntryPoint
    interface AppAuthEntryPoint {
        fun getApiService(): PostsApiService
    }

    override suspend fun doWork(): Result =
        try {
            val token = inputData.getString(TOKEN_KEY)

            val pushToken = PushToken(token ?: FirebaseMessaging.getInstance().token.await())
            val entryPoint = EntryPointAccessors.fromApplication(context, AppAuthEntryPoint::class.java)
            entryPoint.getApiService().sendPushToken(pushToken)

            Result.success()
        } catch (e: Exception) {
            e.printStackTrace()
            Result.retry()
        }


}