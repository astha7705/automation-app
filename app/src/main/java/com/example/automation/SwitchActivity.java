package com.example.automation;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class SwitchActivity extends AppCompatActivity {


    private DatabaseReference mDatabase;


    private Switch Fn1,Fn2,Fn3,Fn4,Fn5,Fn6,tb;
    private  Button btnGet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.switch_layout);
        Fn1 = (Switch)findViewById(R.id.Fan1);
        Fn2 = (Switch)findViewById(R.id.Fan2);
        Fn3 = (Switch)findViewById(R.id.Fan3);
        Fn4 = (Switch)findViewById(R.id.Fan4);
        Fn5 = (Switch)findViewById(R.id.Fan5);
        Fn6 = (Switch)findViewById(R.id.Fan6);
        tb = (Switch)findViewById(R.id.Tubelight);

        btnGet = (Button)findViewById(R.id.getBtn);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1, str2,str3, str4 ,str5, str6, str7;
                if (Fn1.isChecked())
                    str1 = Fn1.getTextOn().toString();
                else
                    str1 = Fn1.getTextOff().toString();
                if (Fn2.isChecked())
                    str2 = Fn2.getTextOn().toString();
                else
                    str2 = Fn2.getTextOff().toString();

                if (Fn3.isChecked())
                    str3 = Fn3.getTextOn().toString();
                else
                    str3 = Fn3.getTextOff().toString();
                if (Fn4.isChecked())
                    str4 = Fn4.getTextOn().toString();
                else
                    str4 = Fn4.getTextOff().toString();
                if (Fn5.isChecked())
                    str5 = Fn5.getTextOn().toString();
                else
                    str5 = Fn5.getTextOff().toString();
                if (Fn6.isChecked())
                    str6 = Fn6.getTextOn().toString();
                else
                    str6 = Fn6.getTextOff().toString();
                if (tb.isChecked())
                    str7 = tb.getTextOn().toString();
                else
                    str7 = tb.getTextOff().toString();
                Toast.makeText(getApplicationContext(), "Fan1 -  " + str1 + " \n" + "Fan2 - " + str2+"Fan3 -  " + str3 + " \n" +"Fan4 -  " + str4 + " \n" +"Fan5 -  " + str5 + " \n" +"Fan6 -  " + str6 + " \n" +"TubeLight -  " + str7 + " \n",Toast.LENGTH_SHORT).show();


                mDatabase.child("user_profile_settings").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        // Use The Model Class To Get The Data
                        final Model myProfileSettingsModel = dataSnapshot.getValue(Model.class);

                        String notificationIndividualChat = myProfileSettingsModel.getNotification_individual_chat();

                        if (notificationIndividualChat.equals("0")) {
                            Fn1.setChecked(true);

                            Fn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                                    mDatabase.child("user_profile_settings").child("notification_individual_chat").setValue("1");

                                }
                            });
                        }
                        if (notificationIndividualChat.equals("1")) {
                            Fn1.setChecked(false);

                            Fn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                                    mDatabase.child("user_profile_settings").child("notification_individual_chat").setValue("0");

                                }
                            });
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }
        });
    }


}


