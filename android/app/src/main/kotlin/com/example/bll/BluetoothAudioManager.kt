package com.example.bll

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothProfile
import android.content.Context
import android.media.AudioDeviceInfo
import android.media.AudioManager

class BluetoothAudioManager(private val context: Context) {

    private val audioManager: AudioManager? =
        context.getSystemService(Context.AUDIO_SERVICE) as? AudioManager
    private val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

    fun setBluetoothAudioRouting(enable: Boolean) {
        if (enable) {
            audioManager?.startBluetoothSco()
        } else {
            audioManager?.stopBluetoothSco()
        }
    }

    fun isBluetoothAudioConnected(): Boolean {
        val audioDevices = audioManager?.getDevices(AudioManager.GET_DEVICES_OUTPUTS)
        for (device in audioDevices ?: emptyArray()) {
            val deviceType = device.type
            if (deviceType == AudioDeviceInfo.TYPE_BLUETOOTH_SCO ||
                deviceType == AudioDeviceInfo.TYPE_BLUETOOTH_A2DP
            ) {
                return true
            }
        }
        return false
    }
}
