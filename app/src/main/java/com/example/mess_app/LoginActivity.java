package com.example.mess_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLoginAdmin;
    private Button buttonLoginGuard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLoginAdmin = findViewById(R.id.buttonLoginAdmin);
        buttonLoginGuard = findViewById(R.id.buttonLoginGuard);

        buttonLoginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login("admin");
            }
        });

        buttonLoginGuard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login("guard");
            }
        });
    }
    private void login(String role) {

        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();



        if (isValidCredentials(username, password, role)) {

            Intent intent;
            if (role.equals("admin")) {
                intent = new Intent(LoginActivity.this, AdminActivity.class);
            } else
            {
                intent = new Intent(LoginActivity.this, GuardActivity.class);
            }

            startActivity(intent);
            finish();



        } else {
            // Authentication failed, show an error message
            Toast.makeText(LoginActivity.this, "Invalid credentials for " + role, Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidCredentials(String username, String password, String role) {
        // Replace this with your authentication logic (e.g., check against a database)
        // Consider checking against role-specific credentials or user types
        if (role.equals("admin")) {
            return username.equals("admin_username") && password.equals("123456");
        } else if (role.equals("guard")) {
            return username.equals("guard") && password.equals("guard");
        }
        return false;
    }
}