package io.github.ledinhtri97.learningsqlitewithcontact;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import io.github.ledinhtri97.adapter.ContactAdapter;
import io.github.ledinhtri97.model.Contact;

public class MainActivity extends AppCompatActivity {

    ListView lvContact;
    ArrayList<Contact> listDanhBa;
    ContactAdapter adapterDanhBa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
        readAllContactsFromPhone();
    }

    private void addEvents() {
    }

    private void addControls() {
        lvContact = (ListView) findViewById(R.id.lvContact);
        listDanhBa = new ArrayList<>();
        adapterDanhBa = new ContactAdapter(
                MainActivity.this,
                R.layout.item,
                listDanhBa
        );
        lvContact.setAdapter(adapterDanhBa);
    }

    private void readAllContactsFromPhone(){
        Uri uriContact = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uriContact, null, null, null, null);
        listDanhBa.clear();
        try {
            while (cursor.moveToNext()) {
                //Tao cot ten;
                String idName = ContactsContract.Contacts.DISPLAY_NAME;
                int colNameIndex = cursor.getColumnIndex(idName);
                String name = cursor.getString(colNameIndex);

                String idPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
                int colPhoneIndex = cursor.getColumnIndex(idPhone);
                String phone = cursor.getString(colPhoneIndex);
/*
                String idEmail = ContactsContract.CommonDataKinds.Email.ADDRESS;
                int colEmailIndex = cursor.getColumnIndex(idEmail);
                String email = cursor.getString(colEmailIndex);
*/
//              Contact contact = new Contact(name, phone, email);
                Contact contact = new Contact(name, phone);
                listDanhBa.add(contact);
            }
        }catch (Exception e){
            Log.e("Erorr:", e.toString());
        }
        cursor.close();
        adapterDanhBa.notifyDataSetChanged();
    }

    public void handleReadSMS(View view) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }
}
