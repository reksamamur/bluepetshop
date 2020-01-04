package com.example.bluepetshop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.bluepetshop.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText inputUsername, inputPassword;
    TextView textViewError;
    MaterialButton button;

    SharedPreferences sharedPreferences;

    String TAG = getClass().getSimpleName();

    @Override
    protected void onStart() {
        super.onStart();

    }

    void checkUsername() {
        sharedPreferences = this.getSharedPreferences("UsernameBluepet", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "missing");
        if (username.equals("missing")) {
            /*Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);*/
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    void onDeclare() {
        inputUsername = findViewById(R.id.inpUsername);
        inputPassword = findViewById(R.id.inpPassword);
        button = findViewById(R.id.btnLogin);
        textViewError = findViewById(R.id.tvError);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        onDeclare();
        doingLogin();

        sharedPreferences = this.getSharedPreferences("UsernameBluepet", Context.MODE_PRIVATE);
        checkUsername();
    }

    void setupSharedPreference(String args) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", args);
        editor.apply();
    }

    void setupError(String msg, int state) {
        textViewError.setText(msg);
        //0, 4, 8
        textViewError.setVisibility(state);
    }

    void doingLogin() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();*/
                String username = String.valueOf(inputUsername.getText());
                String password = String.valueOf(inputPassword.getText());
                if (username.isEmpty() || password.isEmpty()) {
                    setupError(getResources().getString(R.string.error_empty), 0);
                } else if (username.length() < 6 || password.length() < 6) {
                    setupError(getResources().getString(R.string.error_lesssix), 0);
                } else {
                    setupError("", 8);
                    setupSharedPreference(username);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
