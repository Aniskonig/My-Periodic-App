package com.medanis.myperiodicapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BootCompletedIntentReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if ("android.intent.action.BOOT_COMPLETED" == intent.action) {
            //Start your old broadcastreceiver
            MyReceiver()
        }
    }
}