package edu.bd.addressbook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAddressAdaptor extends ArrayAdapter<Address> {
    private final Context context;
    private final ArrayList<Address> values;

    public CustomAddressAdaptor(@NonNull Context context, @NonNull ArrayList<Address> items) {
        super(context, -1, items);
        this.context = context;
        this.values = items;
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.address_row, parent, false);

        TextView Name = rowView.findViewById(R.id.tvName);

        Address add = values.get(position);
        Name.setText(add.name);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = add.name;
                String email = add.email;
                String address1 = add.address1;
                String address2 = add.address2;
                String phone = add.phone;

                Bundle bundle = new Bundle();
                bundle.putString("nameKey",name);
                bundle.putString("emailKey",email);
                bundle.putString("Address1Key",address1);
                bundle.putString("Address2Key",address2);
                bundle.putString("PhoneKey",phone);

                Intent intent = new Intent(context, showdetails.class);
                intent.putExtras(bundle);
                context.startActivity(intent);


            }
        });

        return rowView;
    }


}

