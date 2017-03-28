package io.github.ledinhtri97.mycontactapplication;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.app.PendingIntent;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtPhone, txtTinNhan;
    Button btnQuaySo, btnGoi, btnNhanTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnQuaySo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleQuaySo();
            }
        });
        btnGoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGoi();
            }
        });
        btnNhanTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNhanTinVaKetQua();
            }
        });
    }

    private void handleNhanTinVaKetQua() {
        final SmsManager sms = SmsManager.getDefault();
        Intent msgSent = new Intent("ACTION_MSG_SENT");
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, msgSent, 0);

        registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                int result = getResultCode();
                String msg = "Tin may gui thanh cong roi cu!";
                if(result!= Activity.RESULT_OK){
                    msg="Tin nhan cua chu gui failed roi, nang khong nhan duoc!";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

            }
        }, new IntentFilter("ACTION_MSG_SENT"));
        sms.sendTextMessage(txtPhone.getText().toString(), null, txtTinNhan.getText().toString()+""
                        , pendingIntent, null);
    }



    private void handleGoi() {
        Uri uri = Uri.parse("tel:" + txtPhone.getText().toString());
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(uri);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }

    private void handleQuaySo() {
        Uri uri = Uri.parse("tel:"+txtPhone.getText().toString());
        Intent intent=new Intent(Intent.ACTION_DIAL);
        intent.setData(uri);
        startActivity(intent);
    }

    private void addControls() {
        txtPhone= (EditText) findViewById(R.id.txtPhone);
        txtTinNhan= (EditText) findViewById(R.id.txtTinNhan);
        btnGoi= (Button) findViewById(R.id.btnGoi);
        btnNhanTin= (Button) findViewById(R.id.btnNhanTin);
        btnQuaySo= (Button) findViewById(R.id.btnQuaySo);
    }
}
