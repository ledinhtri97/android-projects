package io.github.ledinhtri97.learningassetsandsharepreference;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView txtFont;
    ListView lvFont;
    ArrayList<String> dsFont;
    ArrayAdapter<String> adapterFont;

    String tenLuutru = "TrangThaiFont";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
       lvFont.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               xyLyDoiFont(position);
           }
       });
    }

    private void xyLyDoiFont(int position) {
        String font_name =  "font/" + dsFont.get(position);
        Typeface typeface = Typeface.createFromAsset(getAssets(), font_name);
        txtFont.setTypeface(typeface);

        SharedPreferences preferences = getSharedPreferences(tenLuutru, MODE_PRIVATE);
        //MODE_PRIVATE chi luu trong he thong, chi app nay su dung.
        //muon cho cac app khac dung thi ta luu vao sd Card
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("FONT_CHU", font_name);
        editor.commit();


    }

    private void addControls() {
        txtFont= (TextView) findViewById(R.id.txtFont);
        lvFont= (ListView) findViewById(R.id.lvFont);
        dsFont=new ArrayList<>();
        adapterFont=new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, dsFont);
        lvFont.setAdapter(adapterFont);
        try {
            AssetManager assetManager = getAssets();
            String[] arrFont = assetManager.list("font");
            //Arrays of Java.util
            dsFont.addAll(Arrays.asList(arrFont));
            //add tat ca cac phan tu, dua mang thanh collection

            //lay lai du lieu da luu
            SharedPreferences preferences = getSharedPreferences(tenLuutru, MODE_PRIVATE);
            String font = preferences.getString("FONT_CHU", "");
            if (font.length()>0){
                Typeface typeface = Typeface.createFromAsset(getAssets(), font);
                txtFont.setTypeface(typeface);
            }
        }
        catch (Exception e){
            Log.e("Loi font: ", e.toString());
        }
    }
}
