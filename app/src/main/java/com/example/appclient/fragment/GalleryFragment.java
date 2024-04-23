package com.example.appclient.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appclient.R;
import com.example.appclient.databinding.FragmentGalleryBinding;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class GalleryFragment extends Fragment {
    FragmentGalleryBinding binding;

    public GalleryFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentGalleryBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}