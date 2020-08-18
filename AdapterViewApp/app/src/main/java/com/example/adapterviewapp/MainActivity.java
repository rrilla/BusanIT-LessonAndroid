package com.example.adapterviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //GridView gridView;
    String[] title={"써니","완득이","괴물","라디오스타","비열한거리",
            "왕의남자","아이랜드","웰컴투동막골","헬보이","백투더피처"};

    int[] ids={R.drawable.mov01,R.drawable.mov02,
            R.drawable.mov03,R.drawable.mov04,
            R.drawable.mov05,R.drawable.mov06,
            R.drawable.mov07,R.drawable.mov08,
            R.drawable.mov09,R.drawable.mov10,
            R.drawable.mov01,R.drawable.mov02,
            R.drawable.mov03,R.drawable.mov04,
            R.drawable.mov05,R.drawable.mov06,
            R.drawable.mov07,R.drawable.mov08,
            R.drawable.mov09,R.drawable.mov10
    };
    Spinner spinner;
    ImageView imageView;
    ArrayAdapter<String> adapter;
    //MyGridAdapter adapter;
//    ListView listView;
//    String[] names={"홍길동","한재현","김림용","이하윤","조양현"};
//    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spiner_layout);
        spinner=findViewById(R.id.spinner);
        imageView=findViewById(R.id.imageView);
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,title);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imageView.setImageResource(ids[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
//        gridView=findViewById(R.id.gridView1);
//        adapter=new MyGridAdapter(this);
//        gridView.setAdapter(adapter);
//        listView=findViewById(R.id.listView1);
//        adapter=new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1,names);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                Toast.makeText(MainActivity.this,
//                        names[position],Toast.LENGTH_LONG).show();
//            }
//        });
    }

    public class MyGridAdapter extends BaseAdapter{
        Context context;
        String[] title={"써니","완득이","괴물","라디오스타","비열한거리",
                "왕의남자","아이랜드","웰컴투동막골","헬보이","백투더피처"};

        int[] ids={R.drawable.mov01,R.drawable.mov02,
                R.drawable.mov03,R.drawable.mov04,
                R.drawable.mov05,R.drawable.mov06,
                R.drawable.mov07,R.drawable.mov08,
                R.drawable.mov09,R.drawable.mov10,
                R.drawable.mov01,R.drawable.mov02,
                R.drawable.mov03,R.drawable.mov04,
                R.drawable.mov05,R.drawable.mov06,
                R.drawable.mov07,R.drawable.mov08,
                R.drawable.mov09,R.drawable.mov10
        };

        public MyGridAdapter(Context context){
            this.context=context;
        }

        @Override
        public int getCount() {
            return ids.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ImageView iv=new ImageView(context);
            iv.setLayoutParams(new GridView.LayoutParams(200,300));
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            iv.setPadding(5,5,5,5);
            iv.setImageResource(ids[position]);

            final int pos=position;
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this,
                            title[pos],Toast.LENGTH_LONG).show();
                }
            });
            return iv;
        }
    }
}