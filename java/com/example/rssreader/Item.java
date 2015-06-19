package com.example.rssreader;

/**
 * Created by 真菜 on 2015/06/18.
 */
public class Item {
    // 記事のタイトル
    private CharSequence mTitle;
    //更新日時
   private CharSequence mDate;
    // 記事の本文
    private CharSequence mDescription;

    public Item() {
        mTitle = "";
        mDescription = "";
    }

    public CharSequence getDescription() {
        return mDescription;
    }

    public void setDescription(CharSequence description) {
        mDescription = description;
    }

    public CharSequence getTitle() {
        return mTitle;
    }

    public void setTitle(CharSequence title) {
        mTitle = title;
    }

    public CharSequence getDate() {
        return mDate;
    }

    public void setDate(CharSequence date) {
        mDate = date;
    }

}
