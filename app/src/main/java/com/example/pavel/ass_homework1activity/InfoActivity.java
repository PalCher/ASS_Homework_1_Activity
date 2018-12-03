package com.example.pavel.ass_homework1activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class InfoActivity extends AppCompatActivity {

    private Button btnNext;
    private Button btnPrev;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);

        btnNext = findViewById(R.id.btn_next_info);
        btnPrev = findViewById(R.id.btn_prev_info);
        btnPrev.setOnClickListener(new PrevButtonListener());
        btnNext.setOnClickListener(new NextButtonListener());

    }

    private class NextButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            startActivity(SplashActivity.newIntent(InfoActivity.this));
        }
    }

    private class PrevButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(InfoActivity.this, DetailsActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }
    }

    public static final Intent newIntent(Context context){
        Intent intent = new Intent(context,InfoActivity.class);
        return intent;
    }
}
