package com.example.sonhyejin.eat_ku;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Rec_rec extends AppCompatActivity {

    String[] info = new String[539];
    String[][] info1= new String[539][16];
    String[] ingre = new String[539];
    String[][] ingre1 = new String[539][16];
    Bitmap bmp = null;
    Bitmap bmp2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_rec);

        Button home = (Button)findViewById(R.id.home2);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Fix_ref 페이지로 넘어가기 (fix_Refrigerator : 냉장고 편집)
                Intent intent = new Intent(Rec_rec.this, Mainmenu.class);
                startActivity(intent);
            }
        });

        AssetManager am = getResources().getAssets();
        InputStream is = null;
        byte buf[] = new byte[1000000];
        String text = "";

        try{    //정보 데이터 배열에 넣기
            is = am.open("info.csv");

            if(is.read(buf) > 0){
                text = new String(buf);
            }

            for(int i=0;i<539;i++){ //한줄을 자르고
                info =  text.split("\n");
            }

            for(int i=0;i<539;i++){ //각 줄을 또 자르고
                for(int j=0;j<16;j++) {
                    info1[i] = info[i].split(",");
                }
            }

            is.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        is = null;
        text = "";

        /*

        try{    //재료 데이터 배열에 넣기
            is = am.open("ingredient.csv");

            if(is.read(buf) > 0){
                text = new String(buf);
            }

            for(int i=0;i<6104;i++){ //한줄을 자르고
                ingre =  text.split("\n");
            }

            for(int i=0;i<6104;i++){ //각 줄을 또 자르고
                for(int j=0;j<8;j++) {
                    ingre1[i] = ingre[i].split(",");
                }
            }

            is.close();
        }catch (Exception e){
            e.printStackTrace();
        }

*/

        TextView textView = (TextView) findViewById(R.id.text1);
        ImageView imageView = (ImageView) findViewById((R.id.image1));
        ImageView imageView2 = (ImageView) findViewById((R.id.image2));

        textView.setText(info1[99][1]);

        Thread mThread = new Thread(){
            @Override
            public void run(){
                try{
                    URL url = new URL(info1[99][14]);

                    URL url2 = new URL(info1[98][14]);

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setDoInput((true));
                    conn.connect();

                    InputStream is = conn.getInputStream();
                    bmp = BitmapFactory.decodeStream(is);

                    HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
                    conn2.setDoInput((true));
                    conn2.connect();

                    InputStream is2 = conn2.getInputStream();
                    bmp2 = BitmapFactory.decodeStream(is2);

                }catch (MalformedURLException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        };

        mThread.start();

        try{
            mThread.join();

            imageView.setImageBitmap((bmp));
            imageView2.setImageBitmap((bmp2));
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        if(is != null){
            try{
                is.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}