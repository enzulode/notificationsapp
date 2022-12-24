package com.enzulode.notificationapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat

class NotificationReceiver : BroadcastReceiver()
{
	override fun onReceive(context: Context?, intent: Intent?)
	{
		Toast.makeText(context, "Notification clicked", Toast.LENGTH_SHORT).show()

		val notificationManagerCompat: NotificationManagerCompat = NotificationManagerCompat.from(context!!)
		notificationManagerCompat.cancel(1)
	}

}