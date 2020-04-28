package com.example.shustothakun.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shustothakun.Model_Class.Stp_Model;
import com.example.shustothakun.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class Step_Count extends AppCompatActivity {

    DatabaseReference databaseReference ;
        Button reset, save_data;
        Sensor sensor;

        String unique_id;

      //  Register register = new Register();

        //String ui=register.key;






        private SensorManager sensorManager;
        private Sensor stepSensor;
        private TextView textView,t,date;
        private double MagnitudePrevious = 0;
        private Integer stepCount = -1;
        float a;

        double b, step_cont =.75;
       String distance_done,step_count;
       String save_mail;



     //public String p=databaseReference.push().getKey();






        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_step__count);
            textView = findViewById(R.id.textView);

            date=findViewById(R.id.date);
            t=findViewById(R.id.kilo);

            reset =findViewById(R.id.btn);
            save_data =findViewById(R.id.btn1);


            databaseReference=FirebaseDatabase.getInstance().getReference("Users");
            save_mail=Login.mail_id;


            SharedPreferences sharedPreferences = getSharedPreferences("userMail", Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Mail",save_mail);
            editor.commit();













         //   String ui=Register.nam;




            reset.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    stepCount = 0;
                    textView.setText(stepCount.toString());
                }
            });
            SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            SensorEventListener stepDetector = new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent sensorEvent) {
                    if (sensorEvent != null) {
                        float x_acceleration = sensorEvent.values[0];
                        float y_acceleration = sensorEvent.values[1];
                        float z_acceleration = sensorEvent.values[2];

                        double Magnitude = Math.sqrt(x_acceleration * x_acceleration + y_acceleration * y_acceleration + z_acceleration * z_acceleration);
                        double MagnitudeDelta = Magnitude - MagnitudePrevious;
                        MagnitudePrevious = Magnitude;

                        if (MagnitudeDelta > 7) {
                            stepCount++;
                        }
                        textView.setText(stepCount.toString());
                        a=Float.parseFloat(stepCount.toString());
                        b = a* step_cont;
                        distance_done=String.valueOf(b);
                        t.setText(distance_done+" m");

                    }
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int i) {
                }
            };

            sensorManager.registerListener(stepDetector, sensor, SensorManager.SENSOR_DELAY_NORMAL);

          //  String ui = r.getName();

           // t.setText(ui);


            Calendar calendar = Calendar.getInstance();
            int month=calendar.get(Calendar.MONTH)+1;
            final String sDate = calendar.get(Calendar.DAY_OF_MONTH) + "-" + month+ "-" + calendar.get(Calendar.YEAR);




          // Toast.makeText(getApplicationContext(),p,Toast.LENGTH_LONG).show();







              save_data.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {

                      SharedPreferences sharedPreferences = getSharedPreferences("userMail",Context.MODE_PRIVATE);
                      String u_id_1 = sharedPreferences.getString("Mail","Key not found");


                     // String p =Login.su;
                      Query query = databaseReference.orderByChild("mail").equalTo(u_id_1);
                      query.addListenerForSingleValueEvent(new ValueEventListener() {
                          @Override
                          public void onDataChange(DataSnapshot dataSnapshot) {

                              for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                                  unique_id=dataSnapshot1.getKey();







                              }


                              //distance_done=String.valueOf(b);
                              step_count=String.valueOf(a);
                              Stp_Model stp_model =new Stp_Model(sDate,distance_done,step_count);


                              databaseReference.child(unique_id).child("f").setValue(stp_model);








                          }

                          @Override
                          public void onCancelled(DatabaseError databaseError) {

                          }
                      });






                      // Query query1 = databaseReference.orderByChild("mail").equalTo(p);
                     /* query.addListenerForSingleValueEvent(new ValueEventListener() {
                          @Override
                          public void onDataChange(DataSnapshot dataSnapshot) {

                              for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                                  ap=dataSnapshot1.getKey();
                                  Toast.makeText(getApplicationContext(),ap,Toast.LENGTH_LONG).show();



                              }
                              databaseReference.addValueEventListener(new ValueEventListener() {
                                  @Override
                                  public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                      //  String l=dataSnapshot.child("ap").child("date").getValue(String.class);
                                      String z=dataSnapshot.child(ap).child("f").child("date").getValue(String.class);


                                      date.setText(z);


                                  }

                                  @Override
                                  public void onCancelled(@NonNull DatabaseError databaseError) {

                                  }
                              });
                          }

                          @Override
                          public void onCancelled(DatabaseError databaseError) {

                          }
                      });
 */

                  }
              });










           // Toast.makeText(getApplicationContext(),ap,Toast.LENGTH_LONG).show();






        }





    protected void onPause() {
            super.onPause();


        }

        protected void onStop() {
            super.onStop();



        }



        protected void onResume() {
            super.onResume();

            SharedPreferences sharedPreferences = getSharedPreferences("userMail",Context.MODE_PRIVATE);
            String unique_id_2 = sharedPreferences.getString("Mail","Key not found");

           // String q =Login.su;
            Query query1 = databaseReference.orderByChild("mail").equalTo(unique_id_2);
            query1.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                        unique_id=dataSnapshot1.getKey();
                      //  Toast.makeText(getApplicationContext(),ap,Toast.LENGTH_LONG).show();



                    }
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            //  String l=dataSnapshot.child("ap").child("date").getValue(String.class);
                            String z=dataSnapshot.child(unique_id).child("f").child("date").getValue(String.class);
                            String z1=dataSnapshot.child(unique_id).child("f").child("kilo").getValue(String.class);
                            String z2=dataSnapshot.child(unique_id).child("f").child("step").getValue(String.class);


                            date.setText("আপনি "+z+" তারিখে "+z1+" মিটার ও "+z2+" টি স্টেপ দিয়েছেন।");


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }



    }



