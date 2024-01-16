package com.example.mess_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {

    Button addStudent;
    ArrayList<StudentData> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_admin);

         addStudent = findViewById(R.id.add);

        RecyclerView recyclerView=findViewById(R.id.studdentList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DBhelper dBhelper=new DBhelper(this);

        list=dBhelper.fetchData();

        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(this,list);
        recyclerView.setAdapter(recyclerAdapter);



        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminActivity.this, AddStudentActivity.class);
                startActivity(intent);
            }
        });

    }
}
