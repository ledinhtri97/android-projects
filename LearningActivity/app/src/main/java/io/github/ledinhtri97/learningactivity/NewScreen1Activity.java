package io.github.ledinhtri97.learningactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewScreen1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_screen1);
    }

    public void handleBackMainScreen(View view) {
        Intent intent = new Intent(NewScreen1Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
