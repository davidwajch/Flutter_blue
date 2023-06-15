import 'package:flutter/services.dart';

class AudioManager {
  static const MethodChannel _channel = MethodChannel('com.example.bll/audio');

  static Future<void> setBluetoothAudioRouting(bool enable) async {
    try {
      await _channel.invokeMethod('setBluetoothAudioRouting', enable);
    } catch (e) {
      print('Error setting Bluetooth audio routing: $e');
    }
  }

  static Future<bool> isBluetoothAudioConnected() async {
    try {
      final bool isConnected =
          await _channel.invokeMethod('isBluetoothAudioConnected');
      return isConnected;
    } catch (e) {
      print('Error checking Bluetooth audio connection: $e');
      return false;
    }
  }
}
