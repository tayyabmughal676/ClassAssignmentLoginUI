package com.tayyab.classassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout mUserName, mUserEmail, mUserPassword, mUserRepassword;
    private Button mUserLoginBtn;
    private String mGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserName = findViewById(R.id.userNameText);
        mUserEmail = findViewById(R.id.userEmailText);
        mUserPassword = findViewById(R.id.userPasswordText);
        mUserRepassword = findViewById(R.id.userRepasswordText);
        mUserLoginBtn = findViewById(R.id.userLoginBtn);

        mUserLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });
    }

    private void userLogin() {
        String mName = mUserName.getEditText().getText().toString().trim();
        String mEmail = mUserEmail.getEditText().getText().toString().trim();
        String mPassword = mUserPassword.getEditText().getText().toString().trim();
        String mRepassword = mUserRepassword.getEditText().getText().toString().trim();

        if (mName.isEmpty()) {
            mUserName.setError("Enter Name");
            return;
        }
        if (mEmail.isEmpty()) {
            mUserEmail.setError("Enter Email");
            return;
        }
        if (mPassword.isEmpty()) {
            mUserPassword.setError("Enter Password");
            return;
        }
        if (mRepassword.isEmpty()) {
            mUserRepassword.setError("Enter Retype Password");
            return;
        }
        Toast.makeText(this,
                "Name is:" + mName +
                        "Email" + mEmail +
                        "Password" + mPassword +
                        "Re-Password" + mRepassword +
                        "Gender is: " + mGender
                , Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("userByName", mName);
        startActivity(intent);
    }

    @SuppressLint("NonConstantResourceId")
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        RadioButton radioButton = (RadioButton) view;
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioMaleBtn:
            case R.id.radioFemaleBtn:
                if (checked)
                    mGender = radioButton.getText().toString();
                printGender(mGender);
                break;
        }
    }

    private void printGender(String mGender) {
        Toast.makeText(this, "Gender is: " + mGender, Toast.LENGTH_SHORT).show();
    }
}