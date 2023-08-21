import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

final isSplitScreenMode = StateProvider<bool>((ref) => false);

final platformHandler = Provider<PlatformHandler>((ref) {
  return PlatformHandler(ref);
});

const CHANNEL_NAME = "com.example.android_multi_screen_checker/methodchannel";
const METHOD_SPLIT_SCREEN_STATUS = "splitScreenStatus";

class PlatformHandler {
  final Ref ref;

  PlatformHandler(this.ref) {}

  void initialize() {
    debugPrint('KKKKKKK PlatformHandler() init');
    const channel = MethodChannel(CHANNEL_NAME);
    channel.setMethodCallHandler(_methodHandle);
  }

  Future<dynamic> _methodHandle(MethodCall call) async {
    debugPrint('KKKKKKKK _methodHandle() MethodCall: $call');
    if (call.method == METHOD_SPLIT_SCREEN_STATUS) {
      final isSplitScreen = call.arguments as bool;
      ref.read(isSplitScreenMode.notifier).state = isSplitScreen;
      return Future.value(isSplitScreen);
    }
    return null;
  }
}
