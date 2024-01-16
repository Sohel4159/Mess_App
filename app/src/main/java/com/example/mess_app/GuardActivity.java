package com.example.mess_app;

import android.content.Intent;
import android.view.View;
import  android.widget.*;

import androidx.activity.result.ActivityResultLauncherKt;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
//import com.journeyapps.barcodescanner.ScanContract;
//import com.journeyapps.barcodescanner.ScanOptions;
import  com.example.mess_app.DBhelper;


public class GuardActivity extends AppCompatActivity {


    Button scan_button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guard);

        scan_button = findViewById(R.id.scanner);
        textView = findViewById(R.id.result);

        scan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IntentIntegrator intentIntegrator = new IntentIntegrator(GuardActivity.this);
               // intentIntegrator.setOrientationLocked(false);
                intentIntegrator.setPrompt("Scan the code");
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.CODE_128);


                intentIntegrator.initiateScan();

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

            IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

            if (intentResult != null) {
                 String content = intentResult.getContents();

                DBhelper dBhelper = new DBhelper(GuardActivity.this);

                if (dBhelper.isPresent(content)) {
                    textView.setText(content+" belongs to Hostel");
                } else {
                    textView.setText( content+" does not belongs to Hostel");
                    super.onActivityResult(requestCode, resultCode, data);

                }
            }


    }
}