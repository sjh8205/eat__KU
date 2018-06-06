package com.example.sonhyejin.eat_ku;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Fix_ref extends AppCompatActivity {

    EditText searchText;
    ArrayList<String> foods;
    ListView listView;
    MyAdapter myAdapter;
    String[] items = { "SM3", "SM5", "SM7", "SONATA", "AVANTE", "SOUL", "K5",
            "K7" };

    String[] cmp2 = {"SM3", "SM5", "SM7", "SONATA", "AVANTE", "SOUL", "K5",
            "K7"};
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
            public void onClick(View v) { //Fix_ref 페이지로 넘어가기 (fix_Refrigerator : 냉장고 편집)
                Intent intent = new Intent(Fix_ref.this, Mainmenu.class);
                startActivity(intent);
            }
        });


    }

    public void btnSearch(View view) {

        int count=0;
        String food = searchText.getText().toString();

        for(int i=0 ; i<cmp2.length ; i++)
        {
            if(food.equals(cmp2[i]))
            {
                count++;
            }
        }

        if(count>0)
        {
            foods.add(food);
            listView.setAdapter(myAdapter);
            count = 0;
        }

    }

    public void Reset(View view) {
        foods.clear();
        Toast.makeText(this,"초기화 성공!",Toast.LENGTH_SHORT).show();
        listView.setAdapter(myAdapter);
    }
}