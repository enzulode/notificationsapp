package com.enzulode.notificationapp

import android.annotation.SuppressLint
import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.widget.RemoteViews
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.enzulode.notificationapp.ui.theme.NotificationAppTheme

class MainActivity : ComponentActivity()
{

	private lateinit var builder: Notification.Builder
	private lateinit var notificationManagerCompat: NotificationManagerCompat


	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		notificationManagerCompat = NotificationManagerCompat.from(this)


		setContent {
			NotificationAppTheme {
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				)
				{

					Box(
						modifier = Modifier
							.fillMaxSize(),
						contentAlignment = Alignment.Center,
					)
					{

						Button(
							onClick = { showNotification() }
						)
						{
							Text(
								text = "Notify",
								color = Color.Black
							)
						}

					}

				}
			}
		}
	}

	@SuppressLint("UnspecifiedImmutableFlag")
	private fun showNotification()
	{
		val notificationBuilder: NotificationCompat.Builder = NotificationCompat
			.Builder(this, getString(R.string.notification_channel_id))

		val collapsedView = RemoteViews(packageName, R.layout.notification_collapsed)
		val expandedView = RemoteViews(packageName, R.layout.notification_expanded)
		val headsupView = RemoteViews(packageName, R.layout.notification_headsup)

		val clickIntent =  Intent(this, NotificationReceiver::class.java)
		val clickPendingIntent = PendingIntent.getBroadcast(this, 0, clickIntent, 0)

		collapsedView.setTextViewText(R.id.notification_collapsed_title, "New notification")
		collapsedView.setOnClickPendingIntent(R.id.notification_collapsed_info, clickPendingIntent)

		notificationBuilder
			.setSmallIcon(R.drawable.ic_launcher_background)
			.setCustomContentView(collapsedView)
			.setCustomBigContentView(expandedView)
			.setCustomHeadsUpContentView(headsupView)
			.setOnlyAlertOnce(false)

		notificationManagerCompat.notify(1, notificationBuilder.build())
	}
}