package com.example.sonhyejin.eat_ku;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

public class SplashActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        startActivity(new Intent(this,MainmenuActivity.class));
        finish();
    }
}
