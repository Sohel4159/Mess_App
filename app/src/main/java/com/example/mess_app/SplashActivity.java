package com.example.mess_app;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mess_app.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
//delay k ebaad kya hona hai

            Intent iLogin=new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(iLogin);
            finish();
        }
    },3000);

    }
}
