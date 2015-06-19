package com.example.rssreader;

/**
 * Created by 真菜 on 2015/06/18.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RssListAdapter extends ArrayAdapter<Item> {
    private LayoutInflater mInflater;
    private TextView mTitle;
    private TextView mDescr;
    private TextView mDate;

    public RssListAdapter(Context context, List<Item> objects) {
        super(context, 0, objects);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // 1行ごとのビューを生成する
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (convertView == null) {
            view = mInflater.inflate(R.layout.item_row, null);
        }

        // 現在参照しているリストの位置からItemを取得する
        Item item = this.getItem(position);
        if (item != null) {
            // Itemから必要なデータを取り出し、それぞれTextViewにセットする
            String title = item.getTitle().toString();
            mTitle = (TextView) view.findViewById(R.id.item_title);
            mTitle.setText(title);
            String date = item.getDate().toString();
            mDate = (TextView) view.findViewById(R.id.item_date);
            mDate.setText(date);
       //     String descr = item.getDescription().toString();
         //   mDescr = (TextView) view.findViewById(R.id.item_descr);
         //   mDescr.setText(descr);
        }
        return view;
    }
}