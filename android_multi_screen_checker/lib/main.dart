import 'package:android_multi_screen_checker/platform_handler.dart';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

void main() {
  runApp(const ProviderScope(child: MyApp()));
}

class MyApp extends ConsumerWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context, WidgetRef ref) {
    ref.read(platformHandler).initialize();
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Android Split Screen Checker',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends ConsumerWidget {
  const MyHomePage({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return Scaffold(
        appBar: AppBar(
            centerTitle: true,
            title: Text(ref.watch(isSplitScreenMode)
                ? 'is in Split Screen mode'
                : 'is NOT in Split Screen mode')),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Text('Android Split screen mode\n support SDK API 24 later',
                  style: Theme.of(context).textTheme.headlineMedium,
                  textAlign: TextAlign.center),
              const SizedBox(height: 50),
              const Text(
                  'if you any question pls contact me info@origon.co.jp'),
            ],
          ),
        ) // This trailing comma makes auto-formatting nicer for build methods.
        );
  }
}
