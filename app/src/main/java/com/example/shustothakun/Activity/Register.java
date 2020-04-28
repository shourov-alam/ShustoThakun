package com.example.shustothakun.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shustothakun.Model_Class.Register_Model;
import com.example.shustothakun.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Users");;
    Button reg;
    EditText name,mail,password,phn;
    //static String ph;
    //String ke = databaseReference.push().getKey();
   // public static String ml;
   //  final String r=ke;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reg=findViewById(R.id.btn_reg);
        name=findViewById(R.id.btn_name);
        mail=findViewById(R.id.btn_mail);
        password=findViewById(R.id.btn_pass);
        phn=findViewById(R.id.btn_phn);

        //databaseReference= FirebaseDatabase.getInstance().getReference("Users");



        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nam=name.getText().toString();
                String ml=mail.getText().toString();
                String pas=password.getText().toString();
                String ph=phn.getText().toString();
                String key=databaseReference.push().getKey();



                if(!TextUtils.isEmpty(nam) && !TextUtils.isEmpty(ml) && !TextUtils.isEmpty(pas) && !TextUtils.isEmpty(ph)) {


                    Register_Model register_model = new Register_Model(nam, ml, pas, ph, key);

                    databaseReference.child(key).setValue(register_model);

                    name.setText("");
                    mail.setText("");
                    password.setText("");
                    phn.setText("");

                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    //  intent.putExtra("key",key);

                    startActivity(intent);

                    //  Intent i = new Intent();
                    //  i.putExtra("key",key);


                }else {

                    Toast.makeText(getApplicationContext(),"Please Fill Up All The Fields",Toast.LENGTH_LONG).show();
                }



            }
        });






    }
}
