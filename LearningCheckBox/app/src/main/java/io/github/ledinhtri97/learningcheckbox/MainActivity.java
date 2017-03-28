package io.github.ledinhtri97.learningcheckbox;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chkMa, chkChem, chkBio;
    Button btnSubmit, btnFBack;
    TextView txtViewChecked, txtView;
    RadioButton radYes, radNo, radNG, radOn, radOff;
    RatingBar ratBar;
    ImageView imgLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                    handleCheckBox();
            }
        });
        btnFBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRadioCheckBox();
            }
        });

        radOn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    imgLight.setImageResource(R.drawable.pic_bulbon);
            }
        });

        radOff.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    imgLight.setImageResource(R.drawable.pic_bulboff);
            }
        });
    }

    private void handleRadioCheckBox() {
        String s="";
        if(radYes.isChecked()){
            s+=radYes.getText().toString();
            ratBar.setRating(5);
        }
        if(radNo.isChecked()){
            s+=radNo.getText().toString();
            ratBar.setRating(1);
        }
        if(radNG.isChecked()){
            s+=radNG.getText().toString();
            ratBar.setRating(3);
        }
        Toast.makeText(MainActivity.this, "Ok: " + s, Toast.LENGTH_SHORT).show();
    }

    private void handleCheckBox() {
        String s = "";
        if(chkMa.isChecked()){
            s+=chkMa.getText().toString()+";\n";
        }
        if(chkBio.isChecked()){
            s+=chkBio.getText().toString()+";\n";
        }
        if(chkChem.isChecked()){
            s+=chkChem.getText().toString();
        }
        txtViewChecked.setText(s);
        txtView.setText(s);
    }

    private void addControls() {
        chkMa= (CheckBox) findViewById(R.id.chkMa);
        chkChem= (CheckBox) findViewById(R.id.chkChem);
        chkBio= (CheckBox) findViewById(R.id.chkBio);
        btnSubmit= (Button) findViewById(R.id.btnSubmit);
        txtViewChecked= (TextView) findViewById(R.id.txtViewChecked);
        txtView= (TextView) findViewById(R.id.txtView);
        btnFBack= (Button) findViewById(R.id.btnFBack);
        radYes= (RadioButton) findViewById(R.id.radYes);
        radNo= (RadioButton) findViewById(R.id.radNo);
        radNG= (RadioButton) findViewById(R.id.radNG);
        ratBar= (RatingBar) findViewById(R.id.ratBar);
        radOn= (RadioButton) findViewById(R.id.radOn);
        radOff= (RadioButton) findViewById(R.id.radOff);
        imgLight= (ImageView) findViewById(R.id.imgLight);
    }
}
