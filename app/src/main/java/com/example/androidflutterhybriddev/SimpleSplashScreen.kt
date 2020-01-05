package com.example.androidflutterhybriddev

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import io.flutter.embedding.android.SplashScreen

class SimpleSplashScreen : SplashScreen {

    override fun createSplashView(context: Context, savedInstanceState: Bundle?): View? {
        return TextView(context);
    }

    override fun transitionToFlutter(onTransitionComplete: Runnable) {
        onTransitionComplete.run();
    }
}