# 😴 Snooze For Me

> Your personal alarm procrastinator 

Snooze For Me is an Android app that automatically presses the **"Remind me later"** button on your alarm notifications after a delay you choose.

Because apparently even pressing Snooze is too much work. 

---

## 🎯 What Does It Do?

Snooze For Me watches your alarm notifications and automatically triggers the **"Remind me later"** action after your selected delay.

For example:

**Alarm rings 🔔**

↓  

Wait 10 seconds ⏱️

↓

**Snooze automatically 😴**

No need to touch your phone.

---

## ✨ Features

- 😴 Automatic alarm snoozing
- ⏱️ Customizable snooze delay
- 🎚️ Delay from **1–60 seconds**
- 🔘 Enable/disable the bot
- 🔔 Notification Access status
- 📊 Snooze counter
- 📱 Simple and modern Android UI
- 😂 Built for the Useless Hackathon

### 🚧 Coming Soon

- 🎬 Surprise meme/video after 3 snoozes
- 🔊 Video with audio
- 🤯 More ridiculous surprises

---

## 🛠️ How It Works

Snooze For Me uses Android's **Notification Listener Service**.

When an alarm notification appears, the app checks its available notification actions.

If it finds:

> **Remind me later**

the app waits for the number of seconds selected by the user and triggers that action automatically.

---

## 📱 Setup

### 1. Install the APK

Download the latest APK from the **GitHub Releases** section.

### 2. Open Snooze For Me

Launch the app after installation.

### 3. Enable Notification Access

Tap:

**Enable Notification Access**

Then find **Snooze For Me** in Android's Notification Access settings and enable it.

### 4. Choose Your Delay

Use the slider to choose how long Snooze For Me should wait before automatically snoozing an alarm.

You can choose between:

**1–60 seconds**

### 5. Enable the Bot

Make sure the **Snooze For Me** switch is enabled.

You're ready! 🎉

---

## 😂 Example

Imagine your alarm goes off at:

**7:00 AM**

You set the delay to:

**10 seconds**

At 7:00 AM:

🔔 Alarm rings

**Snooze For Me:**  
*"Don't worry bro, I got this."* 😴

10 seconds later...

💤 **Alarm snoozed automatically**

---

## ⚠️ Important

Snooze For Me requires **Notification Access** to detect and interact with alarm notifications.

The app cannot automatically snooze alarms if Notification Access is disabled.

The exact notification action may also depend on the alarm/clock application and Android version being used.

---

## 🔐 Permissions

Snooze For Me does not require your contacts, camera, microphone, or location.

It requires:

- 🔔 Notification Listener Access

This allows the app to read notification information and interact with supported notification actions.

---

## 🧑‍💻 Built With

- **Kotlin**
- **Android Studio**
- **Jetpack Compose**
- **Material 3**
- **Android NotificationListenerService**

---

## 🚀 Future Ideas

- 🎬 Surprise video after 3 snoozes
- 🔊 Custom meme sounds
- 😂 Different memes for different snooze counts
- 🏆 "Snooze Champion" statistics
- 🤖 More chaotic alarm behavior

---

## 🏆 Useless Hackathon

Built for the **Useless Hackathon**.

The goal?

Make something completely unnecessary...

but somehow useful. 😂

---

## 📄 License

This project is open source and available under the MIT License.
