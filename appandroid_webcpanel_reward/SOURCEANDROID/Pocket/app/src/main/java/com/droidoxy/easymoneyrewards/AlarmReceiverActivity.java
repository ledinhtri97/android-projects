
/**
 * This activity will be called when the alarm is triggered to give Daily  Checkin Reward.
 * 
 * @author DroidOXY
 */

package com.droidoxy.easymoneyrewards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.MenuItem;
import android.view.View;


public class AlarmReceiverActivity extends BaseActivity {
    private PrefManager prefManager;

	Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pending_intent);

		getSupportActionBar().setIcon(R.drawable.ic_back_icon);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle("Activated");

		prefManager = new PrefManager(this);
			prefManager.setGet(true);

		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent i = new Intent(getBaseContext(), AppActivity.class);
				startActivity(i);
				finish();

			}

		});


	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			
			case android.R.id.home:
				// this.finish();
				Intent p = new Intent(getBaseContext(), AppActivity.class);
				this.finish();
				startActivity(p);
				break;

			default:
				return super.onOptionsItemSelected(item);
		}
		return true;
	}
	
}