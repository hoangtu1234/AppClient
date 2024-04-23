package com.example.appclient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appclient.databinding.ActivityLoginBinding;
import com.example.appclient.event.LoginEvent;
import com.example.appclient.model.KhachHang;

import org.greenrobot.eventbus.EventBus;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    private Dialog progressDialog;
    private TextView tvDialog;
    private  String email,password;
    private  Intent intent;
    private KhachHang khachHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // set font text bang typeFace
        Typeface typeface = ResourcesCompat.getFont(this,R.font.blacklist);
        binding.imgLogin.setTypeface(typeface);
        binding.tvLogin.setTypeface(typeface);
        binding.edtEmail.setTypeface(typeface);
        binding.edtPass.setTypeface(typeface);

        // tao progress dialog
        progressDialog = new Dialog(LoginActivity.this);
        progressDialog.setContentView(R.layout.dialog_layout);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        tvDialog = progressDialog.findViewById(R.id.tvDialog);
        tvDialog.setText("Login....");
        khachHang = RegisterActivity.khachHang;
        if(khachHang!= null){
            binding.edtEmail.setText(khachHang.getEmail());
            binding.edtPass.setText(khachHang.getPass());
        }
        binding.tvLogin.setOnClickListener(view -> {
            email = binding.edtEmail.getText().toString().trim();
            password = binding.edtPass.getText().toString().trim();
            if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                if(!password.isEmpty()){
                    progressDialog.show();
                    ///





                    ///
                    progressDialog.dismiss();
                    callHome();
                }else{
                    binding.edtPass.setError("Nhap Pass");
                }
            }else if(email.isEmpty()){
                binding.edtEmail.setError("Nhap Username");
            }else{
                binding.edtEmail.setError("Invalid Email");
            }
//            if (!username.isEmpty() && !password.isEmpty()) {
//                user = database.userDAO().getUser(username, password);
//                if (user != null) {
//                    Toast.makeText(this, "Login thanh cong", Toast.LENGTH_SHORT).show();
//                    callHome();
//                } else {
//                    Toast.makeText(this, "SAI Ten DN hoac Pass", Toast.LENGTH_SHORT).show();
//                }
//            } else {
//                if (username.isEmpty()) binding.edtUsername.setError("Nhap Username");
//                if (password.isEmpty()) binding.edtPass.setError("Nhap Pass");
//            }
        });

        binding.imgBack.setOnClickListener(view -> {
            onBackPressed();
        });
    }
    public void hideKeyBoard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        binding.edtPass.clearFocus();
        binding.edtEmail.clearFocus();
    }
    public void callHome(){
        intent = new Intent(LoginActivity.this, MainActivity2.class);
        startActivity(intent);
        EventBus.getDefault().post(new LoginEvent());
        finish();
    }
    public void callAdmin(){
        intent = new Intent(LoginActivity.this, AdminActivity.class);
        startActivity(intent);
        EventBus.getDefault().post(new LoginEvent());
        finish();
    }


}