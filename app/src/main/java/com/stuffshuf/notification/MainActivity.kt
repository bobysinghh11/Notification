package com.stuffshuf.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val nm=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {nm.createNotificationChannel(NotificationChannel("first", "default", NotificationManager.IMPORTANCE_DEFAULT))
        }

        val simpleNotification=NotificationCompat.Builder(this, "default")
            .setContentTitle("Simple Title")
            .setContentText("This is sample content of a simple notification")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

               nm.notify(1, simpleNotification)

    }

}
