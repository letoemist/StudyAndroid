/*******************************************
*Copyright (C), 2000-2099，Soling Industrial
*File name: ServiceDemo.java
*Project name: ServiceDemo
*Author: weipingwen
*Version: 
*Date: 2016年10月27日
*Description: (本文件的内容, 功能, 依赖关系...)
*............................................
*Function List:
    .obtain    创建mcuManager实例
    .xxx      xxx
*............................................
*History:
*[Date]        [Author]        [Modification]
2016年10月27日    weipingwen           
*********************************************/
package com.smurf.servicedemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * Add ServiceDemo
 *
 */
public class ServiceDemo extends Activity implements OnClickListener {
	private static final String TAG = "ServiceDemo";
	private MyService mMyService;
	private TextView mTextView;
	private Button startServiceButton;
	private Button stopServiceButton;
	private Button bindServiceButton;
	private Button unbindServiceButton;
	private Context mContext;
	
	private ServiceConnection mServiceConnection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.e(TAG, "onServiceDisconnected ~~~");
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			mMyService = ((MyService.MyBinder)service).getService();
			Log.e(TAG, "onServiceConnected ~~~");
			mTextView.setText("I am frome Service :" + mMyService.getSystemTime());
			
		}
	};
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupViews();
	}

	/**
	*Add Method:setupViews()
	*
	*/
	private void setupViews() {
		// TODO Auto-generated method stub
		mContext = ServiceDemo.this;
		mTextView = (TextView)findViewById(R.id.text);
		
		startServiceButton = (Button)findViewById(R.id.startservice);
		stopServiceButton = (Button)findViewById(R.id.stopservice);
		bindServiceButton = (Button)findViewById(R.id.bindservice);
		unbindServiceButton = (Button)findViewById(R.id.unbindservice);
		
		startServiceButton.setOnClickListener(this);
		stopServiceButton.setOnClickListener(this);
		bindServiceButton.setOnClickListener(this);
		unbindServiceButton.setOnClickListener(this);
	}
	
	public void onClick(View v) {
		if(v == startServiceButton){
			Intent i = new Intent();
			i.setClass(ServiceDemo.this, MyService.class);
			mContext.startService(i);
			
		}else if(v == stopServiceButton){
			Intent i = new Intent();
			i.setClass(ServiceDemo.this, MyService.class);
			mContext.stopService(i);
		}else if(v == bindServiceButton){
			//创建一个Intent意图实例，用于显性的告诉意图：当点击bindServiceButton后从ServiceDemo跳转到MyService
			Intent i = new Intent();
			i.setClass(ServiceDemo.this, MyService.class);
			mContext.bindService(i, mServiceConnection, BIND_AUTO_CREATE);
		}else{
			mContext.unbindService(mServiceConnection);
		}
	}

}

