package com.example.shustothakun.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.shustothakun.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {




                startActivity(new Intent(getApplicationContext(), Login.class));
                finishAffinity();
            }


        }, 1500);


    }

}
