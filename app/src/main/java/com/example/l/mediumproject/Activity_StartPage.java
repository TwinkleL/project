package com.example.l.mediumproject;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by L on 2016/9/3.
 */
public class Activity_StartPage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);
        destroy();
    }

    private void destroy() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Activity_StartPage.this.finish();
            }
        }).start();
    }
}
