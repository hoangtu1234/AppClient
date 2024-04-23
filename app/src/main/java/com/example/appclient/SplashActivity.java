package com.example.appclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.appclient.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {
    ActivitySplashBinding binding;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Typeface typeface = ResourcesCompat.getFont(this, R.font.blacklist);
        binding.tvAppName.setTypeface(typeface);
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.app_name_anim);
        binding.tvAppName.setAnimation(anim);

        new Thread(){
            @Override
            public void run(){
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                    intent = new Intent(SplashActivity.this,FirstActivity.class);
                    startActivity(intent);
                    finish();
            }
        }.start();

    }
}