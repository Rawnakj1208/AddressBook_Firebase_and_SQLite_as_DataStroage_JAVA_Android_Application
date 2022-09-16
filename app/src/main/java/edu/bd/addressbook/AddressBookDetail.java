package edu.bd.addressbook;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddressBookDetail extends AppCompatActivity {
    private Button btnCreate, btnExit,btnHistory;
    ListView listView;
    ArrayList <Address> list= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addressbook_detail);

        btnCreate = findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(view -> {
            Intent intent = new Intent(AddressBookDetail.this,MainActivity.class);
            startActivity(intent);
        });
        listView = findViewById(R.id.listview1);
        btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(view -> finish());



        loadDb();

        CustomAddressAdaptor adapter = new CustomAddressAdaptor(this, list);
        listView.setAdapter((ListAdapter) adapter);


//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
//
//                Intent i = new Intent(AddressBookDetails.this, MainActivity.class);
//                startActivity(i);
//            }
//        });

    }



    private  void loadDb(){
        SQLiteDB db = new SQLiteDB(getApplicationContext());
        list.clear();
        Cursor res = db.FetchAllData();
        if (res.getCount() == 0) {
            return;
        }else{
            while(res.moveToNext()){

                String name = res.getString(0);
                String email = res.getString(1);
                String address1 = res.getString(2);
                String address2 = res.getString(3);
                String phone = res.getString(4);
                String phone2 = res.getString(5);



                Address adding = new Address(name,email,address1,address2,phone,phone2);
                list.add(adding);

            }
        }
        db.close();
    }
    @Override
    protected void onPostResume() {
        super.onPostResume();
        loadDb();
        CustomAddressAdaptor adapter = new CustomAddressAdaptor(this, list);
        listView.setAdapter((ListAdapter) adapter);
    }
}
