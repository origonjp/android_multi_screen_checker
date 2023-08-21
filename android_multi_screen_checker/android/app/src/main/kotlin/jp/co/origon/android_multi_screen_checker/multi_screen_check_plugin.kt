package jp.co.origon.android_multi_screen_checker


import android.util.Log
import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.BinaryMessenger

import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result


/** MultiScreenCheckPlugin */

class MultiScreenCheckPlugin : FlutterPlugin, MethodCallHandler {
    private val TAG = "MultiScreenCheckPlugin"

    companion object {
        private const val CHANNEL_NAME = "com.example.android_multi_screen_checker/methodchannel"
        private const val METHOD_SPLIT_SCREEN_STATUS = "splitScreenStatus"
    }

    private var pendingResult: MethodChannel.Result? = null
    private lateinit var messenger: BinaryMessenger
    private lateinit var methodChannel: MethodChannel

    override
    fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        messenger = flutterPluginBinding.binaryMessenger
        methodChannel = MethodChannel(messenger, CHANNEL_NAME)
        methodChannel.setMethodCallHandler(this)
    }

    override
    fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        Log.d(TAG, "onDetachedFromEngine!!!!!")
        methodChannel.setMethodCallHandler(null)
    }

    override
    fun onMethodCall(@NonNull call: MethodCall,
                     @NonNull result: MethodChannel.Result ) {
        Log.d(TAG, "onMethodCall!!!!!")
    }

    public fun sendSplitScreenStatus(isSplitScreen: Boolean) {
        if(methodChannel == null) {
            Log.d(TAG, "methodChannel is null")
            return
        }
        Log.d(TAG, "sendSplitScreenStatus $isSplitScreen")
        methodChannel.invokeMethod(METHOD_SPLIT_SCREEN_STATUS, isSplitScreen)
    }
}
