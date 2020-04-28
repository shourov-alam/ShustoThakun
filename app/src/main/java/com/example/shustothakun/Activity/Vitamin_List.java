package com.example.shustothakun.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shustothakun.R;

public class Vitamin_List extends AppCompatActivity {

    Button a,b,c,d,e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamin__list);
        a=findViewById(R.id.vitamin_a);
        b=findViewById(R.id.vitamin_b);
        c=findViewById(R.id.vitamin_c);
        d=findViewById(R.id.vitamin_d);
        e=findViewById(R.id.vitamin_e);


        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent =new Intent(getApplicationContext(),ViewHolder.class);
                intent.putExtra("key","vita_a");
                startActivity(intent);


            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent =new Intent(getApplicationContext(),ViewHolder.class);
                intent.putExtra("key","vita_b");
                startActivity(intent);


            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent =new Intent(getApplicationContext(),ViewHolder.class);
                intent.putExtra("key","vita_c");
                startActivity(intent);


            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent =new Intent(getApplicationContext(),ViewHolder.class);
                intent.putExtra("key","vita_d");
                startActivity(intent);


            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent =new Intent(getApplicationContext(),ViewHolder.class);
                intent.putExtra("key","vita_e");
                startActivity(intent);


            }
        });






    }
}
