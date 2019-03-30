package com.venkat.ui_design_prac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btatd(View view) {
        Intent intent=new Intent(this,Attendance.class);
        startActivity(intent);
    }

    public void btm(View view) {
        Intent intent1=new Intent(this,Marks.class);
        startActivity(intent1);
    }

    public void btev(View view) {
        Intent intent2=new Intent(this,Event.class);
        startActivity(intent2);
    }

    public void btqrcl(View view) {
        Intent intent3=new Intent(this,Sendquery.class);
        startActivity(intent3);
    }

    public void btrq(View view) {
        Intent intent4=new Intent(this,ResponseQuery.class);
        startActivity(intent4);
    }
}
