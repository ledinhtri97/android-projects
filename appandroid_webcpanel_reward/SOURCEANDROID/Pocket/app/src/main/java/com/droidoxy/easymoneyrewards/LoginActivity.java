package com.droidoxy.easymoneyrewards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import com.droidoxy.easymoneyrewards.app.App;
import com.droidoxy.easymoneyrewards.common.ActivityBase;
import com.droidoxy.easymoneyrewards.util.CustomRequest;
import com.droidoxy.easymoneyrewards.util.Helper;


public class LoginActivity extends ActivityBase {


    Button signinBtn;
    EditText signinUsername, signinPassword;
    TextView mActionForgot;

    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        signinUsername = (EditText) findViewById(R.id.signinUsername);
        signinPassword = (EditText) findViewById(R.id.signinPassword);

        signinBtn = (Button) findViewById(R.id.signinBtn);

        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = signinUsername.getText().toString();
                password = signinPassword.getText().toString();

                if (!App.getInstance().isConnected()) {

                    Toast.makeText(getApplicationContext(), R.string.msg_network_error, Toast.LENGTH_SHORT).show();

                } else if (!checkUsername() || !checkPassword()) {


                } else {

                    signin();
                }
            }
        });

        mActionForgot = (TextView) findViewById(R.id.actionForgot);

        mActionForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), RecoveryActivity.class);
                startActivity(i);
            }
        });
    }

    public void signin() {

        showpDialog();

        CustomRequest jsonReq = new CustomRequest(Request.Method.POST, METHOD_ACCOUNT_LOGIN, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        if (App.getInstance().authorize(response)) {

                            if (App.getInstance().getState() == ACCOUNT_STATE_ENABLED) {

                                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(i);

                                ActivityCompat.finishAffinity(LoginActivity.this);

                            } else {

                                App.getInstance().logout();
                                Toast.makeText(LoginActivity.this, getText(R.string.msg_account_blocked), Toast.LENGTH_SHORT).show();
                            }

                        } else {

                            Toast.makeText(getApplicationContext(), getString(R.string.error_signin), Toast.LENGTH_SHORT).show();
                        }

                        hidepDialog();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), getText(R.string.error_data_loading), Toast.LENGTH_LONG).show();

                hidepDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username);
                params.put("password", password);
                params.put("clientId", CLIENT_ID);

                return params;
            }
        };

        App.getInstance().addToRequestQueue(jsonReq);
    }

    public Boolean checkUsername() {

        username = signinUsername.getText().toString();

        signinUsername.setError(null);

        Helper helper = new Helper();

        if (username.length() == 0) {

            signinUsername.setError(getString(R.string.error_field_empty));

            return false;
        }

        return  true;
    }

    public Boolean checkPassword() {

        password = signinPassword.getText().toString();

        signinPassword.setError(null);

        if (username.length() == 0) {

            signinPassword.setError(getString(R.string.error_field_empty));

            return false;
        }

        return  true;
    }

    @Override
    public void onBackPressed(){

        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            case android.R.id.home: {

                finish();
                return true;
            }

            default: {

                return super.onOptionsItemSelected(item);
            }
        }
    }
}
