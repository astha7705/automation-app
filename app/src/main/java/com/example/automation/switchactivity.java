package com.tutlane.switchexample;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.example.automation.R;

public class MainActivity extends AppCompatActiity {
    private Switch Fan1,Fan2,Fan3,Fan4,Fan5,Fan6,Tubelight;
    private  Button btnGet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fn1 = (Switch)findViewById(R.id.Fan1);
        Fn2 = (Switch)findViewById(R.id.Fan2);
        Fn3 = (Switch)findViewById(R.id.Fan3);
        Fn4 = (Switch)findViewById(R.id.Fan4);
        Fn5 = (Switch)findViewById(R.id.Fan5);
        Fn6 = (Switch)findViewById(R.id.Fan6);
        tb = (Switch)findViewById(R.id.Tubelight);

        btnGet = (Button)findViewById(R.id.getBtn);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1, str2;
                if (Fn1.isChecked())
                    str1 = Fn1.getTextOn().toString();
                else
                    str1 = sw1.getTextOff().toString();
                if (sw2.isChecked())
                    str2 = sw2.getTextOn().toString();
                else
                    str2 = sw2.getTextOff().toString();
                Toast.makeText(getApplicationContext(), "Switch1 -  " + str1 + " \n" + "Switch2 - " + str2,Toast.LENGTH_SHORT).show();
            }
        });
    }

}



    private DatabaseReference mDatabase;
mDatabase = FirebaseDatabase.getInstance().getReference();

public class switchactivity {
    private String switchCommand;

    public switchactivity(){

    }

    public switchactivity(String switchCommand) {
        this.switchCommand = switchCommand;

    }

    public String getSwitchCommand() {
        return switchCommand;
    }


}
    switchactivity Switchactivity= new switchactivity(switchcommand);
databaseReference.child(id).setValue(switchactivity);

        databaseReference.addValueEventListener(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {

        }

@Override
public void onCancelled(DatabaseError databaseError) {

        }
        });



