package io.github.ledinhtri97.learningsqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String DATABASE_NAME = "dbContact.sqlite";
    String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database = null;

    ListView lvDanhBa;
    ArrayList<String> dsdanhBa;
    ArrayAdapter<String> adapterDanhBa;

    EditText txtTen, txtPhone;
    Button btnThem;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handleCopyDatabasesAssetsToSystem();

        addControls();
        addEvents();

        //she backed!!!!
        showAllContactOnListView();
    }

    private void showAllContactOnListView() {
        //buoc 1 Mo csdl;
        /*public Cursor query(String table, String[] columns, String selection,
            String[] selectionArgs, String groupBy, String having,
            String orderBy)*/
        database = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        Cursor cursor = database.query("Contact", null, null, null, null, null, null);
        /**
         * Cursor cursor = database.rawQuery("select * from Contact", null);
         * */

        dsdanhBa.clear();
        while (cursor.moveToNext()){
            int ma = cursor.getInt(0);
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            dsdanhBa.add(ma+"\n"+name+"\n"+phone);
        }
        cursor.close();
        //cap nhat listview
        adapterDanhBa.notifyDataSetChanged();
    }

    private void handleCopyDatabasesAssetsToSystem() {
        File dbFile = getDatabasePath(DATABASE_NAME);
        if(!dbFile.exists()) {
            try {
                CopyDataBaseFromAssets();
                Toast.makeText(MainActivity.this,
                        "Copy success from Assets folder", Toast.LENGTH_LONG).show();
            }catch (Exception e){
                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }

    }

    private void CopyDataBaseFromAssets() {
        try {
            InputStream myInput = getAssets().open(DATABASE_NAME);

            //Path tao mot db trong,
            String outPutPath =  getDatabasePath();

            //neu path file chua ton tai thi tao ra
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if(!f.exists())
                f.mkdir();

            OutputStream myOutput = new FileOutputStream(outPutPath);

            //lay du lieu tu input qua out put;
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }

            //dong myoutput, myinput
            myOutput.flush();
            myOutput.close();
            myInput.close();

        }catch (Exception e){
            Log.e("Errors: ", e.toString());
        }
    }

    private String getDatabasePath(){
        return getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;
    }

    private void addEvents() {

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues row = new ContentValues();
                Random rd = new Random();
                int ma = rd.nextInt(100);
                row.put("Ma", ma);
                row.put("Ten", txtTen.getText().toString());
                row.put("DienThoai", txtPhone.getText().toString());
                long r = database.insert("Contact", null, row);
                if(r==-1)
                    Toast.makeText(MainActivity.this, "Them that bai: " + ma
                            + txtTen.getText().toString()+ txtPhone.getText().toString()
                            , Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Them thanh cong", Toast.LENGTH_SHORT).show();
                showAllContactOnListView();
            }
        });
        lvDanhBa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);

                ContentValues row= new ContentValues();
                row.put("Ten", txtTen.getText().toString());
                row.put("DienThoai", txtPhone.getText().toString());
                database.update("Contact", row, "ma=?", new String[]{("1")});
                showAllContactOnListView();
            }
        });
    }

/**    public void screen2 (View view) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("screen2");
        builder.setMessage("go to screen2?");

        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);

            }
        });
    }*/

    private void addControls() {
        lvDanhBa = (ListView) findViewById(R.id.lvDanhBa);
        dsdanhBa = new ArrayList<>();
        adapterDanhBa = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                dsdanhBa);
        lvDanhBa.setAdapter(adapterDanhBa);


        txtPhone= (EditText) findViewById(R.id.txtPhone);
        txtTen= (EditText) findViewById(R.id.txtTen);
        btnThem= (Button) findViewById(R.id.btnThem);


    }
}
