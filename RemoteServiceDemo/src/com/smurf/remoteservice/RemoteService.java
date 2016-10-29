/*******************************************
*Copyright (C), 2000-2099，Soling Industrial
*File name: RemoteService.java
*Project name: RemoteServiceDemo
*Author: weipingwen
*Version: 
*Date: 2016年10月29日
*Description: (本文件的内容, 功能, 依赖关系...)
*............................................
*Function List:
    .obtain    创建mcuManager实例
    .xxx      xxx
*............................................
*History:
*[Date]        [Author]        [Modification]
2016年10月29日    weipingwen           
*********************************************/
package com.smurf.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Add RemoteService
 *
 */
public class RemoteService extends Service {

	private static final String TAG = "RemoteService";

	/* (non-Javadoc)
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return new MyBind();
	}
	
	public void onCreate() {
		super.onCreate();
		Log.e(TAG, "远程服务创建了！");
	}
	
	public void onDestroy() {
		super.onDestroy();
		Log.e(TAG, "远程服务销毁了！");
	}
	
	private void sayHello() {
		Log.e(TAG, "调用了远程服务的sayHello()方法");
	}
	
	public class MyBind extends IService.Stub{
	
		public void callMethodInService(){
			sayHello();
		};
		
	}
}

