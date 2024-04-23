package com.example.appclient.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appclient.R;
import com.example.appclient.databinding.FragmentAccountBinding;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {
    FragmentAccountBinding binding;

    public  AccountFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAccountBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}