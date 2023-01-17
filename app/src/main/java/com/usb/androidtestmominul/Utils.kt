package com.usb.androidtestmominul

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson


fun logPrint(any: Any?) {
    if (BuildConfig.DEBUG)
        Log.d("010101", "\n\nLogData = " + Gson().toJson(any) + "\n\n\n")
}

fun toastShow(ctx: Context, msg: String) {
    Toast.makeText(ctx, msg, Toast.LENGTH_LONG).show()
}

fun haveNetwork(ctx: Context): Boolean {
    val connectivityManager =
        ctx.getSystemService(Activity.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    } else {
        @Suppress("DEPRECATION") val networkInfo =
            connectivityManager.activeNetworkInfo ?: return false
        @Suppress("DEPRECATION")
        return networkInfo.isConnected
    }
}