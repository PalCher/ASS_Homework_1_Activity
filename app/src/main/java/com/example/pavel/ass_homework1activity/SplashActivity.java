package com.example.pavel.ass_homework1activity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class SplashActivity extends AppCompatActivity {
    private Button btnPrev;
    private Button btnInfo;
    private Button btnSplash;
    private static final String TAG = "myLogs";
    List<ActivityManager.RunningTaskInfo> list;
    ActivityManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

        btnPrev = findViewById(R.id.btn_prev_splash);
        btnInfo = findViewById(R.id.btn_info_splash);
        btnSplash = findViewById(R.id.btn_splash);

        btnSplash.setOnClickListener(new SplashButtonListener());
        btnPrev.setOnClickListener(new PrevButtonListener());
        btnInfo.setOnClickListener(new InfoButtonListener());

    }

    private class SplashButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    private class PrevButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            startActivity(InfoActivity.newIntent(SplashActivity.this));
        }
    }

    private class InfoButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            list = am.getRunningTasks(10);
            for (ActivityManager.RunningTaskInfo task : list) {
                if (task.baseActivity.flattenToShortString().startsWith("com.example.pavel.ass_")){
                    Log.d(TAG, "------------------");
                    Log.d(TAG, "Count: " + task.numActivities);
                    Log.d(TAG, "Root: " + task.baseActivity.flattenToShortString());
                    Log.d(TAG, "Top: " + task.topActivity.flattenToShortString());
                }
            }
        }
    }

    public static final Intent newIntent(Context context){
        Intent intent = new Intent(context,SplashActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        return intent;
    }
}
