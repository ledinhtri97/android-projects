package io.github.ledinhtri97.senddatabetweentwoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.Serializable;

import io.github.ledinhtri97.model.Student;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleOpenAndSent_Inten(View view) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);

        intent.putExtra("KIEU_BOOLEAN", true);
        intent.putExtra("KIEU_DOUBLE", 9.9);
        intent.putExtra("KIEU_STRING", "String ne ba!"); //not primitive data

        // class Student must be implements Serializable
        Student student1 = new Student(1020, "Harry Potter");
        Student student2 = new Student(2010, "Le Dinh Tri");
        intent.putExtra("S1", (Serializable) student1);
        intent.putExtra("S2", (Parcelable) student2);

        startActivity(intent);
    }

    public void handleOpenAndSent_Bundle(View view) {
        //tu truyen du lieu thong qua inten trong cung mot activity
        /*Intent iMain = new Intent();
        iMain.putExtra("OWN", "Cua Minh Day");
        Toast.makeText(MainActivity.this, iMain.getStringExtra("OWN"), Toast.LENGTH_SHORT).show();*/


        Intent intent = new Intent(MainActivity.this, Main2Activity.class);

        Bundle bundle = new Bundle();
        bundle.putBoolean("KIEU_BOOLEAN", true);
        bundle.putDouble("KIEU_DOUBLE", 9.9);
        bundle.putString("KIEU_STRING", "String ne ba!");


        // class Student must be implements Serializable
        Student student1 = new Student(1020, "Harry Potter");
        Student student2 = new Student(2010, "Le Dinh Tri");
        bundle.putSerializable("S1", student1);
        bundle.putParcelable("S2", student2);



        intent.putExtra("BUNDLE", bundle);
        startActivity(intent);
    }
}
