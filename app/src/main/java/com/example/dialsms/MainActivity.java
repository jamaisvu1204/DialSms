package com.example.dialsms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private String[] numbers={"10010","10086","13631027469"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.list);
        List<String> number = new LinkedList<>();
        MyAdapter myAdapter = new MyAdapter();
        lv.setAdapter(myAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this,DialandSms.class);
                String num = (String) lv.getItemAtPosition(position);
                i.putExtra("number",num);
                startActivity(i);
            }
        });
    }
    class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return numbers.length;
        }

        @Override
        public Object getItem(int position) {
            return numbers[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = View.inflate(MainActivity.this,R.layout.list_item,null);
            TextView tv = (TextView) view.findViewById(R.id.tv);
            tv.setText(numbers[position]);
            return view;
        }

    }
}
