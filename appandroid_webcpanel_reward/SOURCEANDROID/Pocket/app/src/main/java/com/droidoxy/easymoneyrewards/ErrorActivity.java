/**
 * Error Activity launched when Internet Dis-connected.
 * 
 * @author DroidOXY
 */

package com.droidoxy.easymoneyrewards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
/**
 * 
 * @author DroidOXY
 */
public class ErrorActivity extends BaseActivity {
    private PrefManager prefManager;
	
	private TextView error;
	Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
		
		error = (TextView) findViewById(R.id.error_text);
		error.setText("No Internet Conection !!");
		
		button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					
					retry();
				}

			});

	}
	
	private void retry(){

		ConnectionManager con = new ConnectionManager(this);
		boolean connection = con.isConnectingToInternet();

		if(connection == true)
		{
			Intent i = new Intent(getBaseContext(), AppActivity.class);
			startActivity(i);
			finish();
		}
		else {

			Intent i = new Intent(getBaseContext(), ErrorActivity.class);
			startActivity(i);
			finish();
		}
		
	}
}