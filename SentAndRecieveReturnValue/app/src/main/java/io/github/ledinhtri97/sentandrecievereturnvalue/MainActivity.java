package io.github.ledinhtri97.sentandrecievereturnvalue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtA, txtB;
    TextView txtKq;
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
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("A", Integer.parseInt(txtA.getText().toString()));
                intent.putExtra("B", Integer.parseInt(txtB.getText().toString()));

                //buoc 1: goi ham startActivityForResult(intent, ma);
                startActivityForResult(intent, 99); //ma gui di requestCode //khong trung nhau

            }

        });
    }


    //buoc 6: can overide ham onActivityResult(..) de nhan duoc ket qua tra ve tu man hinh truoc
    // tu dong nhan duoc ket qua tra ve tu man hinh truoc voi dieu kien no nam trong chu trinh
    // foreground lifetime;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==99&&resultCode==-99){
            txtKq.setText("A + B = " + data.getIntExtra("RESULT", -1));

        }
    }

    private void addControls() {
        txtA= (EditText) findViewById(R.id.txtA);
        txtB= (EditText) findViewById(R.id.txtB);
        txtKq= (TextView) findViewById(R.id.txtKq);
        btnOk= (Button) findViewById(R.id.btnOk);
    }
}
