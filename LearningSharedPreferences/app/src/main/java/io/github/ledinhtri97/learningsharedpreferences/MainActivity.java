package io.github.ledinhtri97.learningsharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtUser, txtPass;
    Button btnDangNhap, btnThoat;
    CheckBox ckLuu;
    String luuTenThongTin="login";


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
        txtPass= (EditText) findViewById(R.id.txtPass);
        txtUser= (EditText) findViewById(R.id.txtUser);
        btnDangNhap= (Button) findViewById(R.id.btnDangNhap);
        btnThoat= (Button) findViewById(R.id.btnThoat);
        ckLuu = (CheckBox) findViewById(R.id.ckLuu);
    }

    //luu trang thai
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences preferences = getSharedPreferences(luuTenThongTin, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("USER_NAME", txtUser.getText().toString());
        editor.putString("PASSWORD", txtPass.getText().toString());
        editor.putBoolean("CHECK", ckLuu.isChecked());
        editor.apply();
        editor.commit();

    }

    //phuc hoi trang thai
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences(luuTenThongTin, MODE_PRIVATE);
        String user = preferences.getString("USER_NAME", "");
        String pass = preferences.getString("PASSWORD", "");
        boolean ck = preferences.getBoolean("CHECK", false);
        if(ck){
            txtUser.setText(user);
            txtPass.setText(pass);
        }

    }
}
