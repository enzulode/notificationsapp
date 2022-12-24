package com.enzulode.notificationapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.View
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

	private fun showNotification()
	{
		val notificationBuilder: NotificationCompat.Builder = NotificationCompat
			.Builder(this, getString(R.string.notification_channel_id))

		notificationBuilder
			.setSmallIcon(R.drawable.ic_launcher_background)
			.setContentTitle(getString(R.string.notification_title))
			.setContentText("This is default notification")

		notificationManagerCompat.notify(1, notificationBuilder.build())
	}
}