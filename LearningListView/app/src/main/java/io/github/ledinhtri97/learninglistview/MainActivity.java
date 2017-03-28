package io.github.ledinhtri97.learninglistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String []arrDate;
    ArrayAdapter<String> adapterDate;
    ListView lvDate;

    ArrayList<String> arrName;
    ArrayAdapter<String> adapterName;
    ListView lvName;

    EditText txtName;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        lvDate.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You choose [ "+arrDate[position]+" ]", Toast.LENGTH_SHORT).show();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSaveInfo();
            }
        });
    }

    private void handleSaveInfo() {
        String name = txtName.getText().toString();
        arrName.add(name); //add info
        adapterName.notifyDataSetInvalidated(); //listview update theme, view new list info
        txtName.setText("");
        txtName.requestFocus();
    }

    private void addControls() {

        arrDate=getResources().getStringArray(R.array.Date);
        adapterDate=new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrDate
        );
        lvDate= (ListView) findViewById(R.id.lvDate);
        lvDate.setAdapter(adapterDate);

        txtName= (EditText) findViewById(R.id.txtName);
        btnSave= (Button) findViewById(R.id.btnSave);
        arrName=new ArrayList<String>();
        adapterName=new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrName
        );
        lvName= (ListView) findViewById(R.id.lvName);
        lvName.setAdapter(adapterName);
    }
}
