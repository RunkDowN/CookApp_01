package com.inc.runkdown.cookapp_01;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by RunkDowN on 30.06.16.
 */
public class LoginFragment extends android.support.v4.app.Fragment {
    EditText UsernameEt;
    TextView Login, OnRegLabel;

    public LoginFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UsernameEt = (EditText) getView().findViewById(R.id.et_email);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login_fragment, container, false);



        UsernameEt = (EditText) rootView.findViewById(R.id.et_email);
        UsernameEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                System.out.println("LISTENER AFTERTEXT WORKING");
                System.out.println("==================================");
                Login = (TextView) getView().findViewById(R.id.loginText);
                Login.setTextColor(Color.argb(255, 255, 255, 255));
            }
        });
        return inflater.inflate(R.layout.login_fragment, container, false);
    }
}

