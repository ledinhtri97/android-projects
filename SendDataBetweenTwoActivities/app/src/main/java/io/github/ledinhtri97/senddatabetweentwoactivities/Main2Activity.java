package io.github.ledinhtri97.senddatabetweentwoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import io.github.ledinhtri97.model.Student;

public class Main2Activity extends AppCompatActivity {

    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        addControls();
        addEvents();
    }

    private void addEvents() {
    }

    private void addControls() {
        txtKetQua= (TextView) findViewById(R.id.txtKetQua);
        Intent intent = getIntent();
        //doi so thu hai la gia tri mac dinh neu bien nay khong tim thay
        boolean kieuBool = intent.getBooleanExtra("KIEU_BOOLEAN", false);
        double kieuDouble = intent.getDoubleExtra("KIEU_DOUBLE", 0);
        String kieuString = intent.getStringExtra("KIEU_STRING");
        Student student1 = (Student) intent.getSerializableExtra("S1");//object
        Student student2 = intent.getParcelableExtra("S2");

        if(kieuBool){
            txtKetQua.setText(kieuString + "\n" + kieuDouble + "\n"
                    + student1.toString() +"\n" + student2.toString());
        }
        else {
            Bundle bundle = intent.getBundleExtra("BUNDLE");
            Student s1 = (Student) bundle.getSerializable("S1");
            //Student s2 = bundle.getParcelable("S2");

            txtKetQua.setText(bundle.getBoolean("KIEU_BOOLEAN") + "\n" +
                    bundle.getDouble("KIEU_DOUBLE") + "\n" +
                    bundle.getString("KIEU_STRING") + "\n" +
                    s1 + "\n" +
                    bundle.getParcelable("S2")
            );
        }
    }
}
