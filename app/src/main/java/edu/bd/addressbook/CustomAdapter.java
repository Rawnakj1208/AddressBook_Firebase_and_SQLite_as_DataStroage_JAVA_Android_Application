package edu.bd.addressbook;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<AddressData> {
    private Activity context;
    private List<AddressData>addressList;

    public CustomAdapter(Activity  context,List<AddressData> addressList) {
        super(context,R.layout.sample_layout,addressList);
        this.context = context;
        this.addressList = addressList;
    }

    @NonNull
    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater= context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.sample_layout,null,true);

        AddressData AddressData =addressList.get(position);
        TextView t1=view.findViewById(R.id.nameTextViewId);
        TextView t2=view.findViewById(R.id.emailTextViewId);
        TextView t3=view.findViewById(R.id.presentaddTextViewId);
        TextView t4=view.findViewById(R.id.permanentaddress);
        TextView t5=view.findViewById(R.id.phonehTextViewId);
        TextView t6=view.findViewById(R.id.phoneoTextViewId);

        t1.setText(AddressData.getName());
        t2.setText(AddressData.getEmail());
        t3.setText(AddressData.getPresentadd());
        //t4.setText(AddressData.getPermanentadd());
        t5.setText(AddressData.getPhoneo());
        t6.setText(AddressData.getPhoneh());


        return view;
    }
}
