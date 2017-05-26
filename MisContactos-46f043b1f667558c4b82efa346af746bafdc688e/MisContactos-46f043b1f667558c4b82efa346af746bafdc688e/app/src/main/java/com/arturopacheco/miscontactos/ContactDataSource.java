package com.arturopacheco.miscontactos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arturopacheco on 25/05/17.
 */

public class ContactDataSource {
    private SQLiteDatabase database;
    private SqlLiteHelper dbHelper;


    public ContactDataSource(Context context) {
        dbHelper = new SqlLiteHelper(context);
    }

    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long createContact(Contacto contact){
        ContentValues values = new ContentValues();
        values.put("nombre",contact.getNombre());
        values.put("telefono",contact.getTelefono());
        values.put("email",contact.getEmail());
        long id = database.insert("contact",null,values);

        return id;

    }

    public ArrayList<Contacto> GetContactos(){
        ArrayList<Contacto> contactos = new ArrayList<Contacto>();
        Cursor cursor = database.query("contact",new String[]{"id","nombre","telefono","email"},null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Contacto contact = cursorToContact(cursor);
            contactos.add(contact);
            cursor.moveToNext();
        }
        cursor.close();
        return contactos;

    }

    private Contacto cursorToContact (Cursor cursor){
        Contacto contact = new Contacto(
               cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3));
        contact.setId(cursor.getLong(0));

        return contact;
    }

}
