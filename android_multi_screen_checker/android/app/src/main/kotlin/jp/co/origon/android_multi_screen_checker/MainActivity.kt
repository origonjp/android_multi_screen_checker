package jp.co.origon.android_multi_screen_checker

import android.util.Log
import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity: FlutterActivity() {
    private val TAG = "MainActivity"

    private var checkerPlugin = MultiScreenCheckPlugin()

    override
    fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine)

        flutterEngine.plugins.add(checkerPlugin)
    }

    override
    fun onMultiWindowModeChanged(isInMutiWindowMode: Boolean) {
        super.onMultiWindowModeChanged(isInMutiWindowMode)

        Log.d(TAG, "KKKKK onMultiWindowModeChanged $isInMutiWindowMode")
        checkerPlugin.sendSplitScreenStatus(isInMutiWindowMode)
    }

}
