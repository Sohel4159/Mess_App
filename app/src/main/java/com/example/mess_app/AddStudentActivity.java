package com.example.mess_app;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mess_app.databinding.ActivityAddStudentBinding;

import  com.example.mess_app.DBhelper;
public class AddStudentActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityAddStudentBinding binding;
    private EditText room;
    private EditText name;
    private EditText registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      setContentView(R.layout.activity_add_student);

        Button btn=findViewById(R.id.Add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                room=findViewById(R.id.room_no);
                name=findViewById(R.id.name);
                registration=findViewById(R.id.reg_no);

                DBhelper dBhelper=new DBhelper(AddStudentActivity.this);

               long res= dBhelper.insertData(registration.getText().toString(),name.getText().toString(),room.getText().toString());
                Log.d("registration", registration.getText().toString());


               if(res!=-1)
               {
                   Toast.makeText(AddStudentActivity.this,"Data Added Successsfully",Toast.LENGTH_SHORT).show();
               }
               else if(dBhelper.isPresent(registration.getText().toString()))
                   {
                       Toast.makeText(AddStudentActivity.this," Data Already present ",Toast.LENGTH_SHORT).show();
                   }
               else{
                   Toast.makeText(AddStudentActivity.this," Data Not Added. error Occured ",Toast.LENGTH_SHORT).show();
               }

                Intent intent=new Intent(AddStudentActivity.this,AdminActivity.class);
                startActivity(intent);
            }
        });


    }

}