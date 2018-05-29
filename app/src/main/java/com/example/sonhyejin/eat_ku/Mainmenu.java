package com.example.sonhyejin.eat_ku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mainmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fix_ref = (Button)findViewById(R.id.Fix_ref);
        Button rec_rec = (Button)findViewById(R.id.Rec_rec);


        fix_ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Fix_ref 페이지로 넘어가기 (fix_Refrigerator : 냉장고 편집)
                Intent intent = new Intent(Mainmenu.this, Fix_ref.class);
                startActivity(intent);
            }
        });
        rec_rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Rec_rec페이지로 넘어가기 (recommend_recipe : 레시피 추천)
                Intent intent = new Intent(Mainmenu.this, Rec_rec.class);
                startActivity(intent);
            }
        });
    }
}
