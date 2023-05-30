package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginactivity.recllerView.NextActivity;

public class MainActivity extends AppCompatActivity {
    private LoginViewModel loginViewModel;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    private ImageView eyeImageView;
    private TextView dontHaveRegister, google,faceBook,LostPassword;

    private boolean isPasswordVisible = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        eyeImageView = findViewById(R.id.eyeImageView);
        dontHaveRegister=findViewById(R.id.HaveRegister);
        google=findViewById(R.id.google);
        faceBook=findViewById(R.id.facebook);
        LostPassword=findViewById(R.id.LostPassword);


        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Currently there is no use cases", Toast.LENGTH_SHORT).show();
            }
        });
        LostPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Currently there is no use cases", Toast.LENGTH_SHORT).show();
            }
        });

        faceBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Currently there is no use cases", Toast.LENGTH_SHORT).show();
            }
        });

        dontHaveRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                loginViewModel.loginUser(email, password);
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLoginSuccessful) {
                if (isLoginSuccessful) {
                    // Login successful, navigate to the next activity
                    Intent intent = new Intent(MainActivity.this, NextActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Login failed, display an error message to the user
                    Toast.makeText(MainActivity.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });


        eyeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility();
            }
        });
    }
    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            // Hide the password
            editTextPassword.setTransformationMethod(new PasswordTransformationMethod());
            eyeImageView.setImageResource(R.drawable.baseline_remove_red_eye_24);
        } else {
            // Show the password
            editTextPassword.setTransformationMethod(null);
            eyeImageView.setImageResource(R.drawable.baseline_visibility_off_24);
        }
        isPasswordVisible = !isPasswordVisible;
    }
}
