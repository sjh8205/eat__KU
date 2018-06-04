package com.example.sonhyejin.eat_ku;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;

public class Rec_rec extends AppCompatActivity {

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

        try{
            is = am.open("info.csv");

            if(is.read(buf) > 0){
                text = new String(buf);
            }

            String[] indat = new String[539];

            for(int i=0;i<539;i++){ //한줄을 자르고
                indat =  text.split("\n");
            }

            String[][] indat1= new String[539][16];

            for(int i=0;i<539;i++){ //각 줄을 또 자르고
                for(int j=0;j<16;j++) {
                    indat1[i] = indat[i].split(",");
                }
            }

            TextView textView = (TextView) findViewById(R.id.text1);
            textView.setText(indat1[537][1]);

            is.close();
        }catch (Exception e){
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
