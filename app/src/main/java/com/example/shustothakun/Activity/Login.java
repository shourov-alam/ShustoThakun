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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    Button login,regis;
    EditText mail,pass;
    DatabaseReference databaseReference;
    public static String mail_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=findViewById(R.id.btn_log);
        regis=findViewById(R.id.btn_reg);
        mail=findViewById(R.id.btn_mail);
        pass=findViewById(R.id.btn_pass);

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");


        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mail_id=mail.getText().toString().trim();
                final String pass_id=pass.getText().toString();


                if(!TextUtils.isEmpty(mail_id) &&  !TextUtils.isEmpty(pass_id)) {
                    Query query = databaseReference.orderByChild("mail").equalTo(mail_id);
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                // dataSnapshot is the "issue" node with all children with id 0

                                for (DataSnapshot user : dataSnapshot.getChildren()) {
                                    // do something with the individual "issues"
                                    Register_Model usersBean = user.getValue(Register_Model.class);

                                    if (usersBean.getPass().equals(pass_id)) {
                                        Intent intent = new Intent(getApplicationContext(), Home.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Password is wrong", Toast.LENGTH_LONG).show();
                                    }
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                }else{


                    Toast.makeText(getApplicationContext(),"Enter Mail & Password",Toast.LENGTH_LONG).show();
                }










            }
        });



    }
}
