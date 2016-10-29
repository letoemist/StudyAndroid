/*******************************************
*Copyright (C), 2000-2099，Soling Industrial
*File name: IntentDemo1.java
*Project name: IntentDemo
*Author: weipingwen
*Version: 
*Date: 2016年10月28日
*Description: (本文件的内容, 功能, 依赖关系...)
*............................................
*Function List:
    .obtain    创建mcuManager实例
    .xxx      xxx
*............................................
*History:
*[Date]        [Author]        [Modification]
2016年10月28日    weipingwen           
*********************************************/
package com.smurf.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Add IntentDemo1
 *
 */
public class IntentDemo1 extends Activity {
	private static final String TAG = "intentdemo";	
	private Button btn1;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent_demo1);
		
		btn1 = (Button)findViewById(R.id.button1);
		
		btn1.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.e(TAG, "you have click btn1");
				Intent intent = new Intent();
				intent.setClass(IntentDemo1.this, IntentDemo.class);
				startActivity(intent);
				IntentDemo1.this.finish();
			}
			
		});
	}

}

