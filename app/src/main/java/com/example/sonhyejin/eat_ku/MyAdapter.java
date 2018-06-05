package com.example.sonhyejin.eat_ku;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<String>{
    final Context context;
    ArrayList<String> foods;

    public MyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.foods = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if(view==null){
            LayoutInflater lf =  (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = lf.inflate(R.layout.row,parent,false);
        }

        TextView tt = (TextView)view.findViewById(R.id.textview);

        if(tt!=null){
            tt.setText(foods.get(position));
        }

        return view;
    }

}
