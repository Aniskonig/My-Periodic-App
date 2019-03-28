package com.medanis.myperiodicapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast





class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.i("TAG","/////////////////// SHOW TOAST NOW //////////////////////")

        Toast.makeText(context,"This toast will be shown every X minutes", Toast.LENGTH_LONG).show()
    }
}