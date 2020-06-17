package com.example.mycosusample

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Activity1 : AppCompatActivity() {
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)
        val am = getSystemService(
            Context.ACTIVITY_SERVICE
        ) as ActivityManager
        if (am.lockTaskModeState ==
            ActivityManager.LOCK_TASK_MODE_NONE
        ) {
            //startLockTask()
        }
        else{
                Toast.makeText(
                    applicationContext,
                    "Lock task failed", Toast.LENGTH_LONG
                )
                    .show()
        }

    }
}