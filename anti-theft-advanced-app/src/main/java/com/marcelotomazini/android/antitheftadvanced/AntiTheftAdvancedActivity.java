package com.marcelotomazini.android.antitheftadvanced;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

public class AntiTheftAdvancedActivity extends Activity {

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
		
		Button btnActivate = new Button(this);
		btnActivate.setText("Activate");
		
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
}
