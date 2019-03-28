package com.medanis.myperiodicapp

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private var mAlarmManager : AlarmManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn.setOnClickListener {
            val mIntent = Intent(this, MyReceiver::class.java)

            val mPendingIntent = PendingIntent.getBroadcast(this, 0, mIntent, PendingIntent.FLAG_UPDATE_CURRENT)

//            mAlarmManager!!.setRepeating(
//                    AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),
//                    60000, mPendingIntent
//            )
            if (Build.VERSION.SDK_INT >= 23) {
                mAlarmManager = this
                        .getSystemService(Context.ALARM_SERVICE) as AlarmManager
                mAlarmManager!!.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, 60000, mPendingIntent)
            } else if (Build.VERSION.SDK_INT >= 19) {
                mAlarmManager = this
                        .getSystemService(Context.ALARM_SERVICE) as AlarmManager
                mAlarmManager!!.setExact(AlarmManager.RTC_WAKEUP, 60000, mPendingIntent)
            } else {
                mAlarmManager = this
                        .getSystemService(Context.ALARM_SERVICE) as AlarmManager
                mAlarmManager!!.set(AlarmManager.RTC_WAKEUP, 60000, mPendingIntent)
            }

        }
    }
}


