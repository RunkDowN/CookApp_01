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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RunkDowN on 30.06.16.
 */
public class LoginFragment extends android.support.v4.app.Fragment {
    EditText UsernameEt, PasswordEt;
    TextView Login, OnRegLabel;

    public LoginFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login_fragment, container, false);

        PasswordEt = (EditText) rootView.findViewById(R.id.et_email_login);
        UsernameEt = (EditText) rootView.findViewById(R.id.et_email_login);
        while (true) {
            String email = UsernameEt.getText().toString();
            System.out.println("==================================");
            System.out.println("EMAIL onCreateView " + email);
            System.out.println("==================================");
//        isEmailValid(email) == true;
            if (UsernameEt.length() > 0 && PasswordEt.length() > 0 && isEmailValid(email) == true) {
                System.out.println("LISTENER AFTERTEXT PASSWORD WORKING");
                System.out.println("==================================");
                Login = (TextView) getView().findViewById(R.id.loginText);
                Login.setTextColor(Color.argb(255, 255, 255, 255));
            }
        }

        return rootView;
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }


}

