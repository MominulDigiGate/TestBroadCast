package com.usb.androidtestmominul

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.AUDIO_SERVICE
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.RingtoneManager


class MyReceiver : BroadcastReceiver() {
    private val ACTION_SIM_STATE_CHANGED = "android.intent.action.SIM_STATE_CHANGED"
    private val ACTION_VOLUME = "android.media.VOLUME_CHANGED_ACTION"
    private val EXTRA_SIM_STATE = "ss"
    private val SIM_STATE_LOADED = "LOADED"
    private var mp: MediaPlayer? = null

    override fun onReceive(context: Context, intent: Intent) {
        logPrint(intent.action)
//        logPrint(intent.extras)

//        // Declare an audio manager
//        val audioManager = context.getSystemService(AUDIO_SERVICE) as AudioManager
//
//        // on below line we are creating variables for
//        // volume level, max volume, volume percent.
//        var volumeLevel = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
//        var maxVolumeLevel = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
//        var volumePercent = (volumeLevel.toFloat() / maxVolumeLevel * 100).toInt()
//
//        logPrint(volumeLevel)
//        logPrint(maxVolumeLevel)
//        logPrint(volumePercent)
//
//        val alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
//
//        if (mp == null) {
//            mp = MediaPlayer.create(context, alarmSound)
//
////            mp!!.setOnCompletionListener { mp ->
////                mp.start()
////            }
//        }
//
//        if (!mp!!.isPlaying)
//            mp!!.start()
//
//        if (mp!!.isPlaying)
//            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 20, 0)
//
//        if (mp!!.isPlaying && intent.action!!.equals(ACTION_VOLUME))
//            logPrint("Increase Volume Again")
    }
}