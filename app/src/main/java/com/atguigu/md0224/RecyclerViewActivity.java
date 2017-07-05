package com.atguigu.md0224;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);

        initData();
//        LinearLayoutManager linearLayoutManager
//                = new LinearLayoutManager(this);

        GridLayoutManager manager  = new GridLayoutManager(this,3);

        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //POSITION是第几条item
                //返回值 返回几就是占几列 需要注意返回的列数不能大于设置的列数
                if (position == 0){
                    return 3;
                }
                if (position == 1){
                    return 2;
                }
                return 1;
            }
        });

        rv.setLayoutManager(manager);
        rv.setAdapter(new MyAdapter());
    }

    private void initData() {

        list = new ArrayList<String>();

        for (int i = 0; i < 20; i++) {
            list.add("小龙哥太帅了"+i);
        }
    }


    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @Override
        public RecyclerView.ViewHolder
            onCreateViewHolder(ViewGroup parent, int viewType) {

            if (viewType == 1){
                TextView textView = new TextView(RecyclerViewActivity.this);
                textView.setText("么么哒");
                return new HeadHolder(textView);
            }

            //View view = View.inflate(RecyclerViewActivity.this, R.layout.item, null);
            View view = LayoutInflater.from(RecyclerViewActivity.this)
                    .inflate(R.layout.item,parent,false);
            return new ItemHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (getItemViewType(position) == 1){
                return;
            }

            ItemHolder item = (ItemHolder) holder;
            item.setData(list.get(position-1));


        }

        @Override
        public int getItemCount() {
            return list.size()+1;
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0){
                return 1;
            }
            return super.getItemViewType(position);
        }
    }

    class ItemHolder extends RecyclerView.ViewHolder{

        private  TextView tv;

        public ItemHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.textView);
        }

        public void setData(String data) {
            tv.setText(data);
        }
    }

    class HeadHolder  extends RecyclerView.ViewHolder{

        public HeadHolder(View itemView) {
            super(itemView);
        }
    }
}
