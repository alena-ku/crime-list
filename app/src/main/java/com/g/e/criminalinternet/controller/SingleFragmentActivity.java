package com.g.e.criminalinternet.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.g.e.criminalinternet.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected  abstract  android.support.v4.app.Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        android.support.v4.app.FragmentManager fragmentManager=
                getSupportFragmentManager();
        Fragment fragment=fragmentManager
                .findFragmentById(R.id.fragment_container);

        if(fragment==null){
            fragment=createFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}