package com.enzulode.notificationapp.app

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.enzulode.notificationapp.R

class App : Application()
{
	
	private var notificationManager: NotificationManager? = null

	override fun onCreate()
	{
		super.onCreate()
		notificationChannelInit()
	}

	private fun notificationChannelInit()
	{
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
		{
			val name = getString(R.string.notification_channel_name)
			val descriptionText = getString(R.string.notification_channel_description)
			val importance = NotificationManager.IMPORTANCE_HIGH
			val mChannel = NotificationChannel(getString(R.string.notification_channel_id), name, importance)
			mChannel.description = descriptionText
			notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
			notificationManager!!.createNotificationChannel(mChannel)
		}
	}

}