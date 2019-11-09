package com.example.ssl.json.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.ssl.json.R;
import com.example.ssl.json.bean.Menu;

import java.util.List;

/**
 * Created by ssl on 2019/11/9.
 */

public class MenuAdapter extends BaseQuickAdapter<Menu,BaseViewHolder> {
    public MenuAdapter(@LayoutRes int layoutResId, @Nullable List<Menu> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Menu item) {
        helper.setText(R.id.Titles,item.getTitle());
        helper.setText(R.id.Contents,item.getContent());
        Glide.with(mContext).load(item.getImg()).into((ImageView)helper.getView(R.id.Images));

    }
}
