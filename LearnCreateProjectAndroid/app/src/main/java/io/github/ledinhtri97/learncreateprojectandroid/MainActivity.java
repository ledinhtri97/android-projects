package io.github.ledinhtri97.learncreateprojectandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); /** //truyen toi file xml xu ly layout
        //R la file luu tru tat ca cac thanh phan ID cua tat ca cac thanh phan tren giao dien
    // Example of a call to a native method
        */
    TextView tv = (TextView) findViewById(R.id.basic);
    tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
