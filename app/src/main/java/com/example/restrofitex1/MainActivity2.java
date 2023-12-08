package com.example.restrofitex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView1,textView2,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView1=findViewById(R.id.tv1);
        textView2=findViewById(R.id.tv2);
        textView3=findViewById(R.id.tv3);


        Intent intent= getIntent();
        String name= intent.getExtras().getString("name");
        String code=intent.getExtras().getString("code");
        String region=intent.getExtras().getString("region");

        textView1.setText(name);
        textView2.setText(code);
        textView3.setText(region);





    }
}