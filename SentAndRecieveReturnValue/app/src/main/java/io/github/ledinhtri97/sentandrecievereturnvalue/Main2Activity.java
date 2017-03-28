package io.github.ledinhtri97.sentandrecievereturnvalue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    Button btnBack;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //buoc 2: lay du lieu
                intent = getIntent();
                int a = intent.getIntExtra("A", -1);
                int b = intent.getIntExtra("B", -1);


                //buoc 3: truyen thong can tra ve
                intent.putExtra("RESULT", a+b);

                //buoc 4: goi ham setResult(ma, intent) de truyen du lieu tra ve
                //ma o day khac voi ma da truyen resultCode vao luc goi gam truyen du lieu.
                setResult(-99, intent);

                //buoc 5: dong man hinh nay lai
                //de man hinh MainActivity tro thanh foreground lifetime vi du lieu duoc luu va phuc hoi
                //trong qua trinh foreground lifetime nay, cu the la onRestart() -> onResume()
                //chu y bai vong doi cua mot Activity
                finish();
            }
        });
    }

    private void addControls() {
        btnBack= (Button) findViewById(R.id.btnBack);
        btnBack.setText("Handle Sum a + b and return results");
    }
}
