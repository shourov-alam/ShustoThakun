package com.example.shustothakun.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shustothakun.R;

public class Bmi_cal extends AppCompatActivity {


    EditText KG;
    EditText meter;
    TextView value;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_cal);
    }

   /* public static void hideSoftKeyboard(Activity activity){

        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),0);
    }*/

    public void onCalculateClick(View view){

        float height=0;
        float weight=0;
        float bmi=0;
        float bmi1=0;
        String msg= "";

        KG = findViewById(R.id.kg);
        meter =  findViewById(R.id.meter);
        value =  findViewById(R.id.bmiValue);
        result =  findViewById(R.id.result);

        weight = Float.parseFloat(KG.getText().toString());
        height = Float.parseFloat(meter.getText().toString());

        bmi = height*height;
        bmi1 = weight/bmi;

        value.setText("বি.এম.আই মান: " + bmi1);
        keyBoard();

        if (bmi1<18.5)
        {
            result.setText("আপনার ওজন স্বাভাবিক হতে কম।");
        }
        else if (bmi1>18.5 && bmi1<25){

            result.setText("আপনি স্বাভাবিক।");

        }
        else if (bmi1>25){

            result.setText("আপনার ওজন স্বাভাবিক হতে বেশি।");
        }





    }

    private void keyBoard() {

        View view = this.getCurrentFocus();

        if(view != null){


            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);



            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}
