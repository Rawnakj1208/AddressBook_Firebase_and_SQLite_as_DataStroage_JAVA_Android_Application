package edu.bd.addressbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class showdetails extends AppCompatActivity {

    TextView name1, email1, phoneh1, phoneo1, presentadd1,permanentadd1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdetails);
        name1 = findViewById(R.id.name);
        email1 = findViewById(R.id.email);
        phoneh1 = findViewById(R.id.phoneH);
        phoneo1 = findViewById(R.id.phoneO);
        presentadd1 = findViewById(R.id.present);
        permanentadd1 = findViewById(R.id.permanent);


        Intent i = this.getIntent();
        String Name = i.getStringExtra("nameKey");
        String Email = i.getStringExtra("emailKey");
        String Address1 = i.getStringExtra("Address1Key");
        String Address2 = i.getStringExtra("Address2Key");
        String PhoneH = i.getStringExtra("PhoneKey");
        String PhoneO = i.getStringExtra("Phone2Key");


        name1.setText(Name);
        email1.setText(Email);
        presentadd1.setText(Address1);
        permanentadd1.setText(Address2);
        phoneh1.setText(PhoneH);
        phoneo1.setText(PhoneO);




    }
}