package com.example.mycosusample

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.app.admin.DevicePolicyManager
import android.app.admin.SystemUpdatePolicy
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.BatteryManager
import android.os.Build
import android.os.Bundle
import android.os.UserManager
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mDevicePolicyManager: DevicePolicyManager
    private lateinit var mAdminComponentName: ComponentName


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button0 = findViewById<View>(R.id.button0) as Button
        val button1 = findViewById<View>(R.id.button1) as Button
        val button2 = findViewById<View>(R.id.button2) as Button

        button0.setOnClickListener {
            val intent = Intent(this, Activity0::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
        button1.setOnClickListener {
            val intent = Intent(this, Activity1::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
        button2.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
        }

        mDevicePolicyManager =
            getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager

        if (mDevicePolicyManager.isLockTaskPermitted(this.packageName)) {
            val am = getSystemService(
                Context.ACTIVITY_SERVICE
            ) as ActivityManager
            if (am.lockTaskModeState ==
                ActivityManager.LOCK_TASK_MODE_NONE
            ) {
                startLockTask()
            }
            else{
//                Toast.makeText(
//                    applicationContext,
//                    "Lock task failed", Toast.LENGTH_LONG
//                )
//                    .show()
            }
        }
    }




}