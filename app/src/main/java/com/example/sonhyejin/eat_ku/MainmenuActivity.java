package com.example.sonhyejin.eat_ku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainmenuActivity extends AppCompatActivity {
    final static int MAX_INDEX = 20;
    static ArrayList<Ingredient> ing;       //재료를 담는 ArrayList
    static DatabaseReference rdb;
    static ArrayList<Recipe> reci;      //레시피를 담는 ArrayList

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.v("aa","aas");

        ing = new ArrayList<>();

        Scanner scan=new Scanner(getResources().openRawResource(R.raw.food));

        while(scan.hasNextLine()) {
            //Toast.makeText(this,"hi",Toast.LENGTH_SHORT).show();
            String str=scan.nextLine();

            StringTokenizer st=new StringTokenizer(str, ",");
            while(st.hasMoreTokens()) {
                //String str2 = st.nextToken().toString();
                //Toast.makeText(this,str2,Toast.LENGTH_SHORT).show();
                //int i = Integer.parseInt(st.nextToken());
                //Log.d("checkk", );
                //Log.d("checkk", st.nextToken());
                //Log.d("checkk", st.nextToken());
                //Log.d("checkk", st.nextToken());
                ing.add(new Ingredient(st.nextToken(), st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken())));
            }
        }



        DatabaseReference rdb= FirebaseDatabase.getInstance().getReference("Ingredient");
        for(int i=0;i<ing.size();i++)
            rdb.child(Integer.toString(i)).setValue(ing.get(i));

        int j=0;
        reci = new ArrayList<Recipe>();

        Scanner scan2=new Scanner(getResources().openRawResource(R.raw.recipe));

        while(scan2.hasNextLine()) {
           // String[] reciArray = new String[MAX_INDEX];
            String str=scan2.nextLine();

            StringTokenizer st=new StringTokenizer(str, ",");
            String num = st.nextToken();
            String name = st.nextToken();
            Recipe temprecipe = new Recipe(num,name);

            /*
            while(st.hasMoreTokens()) {
                if(k>MAX_INDEX)
                    break;
                else {
                    temprecipe.ing[idx++] = Integer.parseInt(st.nextToken());
                    temprecipe.setIndex();
                }
            }
            */

            if (st.hasMoreTokens()){
                temprecipe.setIng_1(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                temprecipe.setIng_2(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                temprecipe.setIng_3(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                temprecipe.setIng_4(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                temprecipe.setIng_5(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                temprecipe.setIng_6(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                temprecipe.setIng_7(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                temprecipe.setIng_8(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                temprecipe.setIng_9(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                temprecipe.setIng_10(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                temprecipe.setIng_11(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                temprecipe.setIng_12(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                temprecipe.setIng_13(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                temprecipe.setIng_14(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                temprecipe.setIng_15(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                temprecipe.setIng_16(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                temprecipe.setIng_17(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                temprecipe.setIng_18(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                temprecipe.setIng_19(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                temprecipe.setIng_20(Integer.parseInt(st.nextToken()));
            }



            //temprecipe.setFood_idx(reciArray);
            reci.add(temprecipe);

        }

        int i=0;
        DatabaseReference rdb2= FirebaseDatabase.getInstance().getReference("Recipes");
        for(i=0;i<reci.size();i++) {
            rdb2.child(i + "").setValue(reci.get(i));
        }
        Toast.makeText(this,i+"",Toast.LENGTH_SHORT).show();


        Button fix_ref = (Button)findViewById(R.id.Fix_ref);
        Button rec_rec = (Button)findViewById(R.id.Rec_rec);


        fix_ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //FixRefActivity 페이지로 넘어가기 (fix_Refrigerator : 냉장고 편집)
                Intent intent = new Intent(MainmenuActivity.this, FixRefActivity.class);
                startActivity(intent);
            }
        });
        rec_rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Rec_rec페이지로 넘어가기 (recommend_recipe : 레시피 추천)
                Intent intent = new Intent(MainmenuActivity.this, RecActivity.class);
                startActivity(intent);
            }
        });
    }
}
