package com.example.bottomnav.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.bottomnav.R;


public class PaymentsFragment extends Fragment {



    public PaymentsFragment() {
        // Required empty public constructor
    }


    public static PaymentsFragment newInstance(String param1, String param2) {
        PaymentsFragment fragment = new PaymentsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payments, container, false);
    }
}