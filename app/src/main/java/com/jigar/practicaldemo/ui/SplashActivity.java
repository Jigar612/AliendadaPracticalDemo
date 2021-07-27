package com.jigar.practicaldemo.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.jigar.practicaldemo.R;
import com.jigar.practicaldemo.databinding.ActivitySplashBinding;

import static com.jigar.practicaldemo.utility.AppUtil.getTag;

public class SplashActivity extends AppCompatActivity {

    private final String TAG = getTag(this.getClass());
    private final Context mContext = this;
    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView((Activity) mContext, R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        new Handler().postDelayed(() -> {

            new Handler().postDelayed(() -> {
                startActivity(new Intent(mContext, MainActivity.class));
                finish();
            }, 500);

        }, 5000);
    }
}

