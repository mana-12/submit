package com.example.rssreader;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;


public class RssReaderActivity extends ListActivity {
    public static final String RSS_FEED_URL = "http://news.livedoor.com/topics/rss/top.xml";
    private ArrayList<Item> mItems;
    private RssListAdapter mAdapter;
    public static final int MENU_ITEM_RELOAD = Menu.FIRST;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss_reader);


        // Itemオブジェクトを保持するためのリストを生成し、アダプタに追加する
        mItems = new ArrayList<Item>();
        mAdapter = new RssListAdapter(this, mItems);

        // タスクを起動する
        RssParserTask task = new RssParserTask(this, mAdapter);
        task.execute(RSS_FEED_URL);
    }

    //リスト項目を選択した時の処理
    @Override
    protected void  onListItemClick(ListView l,View v,int position,long id){
        Item item = mItems.get(position);
        Intent intent = new Intent(this,ItemDetailActivity.class);
        intent.putExtra("TITLE",item.getTitle());
        intent.putExtra("DESCRIPTION",item.getDescription());
        startActivity(intent);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);
        // デフォルトではアイテムを追加した順番通りに表示する
        menu.add(0, MENU_ITEM_RELOAD, 0, "更新");
        return result;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // 更新
            case MENU_ITEM_RELOAD:
                // アダプタを初期化し、タスクを起動する
                mItems = new ArrayList();
                mAdapter = new RssListAdapter(this, mItems);
                // タスクはその都度生成する
                RssParserTask task = new RssParserTask(this, mAdapter);
                task.execute(RSS_FEED_URL);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}