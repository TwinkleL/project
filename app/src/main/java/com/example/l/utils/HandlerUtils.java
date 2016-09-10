package com.example.l.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;


public class HandlerUtils {

	Handler handler;
	public static ExecutorService executor=Executors.
			newFixedThreadPool(200);

	public HandlerUtils(Handler handler) {
		super();
		this.handler = handler;
	}
	
	public void downLoadImage(final String url) {
		executor.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				byte[] imageByte=DownLoadUtils.getImageByte(url);
				Bitmap bitmap=BitmapFactory.
				  decodeByteArray(imageByte, 0, imageByte.length);
				if (bitmap==null){
					return;
				}
				Message message=Message.obtain();
				message.what=2;
				message.obj=bitmap;
				Bundle bundle=new Bundle();
				bundle.putString("url", url);
				message.setData(bundle);
				handler.sendMessage(message);
				
			}
		});
	}
	
}
