package ru.netology.nmedia.service

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.Gson
import ru.netology.nmedia.R
import ru.netology.nmedia.activity.AppActivity
import ru.netology.nmedia.auth.AppAuth
import kotlin.random.Random


class FCMService : FirebaseMessagingService() {
    private val action = "action"
    private val content = "content"
    private val channelId = "remote"
    private val gson = Gson()

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_remote_name)
            val descriptionText = getString(R.string.channel_remote_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

    override fun onMessageReceived(message: RemoteMessage) {
        Log.d("FCMService", message.data.toString())
//        try {
//            message.data[action]?.let {
//                when (Action.valueOf(it)) {
//                    Action.LIKE -> handleLike(
//                        gson.fromJson(
//                            message.data[content],
//                            Like::class.java
//                        )
//                    )
//
//                    Action.POST -> handleNewPost(
//                        gson.fromJson(
//                            message.data[content],
//                            NewPost::class.java
//                        )
//                    )
//                }
//            }
//        } catch (error: IllegalArgumentException) {
//            errorAction(gson.fromJson(message.data[content], ErrorAction::class.java))
//        }

        val id = AppAuth.getInstance().authState.value.id
        val recipientId = message.data["recipientId"]?.toLong()
        when (recipientId) {
            0L -> AppAuth.getInstance().sendPushToken()
            id, null -> handleMessage(gson.fromJson(message.data[content], PushMessage::class.java))
            else -> AppAuth.getInstance().sendPushToken()
        }
    }

    private fun handleMessage(content: PushMessage) {
        val intent = Intent(this, AppActivity::class.java)
        val pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val notification = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(
                getString(
                    R.string.notification_user,
                    content.recipientId.toString(),
                    content.content,
                )
            )
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pi)
            .setAutoCancel(true)
            .build()

        notify(notification)
    }

    override fun onNewToken(token: String) {
        AppAuth.getInstance().sendPushToken(token)
    }

    private fun handleLike(content: Like) {
        val intent = Intent(this, AppActivity::class.java)
        val pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val notification = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(
                getString(
                    R.string.notification_user_liked,
                    content.userName,
                    content.postAuthor,
                )
            )
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pi)
            .setAutoCancel(true)
            .build()

        notify(notification)
    }

    private fun handleNewPost(content: NewPost) {
        val notifyPendingIntent = PendingIntent.getActivity(
            this, 0, Intent(this, AppActivity::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        val notification = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(
                getString(
                    R.string.notification_user_new_posted,
                    content.postAuthor
                )
            )
            .setStyle(NotificationCompat.BigTextStyle().bigText(content.postContent))
            .setAutoCancel(true)
            .setContentIntent(notifyPendingIntent)
            .build()

        notify(notification)
    }

    private fun errorAction(content: ErrorAction) {
        val notifyPendingIntent = PendingIntent.getActivity(
            this, 0, Intent(this, AppActivity::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        val notification = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(
                getString(
                    R.string.error_action_title,
                )
            )
            .setContentText(
                content.textErrorAction
            )
            .setAutoCancel(true)
            .setContentIntent(notifyPendingIntent)
            .build()

        notify(notification)
    }

    private fun notify(notification: Notification) {
        if (
            Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU ||
            checkSelfPermission(
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(this)
                .notify(Random.nextInt(100_000), notification)
        }
    }
}

enum class Action {
    LIKE,
    POST
}

data class Like(
    val userId: Long,
    val userName: String,
    val postId: Long,
    val postAuthor: String,
)

data class NewPost(
    val postId: Long,
    val postAuthor: String,
    val postContent: String
)

data class ErrorAction(
    val textErrorAction: String = "Update your app"
)

data class PushMessage(
    val recipientId: Long?,
    val content: String
)