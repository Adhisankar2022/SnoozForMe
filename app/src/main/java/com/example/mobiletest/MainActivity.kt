package com.example.mobiletest

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val preferences = getSharedPreferences(
            "snoozebot",
            MODE_PRIVATE
        )

        setContent {

            var delaySeconds by remember {
                mutableStateOf(
                    preferences
                        .getInt("delay_seconds", 10)
                        .toString()
                )
            }

            var savedMessage by remember {
                mutableStateOf("")
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "😴 SnoozeBot"
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Text(
                    text = "This app automatically snoozes your alarms."
                )

                Spacer(
                    modifier = Modifier.height(30.dp)
                )

                Text(
                    text = "Snooze delay"
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                OutlinedTextField(
                    value = delaySeconds,
                    onValueChange = { newValue ->

                        if (
                            newValue.isEmpty() ||
                            newValue.all { it.isDigit() }
                        ) {
                            delaySeconds = newValue
                            savedMessage = ""
                        }
                    },
                    label = {
                        Text("Seconds")
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Button(
                    onClick = {

                        val seconds =
                            delaySeconds.toIntOrNull() ?: 10

                        preferences.edit()
                            .putInt(
                                "delay_seconds",
                                seconds
                            )
                            .apply()

                        savedMessage =
                            "Saved: $seconds seconds ✅"
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Save Delay")
                }

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = savedMessage
                )

                Spacer(
                    modifier = Modifier.height(25.dp)
                )

                Button(
                    onClick = {
                        startActivity(
                            Intent(
                                Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS
                            )
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Open Notification Settings")
                }
            }
        }
    }
}