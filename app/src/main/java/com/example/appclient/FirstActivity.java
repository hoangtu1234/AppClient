package com.example.appclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appclient.databinding.ActivityFirstBinding;
import com.example.appclient.event.LoginEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class FirstActivity extends AppCompatActivity {
    ActivityFirstBinding binding;
    private Dialog progressDialog;
    private TextView tvDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // set font chu cho textView bang Typeface
        Typeface typeface = ResourcesCompat.getFont(this,R.font.blacklist);
        binding.tvLogin.setTypeface(typeface);
        binding.tvRegister.setTypeface(typeface);

        // tao thong bao xu ly vs dialog
        progressDialog = new Dialog(FirstActivity.this);
        progressDialog.setContentView(R.layout.dialog_layout);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        tvDialog = progressDialog.findViewById(R.id.tvDialog);
        tvDialog.setText("Signing user....");
        //click login
        binding.tvLogin.setOnClickListener(view -> {
            callLogin();
        });
        //click dang ky
        binding.tvRegister.setOnClickListener(view ->{
            callRegister();
        });
    }
    private void callRegister() {
        Intent intent = new Intent(FirstActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

    private void callLogin() {
        Intent intent = new Intent(FirstActivity.this,LoginActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onStart() {
        super.onStart();
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }
    @Subscribe
    public void onLogin(LoginEvent event) {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}