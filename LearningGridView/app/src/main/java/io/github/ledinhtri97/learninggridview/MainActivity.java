package io.github.ledinhtri97.learninggridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

import io.github.ledinhtri97.adapter.HinhAdapter;

public class MainActivity extends AppCompatActivity {

    GridView gvHinh;
    ArrayList<Integer> arrHinh;
    HinhAdapter adapterHinh;
    Button btnOk;

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

            }
        });

    }

    private void addControls() {
        btnOk= (Button) findViewById(R.id.btnOk);
        gvHinh = (GridView) findViewById(R.id.gvHinh);
        arrHinh = new ArrayList<>();
        arrHinh.add(R.drawable.h1);arrHinh.add(R.drawable.h6);
        arrHinh.add(R.drawable.h2);arrHinh.add(R.drawable.h7);
        arrHinh.add(R.drawable.h3);arrHinh.add(R.drawable.h8);
        arrHinh.add(R.drawable.h4);arrHinh.add(R.drawable.h9);
        arrHinh.add(R.drawable.h5);arrHinh.add(R.drawable.h10);
        adapterHinh = new HinhAdapter(MainActivity.this, R.layout.item, arrHinh);
        gvHinh.setAdapter(adapterHinh);

    }
}
