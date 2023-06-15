package com.example.bll

import android.os.Bundle
import com.example.bll.BluetoothAudioManager
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugins.GeneratedPluginRegistrant
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    private val CHANNEL = "com.example.bll/audio"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine)
        val bluetoothAudioManager = BluetoothAudioManager(this)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            when (call.method) {
                "setBluetoothAudioRouting" -> {
                    val enable = call.arguments as? Boolean
                    if (enable != null) {
                        bluetoothAudioManager.setBluetoothAudioRouting(enable)
                        result.success(null)
                    } else {
                        result.error("INVALID_ARGUMENT", "Invalid argument", null)
                    }
                }
                "isBluetoothAudioConnected" -> {
                    val isConnected = bluetoothAudioManager.isBluetoothAudioConnected()
                    result.success(isConnected)
                }
                else -> result.notImplemented()
            }
        }
    }
}