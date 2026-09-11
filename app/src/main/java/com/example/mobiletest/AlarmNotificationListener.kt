package com.example.mobiletest

import android.os.Handler
import android.os.Looper
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class AlarmNotificationListener : NotificationListenerService() {

    private val handler = Handler(Looper.getMainLooper())

    override fun onNotificationPosted(
        sbn: StatusBarNotification
    ) {

        val notification = sbn.notification

        Log.d(
            "SNOOZEBOT",
            "Notification from: ${sbn.packageName}"
        )

        val actions = notification.actions ?: return

        for (action in actions) {

            val actionTitle = action.title.toString()

            Log.d(
                "SNOOZEBOT",
                "Action found: $actionTitle"
            )

            if (
                actionTitle.equals(
                    "Remind me later",
                    ignoreCase = true
                )
            ) {

                val preferences =
                    getSharedPreferences(
                        "snoozebot",
                        MODE_PRIVATE
                    )

                val delaySeconds =
                    preferences.getInt(
                        "delay_seconds",
                        10
                    )

                Log.d(
                    "SNOOZEBOT",
                    "Alarm detected!"
                )

                Log.d(
                    "SNOOZEBOT",
                    "Snoozing in $delaySeconds seconds..."
                )

                handler.postDelayed({

                    try {

                        action.actionIntent.send()

                        Log.d(
                            "SNOOZEBOT",
                            "Alarm snoozed automatically! 😴"
                        )

                    } catch (e: Exception) {

                        Log.e(
                            "SNOOZEBOT",
                            "Failed to trigger Remind me later",
                            e
                        )
                    }

                }, delaySeconds * 1000L)

                break
            }
        }
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}