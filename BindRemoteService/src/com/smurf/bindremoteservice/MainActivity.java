package com.smurf.bindremoteservice;

import com.smurf.remoteservice.IService;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	
	private static final String TAG = "RemoteService";
	private Button bind;
	private Button unbind;
	private Button call;
	private MyConn conn;
	private IService is;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
	}

	private void initViews() {
		bind = (Button)findViewById(R.id.bind);
		unbind = (Button)findViewById(R.id.unbind);
		call = (Button)findViewById(R.id.call);
		
		bind.setOnClickListener(this);
		unbind.setOnClickListener(this);
		call.setOnClickListener(this);
		
		conn = new MyConn();
		
	}
	
	public void onClick(View v){
		if(v.equals(bind)){
			Log.e(TAG, "点击bind");
			Intent intent = new Intent();
			intent.setAction("com.smurf.remoteService");
			intent.setPackage("com.smurf.remoteservicedemo");
			bindService(intent, conn, BIND_AUTO_CREATE);
		}
		if(v.equals(unbind)){
			Log.e(TAG, "点击unbind");
			unbindService(conn);
		}
		if(v.equals(call)){
			Log.e(TAG, "点击call");
			try {
				is.callMethodInService();
			} catch (RemoteException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	private class MyConn implements ServiceConnection{

		/* (non-Javadoc)
		 * @see android.content.ServiceConnection#onServiceConnected(android.content.ComponentName, android.os.IBinder)
		 */
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			Log.e(TAG, "已绑定");
			is = IService.Stub.asInterface(service);
		}

		/* (non-Javadoc)
		 * @see android.content.ServiceConnection#onServiceDisconnected(android.content.ComponentName)
		 */
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.e(TAG, "已解绑");
		}
		
	}
}
