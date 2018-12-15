package com.kong.app.blog;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baselib.app.AppRunTime;
import com.kong.R;
import com.kong.app.blog.model.Feed;
import com.kong.app.news.NewsEntry;
import com.kong.app.news.beans.NewModel;
import com.kong.lib.adapter.BaseViewHolder;
import com.kong.lib.utils.ImageLoaderUtils;
import com.kong.lib.utils.StringUtils;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by CaoPengfei on 17/6/18.
 */

public class BlogItemViewBinder extends ItemViewBinder<Feed.PostsBean.ItemsBean,BlogItemViewBinder.ViewHolder> {

    private static final String TAG = "BlogItemViewBinder";

    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ViewHolder(parent,R.layout.item_blog);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Feed.PostsBean.ItemsBean item) {
        holder.setData(item);
    }

    @Override
    protected void onViewRecycled(@NonNull ViewHolder holder) {
        holder.onViewRecycled();
    }

    static class ViewHolder extends BaseViewHolder<Feed.PostsBean.ItemsBean> implements View.OnClickListener {
        private TextView name;
        private TextView title;
        private TextView info;
        private ImageView icon;
        private Feed.PostsBean.ItemsBean mItemModel;

        public ViewHolder(ViewGroup parent, @LayoutRes int res) {
            super(parent, res);
            icon = findViewById(R.id.item_blog_icon);
            title = findViewById(R.id.item_blog_title_id);
            name = findViewById(R.id.item_blog_name_id);
            info = findViewById(R.id.item_blog_info_id);
            setOnClickListener(this);
        }

        @Override
        public void setData(Feed.PostsBean.ItemsBean itemModel) {
            mItemModel = itemModel;
            if (itemModel == null){
                return;
            }
            if (StringUtils.isEmpty(itemModel.getAuthor())){
                itemModel.setAuthor("Tom");
            }
            name.setText(itemModel.getAuthor() + "  " + itemModel.getDate_published().substring(0,10));
            title.setText(itemModel.getTitle());
            if (StringUtils.isEmpty(itemModel.getKeywords())){
                itemModel.setKeywords("Android");
            }
            info.setText("Keywords: " + itemModel.getKeywords());
            if (!StringUtils.isEmpty(itemModel.getCover())){
                icon.setVisibility(View.VISIBLE);
                ImageLoaderUtils.display(AppRunTime.get().getApplicationContext(), icon, itemModel.getCover(),R.drawable.ic_image_loading, R.drawable.ic_image_loadfail);
            }
        }

        @Override
        public void onClick(View v) {
            if (mItemModel == null){
                return;
            }
            NewModel model = new NewModel();
            model.newUrl = mItemModel.getUrl();
            model.title = mItemModel.getTitle();
            NewsEntry.get().startBrowser(v.getContext(),mItemModel.getUrl(),mItemModel.getTitle());
        }

        @Override
        public void onViewRecycled() {
            Log.i(TAG,"onViewRecycled");
        }
    }
}
