package com.example.androidflutterhybriddev

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import io.flutter.embedding.android.FlutterFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPage.adapter = TestFragmentPagerAdapter(supportFragmentManager);
        viewPage.offscreenPageLimit = 3;
        btnNativeFragment.setOnClickListener {
            viewPage.setCurrentItem(0, false);
        }
        btnFlutterFragment.setOnClickListener {
            viewPage.setCurrentItem(1, false);
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}

class TestFragmentPagerAdapter : FragmentPagerAdapter {

    constructor(fm: FragmentManager) : super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);


    override fun getItem(position: Int): Fragment {
        //如果第一个是Flutter页面，会有bug
        if (position == 0) {
            return NativeFragment();
        } else if (position == 1) {
            return FlutterFragment.withCachedEngine("my_engine_id")
//                .renderMode(FlutterView.RenderMode.texture)
                .build()
        } else if (position == 2) {
            return FlutterFragment.withNewEngine().initialRoute("secondPage").build();
//            return FlutterFragment.withNewEngine().transparencyMode(FlutterView.TransparencyMode.transparent).renderMode(FlutterView.RenderMode.texture).initialRoute("thirdPage").build();
        } else if (position == 3) {
            return FlutterFragment.withNewEngine()
                .dartEntrypoint("mySpecialEntrypoint")
//                .renderMode(FlutterView.RenderMode.texture)
                .build();
        }
        return FlutterFragment.createDefault();
    }

    override fun getCount(): Int {
        return 4;
    }
}