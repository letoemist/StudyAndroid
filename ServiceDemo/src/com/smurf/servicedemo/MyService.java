/*******************************************
*Copyright (C), 2000-2099，Soling Industrial
*File name: MyService.java
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

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.text.format.Time;
import android.util.Log;

/**
 * Add MyService
 *
 */
public class MyService extends Service {
	//定义一个日志标签
	private static final String TAG = "MyService";
	

	/* (non-Javadoc)
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.e(TAG, "start onBinder ~~~~");
		//返回binder实例
		return new MyBinder();
	}
	
	/* (non-Javadoc)
	 * @see android.app.Service#onCreate()
	 */
	public void onCreate() {
		Log.e(TAG, "start onCreate ~~~");
		super.onCreate();
	}
	
	/* (non-Javadoc)
	 * @see android.app.Service#onDestroy()
	 */
	public void onDestroy() {
		Log.e(TAG, "start onDestroy ~~~");
		super.onDestroy();
	}
	
	/**
	*Add Method:onUnbind()
	*
	*/
	public boolean onUnbind(Intent intent) {
		Log.e(TAG, "start onUnbind ~~~");
		return super.onUnbind(intent);
	}
	
	//定义一个获取当前系统时间的方法
	public String getSystemTime() {
		Time t = new Time();
		t.setToNow();
		return t.toString();
	}

	//创建Binder类为了通过Binder实现进程内的服务通信
	public class MyBinder extends Binder{
		
		public MyService getService(){
			
			return MyService.this;
			
		}
		
	}
}

