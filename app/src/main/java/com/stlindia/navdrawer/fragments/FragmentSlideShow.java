package com.stlindia.navdrawer.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stlindia.navdrawer.MainActivity;
import com.stlindia.navdrawer.R;

public class FragmentSlideShow extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_slideshow,container,false);
    }

    @Override
    public void onResume() {
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("SlideShow");
        super.onResume();
    }
}
