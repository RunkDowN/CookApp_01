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
    TextView Login;
    View rootView;
    TextInputLayout inputLayoutUsername, inputLayoutPassword;

    public LoginFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.login_fragment, container, false);

        inputLayoutUsername = (TextInputLayout) rootView.findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout) rootView.findViewById(R.id.input_layout_password);
        UsernameEt = (EditText) rootView.findViewById(R.id.et_email_login);
        PasswordEt = (EditText) rootView.findViewById(R.id.et_password_login);
        UsernameEt.addTextChangedListener(mTextWatcher);
        PasswordEt.addTextChangedListener(mTextWatcher);
        Login = (TextView) rootView.findViewById(R.id.loginText);


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
        if (UsernameEt.length() < 0 && PasswordEt.length() < 0 && !isEmailValid(UsernameEt.getText().toString())) {
            inputLayoutUsername.setError("Email is not correct");
            inputLayoutPassword.setError("Password is not correct");
            Login.setTextColor(getResources().getColor(R.color.botNav));

        }
        else if(UsernameEt.length() > 0 && PasswordEt.length() > 0 && isEmailValid(UsernameEt.getText().toString())) {
            System.out.println("LISTENER AFTERTEXT PASSWORD WORKING");
            System.out.println("==================================");
            Login.setTextColor(Color.argb(255, 255, 255, 255));
            inputLayoutUsername.setErrorEnabled(false);
            inputLayoutPassword.setErrorEnabled(false);
        }
    }

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            inputLayoutUsername.setErrorEnabled(false);
            inputLayoutPassword.setErrorEnabled(false);
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
//            inputLayoutUsername.setErrorEnabled(false);
//            inputLayoutPassword.setErrorEnabled(false);
            checkFields();
        }
    };


}

