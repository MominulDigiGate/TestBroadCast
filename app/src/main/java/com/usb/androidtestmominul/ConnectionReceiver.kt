package com.usb.androidtestmominul

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent


class ConnectionReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        logPrint(intent!!.action)

        if (intent.action.equals("com.usb.androidtestmominul.SOME_ACTION"))
            toastShow(context, "SOME_ACTION is received")
        else {
            if (haveNetwork(context)) {
                toastShow(context, "Network is connected")
            } else {
                toastShow(context, "Network is changed or reconnected")
            }
        }
    }
}