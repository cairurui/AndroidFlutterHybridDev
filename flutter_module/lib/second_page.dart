
import 'package:flutter/material.dart';

class SecondPage extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("二"),
      ),
      body:Center(
        child:Column(
          children: <Widget>[
            Text("这是第二个页面"),
            RaisedButton(
              child: Text("返回"),
              onPressed: (){
//                Navigator.of(context).pop();
              },
            ),
          ],
        ),

      ) ,
    );
  }
}
