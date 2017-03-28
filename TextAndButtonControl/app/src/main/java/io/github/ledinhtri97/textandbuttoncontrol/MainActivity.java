package io.github.ledinhtri97.textandbuttoncontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    EditText txtA, txtB;
    Button btnSub, btnMul, btnDiv, btnHide, btnExit;

    /**Variable as Listener: day la phuong phap xulysukien
     * no co the chia se su kien cho cac control co cung cach thuc hien nhung muc dich khac nhau */
    View.OnClickListener eventShare=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {

        /**anomous listener duoc su dung nhieu nhat */
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyPhepTru();
            }
        });

        eventShare=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.btnMul){
                    xuLyPhepNhan();
                }
                else if(v.getId()==R.id.btnDiv){
                    xuLyPhepChia();
                }
            }

        };
        btnMul.setOnClickListener(eventShare);
        btnDiv.setOnClickListener(eventShare);
        btnHide.setOnLongClickListener(this);
        btnExit.setOnClickListener(new MyEvent());
    }

    private void xuLyPhepChia() {
        int a= Integer.parseInt(txtA.getText().toString());
        int b= Integer.parseInt(txtB.getText().toString());
        int c= a/b;
        Toast.makeText(MainActivity.this, "a / b = " + c, Toast.LENGTH_SHORT).show();
    }

    private void xuLyPhepNhan() {
        int a= Integer.parseInt(txtA.getText().toString());
        int b= Integer.parseInt(txtB.getText().toString());
        int c= a*b;
        Toast.makeText(MainActivity.this, "a * b = " + c, Toast.LENGTH_SHORT).show();
    }

    private void xuLyPhepTru() {
        int a=Integer.parseInt(txtA.getText().toString());
        int b=Integer.parseInt(txtB.getText().toString());
        int c= a-b;
        Toast.makeText(MainActivity.this, "a - b = " + c,  Toast.LENGTH_SHORT).show();
    }

    private void addControls(){
        txtA= (EditText) findViewById(R.id.txtA);
        txtB= (EditText) findViewById(R.id.txtB);
        btnSub= (Button) findViewById(R.id.btnSub);
        btnMul= (Button) findViewById(R.id.btnMul);
        btnDiv= (Button) findViewById(R.id.btnDiv);
        btnHide= (Button) findViewById(R.id.btnHide);
        btnExit= (Button) findViewById(R.id.btnExit);
    }


    /**Onclick XML: chi xu dung duoc khi co control tren giao dien*/
    public void xuLyPhepCong(View v) {
        int a=Integer.parseInt(txtA.getText().toString());
        int b=Integer.parseInt(txtB.getText().toString());
        int c=a+b;
        //txtApB = (EditText) c;
        Toast.makeText(MainActivity.this, "a + b = " + c,Toast.LENGTH_SHORT).show();
    }

    /**
     * Activity as listener: ke thua mot lop cha xulysukien, tao nen cac hoat dong ma tat ca
     * cac control deu su dung duoc vi no se la lop con cua lop cha do, khi do no so huu hay hien thuc
     * lai tat ca cac phuong thuc can thiet va su dung duoc cho tat ca cac contral hay object, se la
     * phi pham vi neu trong du an chi co mot so it cac control su dung no, con cac control con lai
     * la khong can thiet.*/
    @Override
    public boolean onLongClick(View v) {
        if(v.getId()==R.id.btnHide){
            btnHide.setVisibility(View.INVISIBLE);
        }
        return false;
    }

    /** Eliplice Class Listener: khi mot du an trong nen phinh to ra, viec su ly cac su kien tro nen
     * phuc tap, ta can tao mot lop hien thuc tuong minh rieng de giai quyet cac van de tro nen de
     * dang hon.*/
    public class MyEvent implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.btnExit){
                finish();
            }
        }
    }

    /**View Subclassing: chi su dung duoc khi control do chay trong runtime*/
    public void changeScreen(View v){
        Button btnNew=new android.support.v7.widget.AppCompatButton(MainActivity.this){
            @Override
            public boolean performClick() {
                setContentView(R.layout.activity_main);

                addControls();
                addEvents();
                return super.performClick();
            }
        };
        btnNew.setText("Back Home");
        btnNew.setWidth(200);
        btnNew.setHeight(200);

        setContentView(btnNew);
    }
}
