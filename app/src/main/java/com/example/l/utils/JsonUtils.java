package com.example.l.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class JsonUtils {

	Handler handler;

	public JsonUtils(Handler handler) {
		super();
		this.handler = handler;
	}
	public void loadJson(final String url) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String image = DownLoadUtils.getJsonString(url);
				Log.d("lzb", "image======="+image);
				Message message = Message.obtain();
				message.what=1;
				message.obj=image;
				handler.sendMessage(message);
			}
		}).start();   
	}
}
