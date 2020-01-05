package com.example.androidflutterhybriddev

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.flutter.embedding.android.FlutterActivity
import kotlinx.android.synthetic.main.native_fragment_layout.*

class NativeFragment : Fragment() {
    private val TAG = "NativeFragment";
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.native_fragment_layout,null);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        startFlutterActivity.setOnClickListener {
            startActivity(FlutterActivity.createDefaultIntent(view.context));
        }

        startFlutterInitialRoute.setOnClickListener {
            startActivity(FlutterActivity
                    .withNewEngine()
                    .initialRoute("secondPage")
                    .build(view.context));
        }

        startFlutterWithCachedEngine.setOnClickListener {
            startActivity(
                    FlutterActivity
                            .withCachedEngine("my_engine_id")
                            .build(view.context)
            );
        }

        startFlutterWithTransparency.setOnClickListener {
            //这代码没法跑
            startActivity(
                FlutterActivity
                    .withCachedEngine("my_engine_id")
//                    .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
                    .build(view.context)
            );
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}