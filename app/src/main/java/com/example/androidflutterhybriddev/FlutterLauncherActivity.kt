package com.example.androidflutterhybriddev

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import io.flutter.embedding.android.FlutterActivity

class FlutterLauncherActivity : FlutterActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutter_launcher)
        Handler().postDelayed(Runnable {
            startActivity(Intent(this,MainActivity::class.java));
        },2000L);
    }
}
