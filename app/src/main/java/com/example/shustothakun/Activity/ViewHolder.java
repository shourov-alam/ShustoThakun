package com.example.shustothakun.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.shustothakun.R;

public class ViewHolder extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_holder);

        textView=findViewById(R.id.texts);


        Bundle bundle = getIntent().getExtras();

        if(bundle != null){

            String topic = bundle.getString("key");

            putOnView(topic);

        }





    }

    private void putOnView(String topic) {



        if(topic.equals("w_pls")){

            textView.setText(R.string.weightPlus);

        }

        else if(topic.equals("w_mns")){

            textView.setText(R.string.weightLose);




        }

        else if(topic.equals("vita_a")) {

            textView.setText(R.string.vit_a);

        }

        else if(topic.equals("vita_b")) {

            textView.setText(R.string.vit_b);

        }

        else if(topic.equals("vita_c")) {

            textView.setText(R.string.vit_c);

        }


        else if(topic.equals("vita_d")) {

            textView.setText(R.string.vit_d);

        }


        else if(topic.equals("vita_e")) {

            textView.setText(R.string.vit_e);

        }

        else if(topic.equals("cal")) {

            textView.setText(R.string.calorys);

        }

    }
}
