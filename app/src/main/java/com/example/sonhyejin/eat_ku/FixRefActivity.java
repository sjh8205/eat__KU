package com.example.sonhyejin.eat_ku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ArrayAdapter;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static com.example.sonhyejin.eat_ku.MainmenuActivity.ing;
import static com.example.sonhyejin.eat_ku.MainmenuActivity.reci;

public class FixRefActivity extends AppCompatActivity {

    EditText searchText;
    ArrayList<String> foods;
    ListView listView;
    MyAdapter myAdapter;
    String[] items = { "쇠고기","감자","양파","당근","완두콩","카레","우유","밥","소금","후추","계란","쌈장","청피망","홍피망","바게트","버터",
            "오이","전분","멸치","다시마","냉면","동치미국물","배","식초","설탕","동치미무","국수","표고버섯","부추","양념장","상추","깻잎","두부"
            ,"파","마늘","고추장","참기름","쇠고기육수","진간장","콩나물","모시조개","북어","홍고추","실파","밀가루","무","국간장","미역"
            ,"식용유","대파","깨소금","고춧가루","간장","양송이버섯","피망","물엿","토마토케첩","꿀","레몬즙","연겨자","적양배추잎","파프리카"
            ,"실고추","우엉","잔멸치","청고추","청주","배추김치","돼지고기","가래떡","육수","생강즙","유부","꽈리고추","마른오징어","애호박"
            ,"쑥갓","배즙","라면","햄","게맛살","도토리묵","청포묵","가지","마른새우","골뱅이통조림","샐러리","소면","통깨","스파게티","생크림"
            ,"베이컨","바질","화이트와인","파슬리","토마토","계핏가루","파슬리가루","후루츠칵테일","사과","자몽","딸기","오렌지마요네즈"
            ,"훈제연어","앤다이브","트레비스","케이퍼","올리브오일","시금치","파마산치즈","레몬드레싱","레몬주스","월계수잎","무순","찹쌀가루"
            ,"된장","적파프리카","황파프리카","브로콜리","날콩가루","옥수수","녹말","양배추","미나리","어묵","다시물","맛술","오징어","느타리버섯"
            ,"팽이버섯","김치","단무지","새우","피망","비엔나소시지","참치","미림","호박","새우젓","생강","굴소스","조미술","국물용멸치","순대","쫄면"
            ,"들깻가루","프랑크소시지","마요네즈","머스터드","파스타","오징어채","술","옥수수통조림","청정원맛선생","풋고추","냉동만두","양상추","올리브"
            ,"배추","죽순","숙주","우동면","핫소스","땅콩버터","체리알","사워크림","단호박","황설탕","쌀","포도씨유","칵테일새우","신김치","청정원국선생"
            ,"김","새싹채소","만두피","방울토마토","샐러드채소","어린잎채소","부침유","올리브유","청양고추","셀러리"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_ref);

        AutoCompleteTextView edit = (AutoCompleteTextView) findViewById(R.id.searchText);

        edit.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, items));


        searchText = (EditText)findViewById(R.id.searchText);
        Button home = (Button)findViewById(R.id.home1);

        listView = (ListView)findViewById(R.id.list_item);
        foods= new ArrayList<String>();
        myAdapter = new MyAdapter(this,R.layout.row,foods);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                foods.remove(position);
                listView.setAdapter(myAdapter);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //FixRefActivity 페이지로 넘어가기 (fix_Refrigerator : 냉장고 편집)
                Intent intent = new Intent(FixRefActivity.this, MainmenuActivity.class);
                startActivity(intent);
            }
        });


    }

    public void btnSearch(View view) {

        int count=0;
        String food = searchText.getText().toString();

        int i = 0;

       for(; i< ing.size() ; i++)
       {
           if(food.equals(ing.get(i).name)  && ing.get(i).have == 0)
           {
               count++;
               break;
           }
       }

        if(count>0)
        {
            //Toast.makeText(this, "check", Toast.LENGTH_SHORT).show();
            foods.add(food);
            listView.setAdapter(myAdapter);
            count = 0;
//            ing.get(i).have++;
            DatabaseReference rdb2= FirebaseDatabase.getInstance().getReference("Ingredient");


            if(ing.get(i).sort.equals("주재료"))
            {
                Toast.makeText(this, "check", Toast.LENGTH_SHORT).show();
                rdb2.child(Integer.toString(i)).child("have").setValue(5);
                ing.get(i).have = 5;
            }
            else if(ing.get(i).sort.equals("부재료"))
            {
                rdb2.child(Integer.toString(i)).child("have").setValue(3);
                ing.get(i).have = 3;
            }
            else if(ing.get(i).sort.equals("양념"))
            {
                rdb2.child(Integer.toString(i)).child("have").setValue(1);
                ing.get(i).have = 1;
            }


        }
/*
        int have_reci=0;

        for(int j=0 ; j< reci.size() ; j++)
        {
            //reci안의 ing_1~20까지의 변수에 들어있는 변수 == num인 ingredient의 요소의 have값을 다 더함

            if(have_reci>10)
            {
                //그 때의 reci의 boolen변수를 1로 바꿔준다.
            }
        }
*/

    }

    public void Reset(View view) {
        foods.clear();
        Toast.makeText(this,"초기화 성공!",Toast.LENGTH_SHORT).show();
        listView.setAdapter(myAdapter);
        for(int i=0 ; i<ing.size() ; i++)
        {
            DatabaseReference rdb3= FirebaseDatabase.getInstance().getReference("Ingredients");
            rdb3.child(Integer.toString(i+1)).child("have").setValue(0);
        }
    }
}