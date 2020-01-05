
import 'package:flutter/material.dart';
import 'package:flutter_module/third_page.dart';

class TestEntryPoint extends StatefulWidget {


  @override
  State createState() {
    return _TestEntryPointState();
  }
}

class _TestEntryPointState extends State<TestEntryPoint> {

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: ThirdPage(),
    );
  }
}