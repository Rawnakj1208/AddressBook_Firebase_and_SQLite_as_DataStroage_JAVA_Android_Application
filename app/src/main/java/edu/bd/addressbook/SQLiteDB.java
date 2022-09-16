package edu.bd.addressbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDB extends SQLiteOpenHelper {
    private static final String DB_NAME = "addressDB";

    private static final int DB_VERSION = 2;

    private static final String TABLE_NAME = "addressInfo";

    private static final String NAME_COL = "name";

    private static final String ID_COL = "id";

    private static final String Email_col = "email";
    private static final String Address1_col= "address1";

    private static final String Address2_col = "address2";


    private static final String Phone_Col= "phone";
    private static final String Phone_Col1= "phone2";





    public SQLiteDB (Context context) {

        super(context, DB_NAME, null, DB_VERSION);
    }

//    public SQLiteDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE addressInfo ( name TEXT PRIMARY KEY, email TEXT, address1 TEXT,address2 TEXT, phone INTEGER,phone2 INTEGER )";

        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean addNewAddress( String Name, String Email, String Address1, String Address2, String phone,String phone2) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_COL, Name);
        values.put(Email_col, Email);
        values.put(Address1_col, Address1);
        values.put(Address2_col, Address2);
        values.put(Phone_Col, phone);
        values.put(Phone_Col1, phone2);

        long isInsert = db.insert(TABLE_NAME, null, values);

        if(isInsert == -1){
            return false;
        }
        else{
            return true;
        }

    }

    public Cursor FetchAllData(){
        SQLiteDatabase sqDB = this.getWritableDatabase();
        Cursor res = sqDB.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;


    }
}

