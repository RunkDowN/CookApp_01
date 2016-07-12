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
public class RegisterFragment extends android.support.v4.app.Fragment {
    EditText UsernameEt, PasswordEt, EmailEt;
    TextView Register;
    View rootView;
    TextInputLayout inputLayoutUsername;

    public RegisterFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.register_fragment, container, false);

        EmailEt = (EditText) rootView.findViewById(R.id.et_email_register);
        UsernameEt = (EditText) rootView.findViewById(R.id.et_name_register);
        PasswordEt = (EditText) rootView.findViewById(R.id.et_password_register);

        UsernameEt.addTextChangedListener(mTextWatcher);
        PasswordEt.addTextChangedListener(mTextWatcher);
        EmailEt.addTextChangedListener(mTextWatcher);

        Register = (TextView) rootView.findViewById(R.id.onRegId);

        checkFields();

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


    public void checkFields() {
        if (UsernameEt.length() > 0 && PasswordEt.length() > 0 && EmailEt.length() > 0 && isEmailValid(UsernameEt.getText().toString())) {
            System.out.println("LISTENER AFTERTEXT PASSWORD WORKING");
            System.out.println("==================================");
            Register.setTextColor(Color.argb(255, 255, 255, 255));
        }
        else {
            Register.setTextColor(getResources().getColor(R.color.botNav));
        }

    }

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            checkFields();
        }
    };
}


