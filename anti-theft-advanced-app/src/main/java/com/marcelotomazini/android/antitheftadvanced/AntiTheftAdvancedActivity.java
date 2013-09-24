package com.marcelotomazini.android.antitheftadvanced;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

public class AntiTheftAdvancedActivity extends Activity {

	private Button btnActivate;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(create());
    }

	private LinearLayout create() {
		TextView txt = new TextView(this);
		txt.setText("Configuration");
		
		CheckBox chkWifi = new CheckBox(this);
		chkWifi.setText("Activate WIFI automatically");
		chkWifi.setContentDescription("Activate WIFI to send the location and turn off again");

		CheckBox chkMobileData = new CheckBox(this);
		chkMobileData.setText("Activate Mobile Data automatically");
		chkMobileData.setContentDescription("Activate Mobile Data to send the location and turn off again");
		
		NumberPicker periodicity = new NumberPicker(this);
		periodicity.setContentDescription("Defines the frequency that the location is send (in minutes)");
		periodicity.setMinValue(0);
		periodicity.setMaxValue(60);
		
		btnActivate = new Button(this);
		btnActivate.setText(isActivated() ? "Deactivate" : "Activate");
		btnActivate.setOnClickListener(new OnClickListener() {
			@Override public void onClick(View v) {
				btnActivate.setText(isActivated() ? "Deactivate" : "Activate");
			}
		});
		
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		layout.addView(txt);
		layout.addView(chkWifi);
		layout.addView(chkMobileData);
		layout.addView(periodicity);
		layout.addView(btnActivate);
		
		return layout;
	}

	private boolean isActivated() {
		SharedPreferences prefs = getSharedPreferences(AntiTheftAdvanced.APP_PACKAGE, Context.MODE_PRIVATE);
		return prefs.getBoolean("active", false);
//		prefs.edit().putLong(dateTimeKey, dt.getTime()).commit();
	}
}
