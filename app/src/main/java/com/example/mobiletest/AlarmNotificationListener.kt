package com.example.mobiletest

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class AlarmNotificationListener : NotificationListenerService() {

    override fun onNotificationPosted(sbn: StatusBarNotification) {

        val notification = sbn.notification

        Log.d("SNOOZEBOT", "Notification received!")
        Log.d("SNOOZEBOT", "Package: ${sbn.packageName}")

        val title = notification.extras.getString("android.title")
        val text = notification.extras.getCharSequence("android.text")

        Log.d("SNOOZEBOT", "Title: $title")
        Log.d("SNOOZEBOT", "Text: $text")

        val actions = notification.actions

        if (actions != null) {

            for (action in actions) {

                val actionTitle = action.title.toString()

                Log.d(
                    "SNOOZEBOT",
                    "Action found: $actionTitle"
                )

                // Look for the "Remind me later" action
                if (actionTitle.equals("Remind me later", ignoreCase = true)) {

                    Log.d(
                        "SNOOZEBOT",
                        "REMIND ME LATER FOUND! Triggering it..."
                    )

                    try {
                        action.actionIntent.send()

                        Log.d(
                            "SNOOZEBOT",
                            "Action triggered successfully! 😴"
                        )

                    } catch (e: Exception) {

                        Log.e(
                            "SNOOZEBOT",
                            "Could not trigger action",
                            e
                        )
                    }
                }
            }
        }
    }
}