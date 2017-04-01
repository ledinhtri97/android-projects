package io.github.ledinhtri97.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.github.ledinhtri97.model.NhanVien;

public class MainActivity extends AppCompatActivity {

    /**Chu y khi dung control autocompletextview can them thuoc tinh
     * android:completionThreshold="1" trong xml
     * thuoc tinh nay dung de so ky tu khi nguoi dung go thi se xuat hien goi y
     * tham so dua vao khong duoc la so 0
     * */
    /* ListView lvXYZ*/
    AutoCompleteTextView autotxtTinhThanh; //thay the cho listview //cach the hien du lieu
    /* ArrayList<String> anything*/
    String []arrTinhThanh; //Loai dung de luu du lieu
    /*must be ArrayAdapter<String> kieu phu thuoc vao nguon*/
    ArrayAdapter<String> adapterTinhThanh; //It's Just only Adapter

    Button btnOk;

    /*Sniper*/
    EditText txtName;
    Button btnSub;

    Spinner spDay;
    ArrayList<String> listDay;
    ArrayAdapter<String> adapterDay;
    int selected=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleConfirm();
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSubmit();
            }
        });

        /**
         * Spinner setOnItemSelectedListener chu khong duoc setOnItemClickedListener
         * */

        spDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Ok + " + listDay.get(position), Toast.LENGTH_SHORT).show();
                selected = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void handleSubmit() {
        if(selected==-1)
        {
            Toast.makeText(MainActivity.this, "Nha Nguoi da chon dau!!!", Toast.LENGTH_SHORT).show();
            return;
        }
        NhanVien nv = new NhanVien(txtName.getText().toString(), listDay.get(selected));
        Toast.makeText(MainActivity.this, "Ok_ + " +  nv.toString(), Toast.LENGTH_SHORT).show();

    }

    private void handleConfirm() {
        String s = autotxtTinhThanh.getText().toString();
        Toast.makeText(MainActivity.this, "Ok + " + s, Toast.LENGTH_SHORT).show();
    }

    private void addControls() {
        autotxtTinhThanh= (AutoCompleteTextView) findViewById(R.id.autotxtTinhThanh);
        btnOk= (Button) findViewById(R.id.btnOk);


        arrTinhThanh=getResources().getStringArray(R.array.tinhThanh);
        adapterTinhThanh=new ArrayAdapter<String>(
                MainActivity.this, //Man hinh hien thi
                android.R.layout.simple_list_item_1, //layout
                arrTinhThanh //nguon
        );
        autotxtTinhThanh.setAdapter(adapterTinhThanh); //doi so la adapter

        txtName= (EditText) findViewById(R.id.txtName);
        btnSub= (Button) findViewById(R.id.btnSub);
        spDay= (Spinner) findViewById(R.id.spDate);

        listDay=new ArrayList<>();
        listDay.add("thu 2"); listDay.add("thu 3"); listDay.add("thu 4"); listDay.add("thu 5");
        listDay.add("thu 6"); listDay.add("thu 7"); listDay.add("chu nhat");

        adapterDay = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_spinner_item,
                listDay
        );

        /**
         * tao trang thai dropdown sau khi nhan
         * */
        adapterDay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spDay.setAdapter(adapterDay);

    }
}
