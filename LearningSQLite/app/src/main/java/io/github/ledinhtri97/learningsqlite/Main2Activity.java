package io.github.ledinhtri97.learningsqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Main2Activity extends AppCompatActivity {

    EditText txtTen, txtPhone;


    EditText txtTenSua, txtPhoneSua;
    Button btnSua, btnDong;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTen.setText(txtTenSua.getText().toString());
                txtPhone.setText(txtPhoneSua.getText().toString());
            }
        });

        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addControls() {
        txtPhoneSua= (EditText) findViewById(R.id.txtPhoneSua);
        txtTenSua= (EditText) findViewById(R.id.txtTenSua);

        txtPhone= (EditText) findViewById(R.id.txtPhone);
        txtTen= (EditText) findViewById(R.id.txtTen);

        btnSua= (Button) findViewById(R.id.btnSua);
        btnDong= (Button) findViewById(R.id.btnDong);
    }
}
