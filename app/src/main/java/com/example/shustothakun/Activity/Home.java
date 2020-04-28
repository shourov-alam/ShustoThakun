package com.example.shustothakun.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.shustothakun.R;

public class Home extends AppCompatActivity {

    CardView step ;
    CardView bmi;
    CardView weight_gain;
    CardView getWeight_lose;
    CardView vitamin_list;
    CardView calory_list;
    CardView log_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        step =findViewById(R.id.step);
        bmi =findViewById(R.id.bmi);
        weight_gain=findViewById(R.id.weight_plus);
        getWeight_lose=findViewById(R.id.weight_minus);
        vitamin_list=findViewById(R.id.vitamins);
        calory_list=findViewById(R.id.food_cal);
        log_out=findViewById(R.id.logout);


        step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Step_Count.class));
            }
        });
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Bmi_cal
                        .class));
            }
        });

        weight_gain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ViewHolder.class);
                intent.putExtra("key","w_pls");
                startActivity(intent);



            }
        });

        getWeight_lose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ViewHolder.class);
                intent.putExtra("key","w_mns");
                startActivity(intent);



            }
        });



        vitamin_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Vitamin_List.class);
               // intent.putExtra("key","w_mns");
                startActivity(intent);



            }
        });
        calory_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ViewHolder.class);
                 intent.putExtra("key","cal");
                startActivity(intent);



            }
        });

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent = new Intent(getApplicationContext(),Login.class);

                //startActivity(intent);
                AlertDialog.Builder builder1 = new AlertDialog.Builder(Home.this);
                builder1.setMessage("Are You Sure To Log Out ?");
                builder1.setCancelable(false);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                 Intent intent = new Intent(getApplicationContext(),Login.class);

                                startActivity(intent);
                                finishAffinity();


                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();






            }
        });



    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(Home.this);
        builder1.setMessage("Are You Sure To Exit ?");
        builder1.setCancelable(false);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(getApplicationContext(),Login.class);

                        startActivity(intent);
                        finishAffinity();


                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }
}
