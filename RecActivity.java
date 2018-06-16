package com.example.sonhyejin.eat_ku;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static com.example.sonhyejin.eat_ku.MainmenuActivity.reci;

public class RecActivity extends AppCompatActivity {

    ListView listView;
    SingerAdapter adapter;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_rec);

        Button home = (Button)findViewById(R.id.home2);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //FixRefActivity 페이지로 넘어가기 (fix_Refrigerator : 냉장고 편집)
                Intent intent = new Intent(RecActivity.this, MainmenuActivity.class);
                startActivity(intent);
            }
        });

        listView = (ListView) findViewById(R.id.listView);

        adapter = new SingerAdapter();

        for (i=0; i<reci.size(); i++){
            if(reci.get(i).ing_1 < 10){
                adapter.addItem(new SingerItem(reci.get(i).name, R.drawable.piano));
            }else if (reci.get(i).ing_1>=10 && reci.get(i).ing_1 < 50){
                adapter.addItem(new SingerItem(reci.get(i).name, R.drawable.book));
            }else {
                adapter.addItem(new SingerItem(reci.get(i).name, R.drawable.peach));
            }
        }

        //url로 이미지 표시하는 구문을 어디에 넣어야 할지...

        listView.setAdapter(adapter);


        //클릭하면 레시피 과정 보여주는 페이지로 넘어가도록 고칠 것
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(RecActivity.this, WebViewActivity.class);
                intent.putExtra("sentUrl","www.naver.com");
                startActivity(intent);
            }
        });

    }

    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            SingerItemView view = new SingerItemView(getApplicationContext());

            SingerItem item = items.get(position);
            view.setName(item.getName());
            view.setImage(item.getResId());

            return view;
        }
    }

}
