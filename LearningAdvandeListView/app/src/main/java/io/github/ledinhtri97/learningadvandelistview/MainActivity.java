package io.github.ledinhtri97.learningadvandelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.jar.Manifest;

import io.github.ledinhtri97.adapter.ListAppAdapter;
import io.github.ledinhtri97.model.ListApp;

public class MainActivity extends AppCompatActivity {

    ListView lvListApp;
    ArrayList<ListApp> listApp;
    ListAppAdapter listAppAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {
        lvListApp= (ListView) findViewById(R.id.lvListApp);

        listApp=new ArrayList<>();
        listApp.add(new ListApp("Le Dinh Tri", "01658159892"));
        listApp.add(new ListApp("Daniel Honer", "01558159892"));
        listApp.add(new ListApp("Richard Kevin", "0145815092"));
        listApp.add(new ListApp("Harry Potter", "01258159892"));
        listApp.add(new ListApp("Le Dinh Tri", "01658159892"));
        listApp.add(new ListApp("Daniel Honer", "01558159892"));
        listApp.add(new ListApp("Richard Kevin", "0145815092"));
        listApp.add(new ListApp("Harry Potter", "01258159892"));

        listAppAdapter=new ListAppAdapter(
                MainActivity.this,
                R.layout.item,
                listApp
        );
        lvListApp.setAdapter(listAppAdapter);
    }
}
