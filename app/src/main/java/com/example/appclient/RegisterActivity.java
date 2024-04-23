package com.example.appclient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appclient.databinding.ActivityRegisterBinding;
import com.example.appclient.model.KhachHang;

import java.util.Arrays;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    private String name, email, phone, pass, rePass;
    public static KhachHang khachHang;
    private Intent intent;

    private Dialog progressDialog;

    private TextView tvDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //set font typeface
        Typeface typeface = ResourcesCompat.getFont(this,R.font.blacklist);
        for (AppCompatTextView appCompatTextView : Arrays.asList(binding.imgLogin, binding.tvSignup)) {
            appCompatTextView.setTypeface(typeface);
        }
        for (AppCompatEditText appCompatEditText : Arrays.asList(binding.edtPass, binding.edtEmail, binding.edtYourname, binding.edtReTypePass, binding.edtPhonenumber)) {
            appCompatEditText.setTypeface(typeface);
        }
        // tao progress dialog
        progressDialog = new Dialog(RegisterActivity.this);
        progressDialog.setContentView(R.layout.dialog_layout);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        tvDialog = progressDialog.findViewById(R.id.tvDialog);
        tvDialog.setText("Signing user....");

        binding.tvSignup.setEnabled(false);
        binding.edtYourname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable e) {
                checkLoginIsAvailable();
            }
        });
        binding.edtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable e) {
                checkLoginIsAvailable();
            }
        });
        binding.edtPhonenumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable e) {
                checkLoginIsAvailable();
            }
        });
        binding.edtPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable e) {
                checkLoginIsAvailable();
            }
        });
        binding.edtReTypePass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable e) {
                checkLoginIsAvailable();
            }
        });
        binding.tvSignup.setOnClickListener(view -> {
                    Toast.makeText(RegisterActivity.this, "Sucessful", Toast.LENGTH_SHORT).show();
                    khachHang = new KhachHang();
                    khachHang.setTen(name);
                    khachHang.setPass(pass);
                    khachHang.setEmail(email);
                    khachHang.setSDT(phone);
                    progressDialog.show();
                    /// call api for register


                    ///
                    progressDialog.dismiss();
        });
        binding.imgBack.setOnClickListener(view -> {
                onBackPressed();
        });

    }

    private void checkLoginIsAvailable() {
        name = binding.edtYourname.getText() + "";
        email = binding.edtEmail.getText() + "";
        phone = binding.edtPhonenumber.getText() + "";
        pass = binding.edtPass.getText() + "";
        rePass = binding.edtReTypePass.getText() + "";

        binding.tvSignup.setEnabled(!name.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !pass.isEmpty() && !rePass.isEmpty());
    }
    public void hideKeyBoard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        binding.edtReTypePass.clearFocus();
        binding.edtPass.clearFocus();
        binding.edtYourname.clearFocus();
        binding.edtEmail.clearFocus();
        binding.edtPhonenumber.clearFocus();
    }



}