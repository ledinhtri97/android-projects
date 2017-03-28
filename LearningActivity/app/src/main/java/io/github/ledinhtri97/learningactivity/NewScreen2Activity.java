package io.github.ledinhtri97.learningactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class NewScreen2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_screen2);
    }

    public void BackMain(View view) {
        Intent intent = new Intent(NewScreen2Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
