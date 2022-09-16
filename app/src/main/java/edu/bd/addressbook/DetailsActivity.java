package edu.bd.addressbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    private ListView listView;
    private List<AddressData> addressDataList;
    private CustomAdapter customAdapter;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        databaseReference= FirebaseDatabase.getInstance().getReference("Address");
        addressDataList=new ArrayList<>();
        customAdapter=new CustomAdapter(DetailsActivity.this,addressDataList);


        listView=findViewById(R.id.listViewid);
    }
    @Override
    protected void onStart() {

     databaseReference.addValueEventListener(new ValueEventListener() {
         @Override
         public void onDataChange(@NonNull DataSnapshot snapshot) {
             addressDataList.clear();
             for(DataSnapshot dataSnapshot1:snapshot.getChildren()){

                 AddressData addressData=dataSnapshot1.getValue(AddressData.class);
                 addressDataList.add(addressData);
             }

             listView.setAdapter(customAdapter);

         }

         @Override
         public void onCancelled(@NonNull DatabaseError error) {

         }
     });
        super.onStart();
    }
}