package com.inc.runkdown.cookapp_01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by RunkDowN on 10.07.16.
 */
public class RegisterFragmentSecond extends android.support.v4.app.Fragment {
    public RegisterFragmentSecond() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.register_fragment_second, container, false);
    }
}
