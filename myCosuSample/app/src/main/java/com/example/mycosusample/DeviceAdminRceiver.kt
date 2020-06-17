package com.example.mycosusample

import android.content.ComponentName
import android.content.Context

class DeviceAdminReceiver : android.app.admin.DeviceAdminReceiver() {

    companion object{
        val TAG = "DeviceAdministrator"
        fun getComponentName(context: Context): ComponentName {
            return ComponentName(context.applicationContext, DeviceAdminReceiver::class.java)
        }
    }

    /**
     * @param context The context of the application.
     * @return The component name of this component in the given context.
     */
}