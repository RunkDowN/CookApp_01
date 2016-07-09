package com.inc.runkdown.cookapp_01;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v4.app.Fragment;;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.inc.runkdown.cookapp_01.LoginFragment;
import com.inc.runkdown.cookapp_01.RegisterFragment;
import com.inc.runkdown.cookapp_01.R;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    EditText UsernameEt, PasswordEt;
    EditText UsernameReg, EmailReg, PasswReg, SurReg;

    TextView Login, OnRegLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LoginFragment(), "SIGN IN");
        adapter.addFragment(new RegisterFragment(), "SIGN UP");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    public void OnLogin(View view) {
        UsernameEt = (EditText) findViewById(R.id.et_email_login);
        PasswordEt = (EditText) findViewById(R.id.et_password_login);
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String type = "login";
        System.out.println("USERNAME, PASSWORD ON LOGIN");
        System.out.println(username + password);
        System.out.println("==================================");
        BackgroudWorker backgroudWorker = new BackgroudWorker(this);
        backgroudWorker.execute(type, username, password);
    }


    public void OnReg(View view) {
        OnRegLabel = (TextView) findViewById(R.id.onRegId);
        OnRegLabel.setTextColor(Color.argb(255, 255, 255, 0));
        UsernameReg = (EditText) findViewById(R.id.et_name_register);
        EmailReg = (EditText) findViewById(R.id.et_email_register);
        PasswReg = (EditText) findViewById(R.id.et_password_register);
        String username = UsernameReg.getText().toString();
        String email = EmailReg.getText().toString();
        String password = PasswReg.getText().toString();
        String type = "register";
        BackgroudWorker backgroudWorker = new BackgroudWorker(this);
        backgroudWorker.execute(type, username, email, password);
    }

}