/**
 * Instructions For the App Users
 *
 * Edit Instructions in res->values->instructions_strings.xml
 * 
 * @author DroidOXY
 */

package com.droidoxy.easymoneyrewards;

import android.os.*;
import android.view.MenuItem;
import android.text.Html;
import android.widget.TextView;


public class InstructionsActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instructions);

		getSupportActionBar().setIcon(R.drawable.ic_back_icon);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle("Instructions");


        TextView contentView = (TextView) findViewById(R.id.instructions_content);
        contentView.setText(Html.fromHtml(getString(R.string.instructions_content)));
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				this.finish();
				break;
			default:
				break;
		}
		return super.onOptionsItemSelected(item);
	}

}