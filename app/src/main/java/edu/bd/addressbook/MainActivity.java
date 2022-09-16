package edu.bd.addressbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText Name,Email, PresentAdd, PermanentAdd, PhoneH,PhoneO;
    private Button  SaveButton, ShowButton,cancelButton;
    String name,email,presentadd, permanentadd,phoneo,phoneh;
    SQLiteDB db;
    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference= FirebaseDatabase.getInstance().getReference("Address");
        Name = findViewById(R.id.nameId);
        Email = findViewById(R.id.emailId);
        PhoneH = findViewById(R.id.phone);
        PhoneO = findViewById(R.id.phone2);
        PresentAdd = findViewById(R.id.presentaddress);
        PermanentAdd = findViewById(R.id.permanentaddress);
        SaveButton = findViewById(R.id.saveBtn);
        ShowButton = findViewById(R.id.showDataBtn);
        cancelButton = findViewById(R.id.cancelBtn);


        db = new SQLiteDB(MainActivity.this);


        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();

            }  });

        ShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(intent);
            }
        });

    }


    public void saveData(){
        name = Name.getText().toString().trim();
        email = Email.getText().toString().trim();
        presentadd = PresentAdd.getText().toString().trim();
        permanentadd = PermanentAdd.getText().toString().trim();
        phoneh = PhoneH.getText().toString().trim();
        phoneo = PhoneO.getText().toString().trim();




        String errorMsg = "";

        if (name.length() < 3) {
            errorMsg += "Invalid Name";
        }

        if (email.length() < 6) {
            errorMsg += "Invalid Email";
        }
        if (presentadd.length() < 4) {
            errorMsg += "Invalid Address";
        }
        if (permanentadd.length() < 4) {
            errorMsg += "Invalid Address";
        }
        if (phoneh.length() < 4) {
            errorMsg += "Invalid Phone";

        }
        if (phoneo.length() < 4) {
            errorMsg += "Invalid Phone";

        }
        if(errorMsg.length() ==0){
            showDialog("Do you want to save information?", "Yes", "No");
        }
        System.out.println(errorMsg);


        String key=databaseReference.push().getKey();
        AddressData address= new AddressData(name,email,presentadd, permanentadd,phoneh,phoneo);
        databaseReference.child(key).setValue(address);
        Toast.makeText(getApplicationContext(),"Address details Addes",Toast.LENGTH_SHORT).show();
        Name.setText("");
        Email.setText("");
        PresentAdd.setText("");
        PermanentAdd.setText("");
        PhoneH.setText("");
        PhoneO.setText("");

    }

//        ShowButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Cursor cursor = db.FetchAllData();
//
//                if(cursor.getCount()==0){
//
//                    Toast.makeText(getApplicationContext(), "Load data first", Toast.LENGTH_SHORT).show();
//                }
//
//                else {
//
//                    while (cursor.moveToNext()) {
//
//                        System.out.println("Name "+cursor.getString(1));
//                        System.out.println("Email "+cursor.getString(2));
//                        System.out.println("PresentAdd "+cursor.getString(3));
//                        System.out.println("PermanentAdd"+cursor.getString(4));
//
//                        System.out.println("PhoneH "+cursor.getString(5));
//                        System.out.println("PhoneO "+cursor.getString(6));
//
//                    }
//                }
//            }
//        });
//


    private void showDialog(String message, String btn1,String btn2)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setCancelable(false)
                .setPositiveButton(btn1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Util.getInstance().deleteByKey(MainActivity.this,key);
                        if(btn1.equals("Yes")){

                            boolean isAchieved = db.addNewAddress(name, email,presentadd,permanentadd,phoneh,phoneo);
                            if(isAchieved){
                                Toast.makeText(MainActivity.this, "Data has been saved", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Data not stored", Toast.LENGTH_SHORT).show();
                            }

                        }
                        dialog.cancel();
                        // loadData();
                        //adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton(btn2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }


}