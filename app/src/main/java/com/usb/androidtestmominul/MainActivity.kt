package com.usb.androidtestmominul

import android.Manifest
import android.content.Context
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.gson.Gson
import com.usb.androidtestmominul.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var REQ_READ_PHONE_STATE = 102
    private var REQ_READ_PHONE_NUMBERS = 103
    private var myReceiver = MyReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        doTask2()

    }

    private fun initView() {
        binding.tvClick.setOnClickListener {
            checkPermission1()
        }
    }

    private fun checkPermission1() {
        val permissionCheck =
            ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            val permission2 =
                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_NUMBERS)

            if (permission2 == PackageManager.PERMISSION_GRANTED) {
                doTask2()
            } else {

                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_PHONE_NUMBERS),
                    REQ_READ_PHONE_NUMBERS
                )
            }
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_PHONE_STATE),
                REQ_READ_PHONE_STATE
            )
        }

    }

    private fun doTask2() {

        registerReceiver(myReceiver, IntentFilter("android.intent.action.AIRPLANE_MODE"))
        registerReceiver(myReceiver, IntentFilter("android.intent.action.SIM_STATE_CHANGED"))
        registerReceiver(myReceiver, IntentFilter("android.intent.action.CONNECTIVITY_CHANGE"))
        registerReceiver(myReceiver, IntentFilter("android.media.VOLUME_CHANGED_ACTION"))


        registerReceiver(myReceiver, IntentFilter("android.intent.action.ACTION_SHUTDOWN"))
        registerReceiver(myReceiver, IntentFilter("android.intent.action.QUICKBOOT_POWEROFF"))

    }

    override fun onDestroy() {
        unregisterReceiver(myReceiver)
        super.onDestroy()
    }

    private fun doTask() {
        val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        Log.d("010101", Gson().toJson(telephonyManager.phoneType))

        val phoneNumber: String = if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_SMS
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_PHONE_NUMBERS
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_PHONE_STATE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            telephonyManager.getLine1Number()
        } else {
            ""
        }
        Log.d("010101", "EventSpy SIM simState : " + telephonyManager.simState) // Code IMEI
        Log.d("010101", "EventSpy SIM simState : " + telephonyManager.simState) // Code IMEI

        Log.d(
            "010101",
            "EventSpy SIM Network Operator Name : " + telephonyManager.networkOperatorName
        )
//        Log.d("010101", "EventSpy SIM Serial Number : " + telephonyManager.getSimSerialNumber())
//        Log.d("010101", "EventSpy SIM PhoneNumber : $phoneNumber") // Code IMEI

    }
}