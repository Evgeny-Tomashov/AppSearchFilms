package com.devtomashov.appsearchfilms.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.devtomashov.appsearchfilms.data.entity.Film
import com.devtomashov.appsearchfilms.view.notifications.NotificationConstants
import com.devtomashov.appsearchfilms.view.notifications.NotificationHelper

class ReminderBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val bundle = intent?.getBundleExtra(NotificationConstants.FILM_BUNDLE_KEY)
        val film: Film = bundle?.get(NotificationConstants.FILM_KEY) as Film

        NotificationHelper.createNotification(context!!, film)
    }
}