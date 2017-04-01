package io.github.ledinhtri97.learningsqlitewithcontact;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import io.github.ledinhtri97.adapter.SmsAdapter;
import io.github.ledinhtri97.model.Sms;

public class Main2Activity extends AppCompatActivity {

    ListView lvSMS;
    ArrayList<Sms> dsSms;
    SmsAdapter adapterSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        addControls();
        addEvents();

        handleReadAllSms();

    }

    private void handleReadAllSms() {
        Uri uri = Uri.parse("content://sms/inbox");
        Cursor cursor = Main2Activity.this.getContentResolver().query(uri, null, null, null, null);
        dsSms.clear();
        while (cursor.moveToNext()){
            int indexPhone = cursor.getColumnIndex("address");
            int indexTimeStam = cursor.getColumnIndex("date");
            int indexBody = cursor.getColumnIndex("body");

            String phonenumber = cursor.getString(indexPhone);
            String timeStamp = cursor.getString(indexTimeStam);
            String body = cursor.getString(indexBody);

            Sms sms = new Sms(phonenumber+"\n"+timeStamp+"\n"+body);
            dsSms.add(sms);
        }
        cursor.close();
        adapterSms.notifyDataSetChanged();
        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
    }

    private void addEvents() {
    }

    private void addControls() {
        lvSMS = (ListView) findViewById(R.id.lvSMS);
        dsSms = new ArrayList<>();
        adapterSms = new SmsAdapter(
                Main2Activity.this,
                R.layout.sms,
                dsSms
        );
        lvSMS.setAdapter(adapterSms);
    }
}
