package io.github.ledinhtri97.learningtabhost;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int TAB_1 = 0, TAB_2 = 1;
    public TextView[] txt, txt_, txtkq_;
    TextView txt1, txt2, txt3, txt4; //random
    TextView txt1_, txt2_, txt3_, txt4_; //handleSubmit()
    EditText txtkq1, txtkq2, txtkq3, txtkq4; //fill by baby
    TextView txtkq1_, txtkq2_, txtkq3_, txtkq4_; // get result after random
    CheckBox [] ckAnswers;
    CheckBox ck1, ck2, ck3, ck4;

    TabHost tabHost;
    Button btnSubmit, btnReset;
    private int a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        Begin();
        addEvents();


    }

    private void Begin(){

        tabHost.getTabWidget().getChildTabViewAt(TAB_2).setEnabled(false);

        for(int i=0; i<4; i++){
            CreateRandom();
            txt[i].setText(a + " + " + b + " = ");
            txtkq_[i].setText(Integer.toString(a+b));
        }
    }

    private void CreateRandom(){
        Random rd = new Random();
        a = rd.nextInt(100);
        b = rd.nextInt(100);
    }

    private void addEvents() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(handleSubmit()) {
                    tabHost.getTabWidget().getChildTabViewAt(TAB_2).setEnabled(true);
                    handleResult();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
    }

    private void handleResult() {
        int color = Color.rgb(173, 171, 171);
        for(int i=0; i<4; i++){
            if(txt_[i].getText().toString().equals(txtkq_[i].getText().toString())){
                ckAnswers[i].setChecked(true);
                ckAnswers[i].setBackgroundColor(color);
            }
            else
                ckAnswers[i].setText("Uncorrected");
        }
    }

    boolean handleSubmit() {
        EditText []kq={txtkq1, txtkq2, txtkq3, txtkq4};
        for(int i = 0; i< 4; i++){
            txt_[i].setText(kq[i].getText());
            if(kq[i].getText().toString().trim().isEmpty()) {
                Toast.makeText(MainActivity.this, "You have not done it!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        Toast.makeText(MainActivity.this, "You've completed! Take a look results!", Toast.LENGTH_SHORT).show();
        return true;
    }

    private void addControls() {

        tabHost = (TabHost) findViewById(R.id.tabHos);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("t1");
        tab1.setIndicator("", getResources().getDrawable(R.drawable.test));
        tab1.setContent(R.id.tab1);

        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("t2");
        tab2.setIndicator("", getResources().getDrawable(R.drawable.results));
        tab2.setContent(R.id.tab2);

        tabHost.addTab(tab2);


        btnSubmit= (Button) findViewById(R.id.btnSubmit);
        btnReset= (Button) findViewById(R.id.btnReset);

        txt1= (TextView) findViewById(R.id.txt1); txt3= (TextView) findViewById(R.id.txt3);
        txt2= (TextView) findViewById(R.id.txt2); txt4= (TextView) findViewById(R.id.txt4);

        txt1_= (TextView) findViewById(R.id.txt1_); txt3_= (TextView) findViewById(R.id.txt3_);
        txt2_= (TextView) findViewById(R.id.txt2_); txt4_= (TextView) findViewById(R.id.txt4_);

        txtkq1_= (TextView) findViewById(R.id.txtkq1_); txtkq3_= (TextView) findViewById(R.id.txtkq3_);
        txtkq2_= (TextView) findViewById(R.id.txtkq2_); txtkq4_= (TextView) findViewById(R.id.txtkq4_);

        txtkq1= (EditText) findViewById(R.id.txtkq1); txtkq3= (EditText) findViewById(R.id.txtkq3);
        txtkq2= (EditText) findViewById(R.id.txtkq2); txtkq4= (EditText) findViewById(R.id.txtkq4);

        ck1 = (CheckBox) findViewById(R.id.ck1); ck2 = (CheckBox) findViewById(R.id.ck2);
        ck3 = (CheckBox) findViewById(R.id.ck3); ck4 = (CheckBox) findViewById(R.id.ck4);

        txt = new TextView[] {txt1, txt2, txt3, txt4};
        txtkq_ = new TextView[] {txtkq1_, txtkq2_, txtkq3_, txtkq4_};
        txt_ = new TextView[] { txt1_, txt2_, txt3_, txt4_ };
        ckAnswers = new CheckBox[]{ck1, ck2, ck3, ck4};
    }
}
