package com.smurf.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class IntentDemo extends Activity {
	private static final String TAG = "intentdemo";	
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent_demo);
		
		btn = (Button)findViewById(R.id.button);
		btn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.e(TAG, "you have click btn");
				Intent intent = new Intent();
				intent.setClass(IntentDemo.this, IntentDemo1.class);
				startActivity(intent);
				IntentDemo.this.finish();
			}
			
		});
	}


	
}
