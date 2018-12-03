package com.example.pavel.ass_homework1activity;

import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnNext;
    private Button btnInfo;
    private static final String TAG = "myLogs";
    List<ActivityManager.RunningTaskInfo> list;
    ActivityManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

          btnNext = findViewById(R.id.btn_next_main);
          btnInfo = findViewById(R.id.btn_info_main);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);


            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
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
        });

    }
}
