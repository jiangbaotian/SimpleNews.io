package com.kong.app.news.list;


import com.baselib.mvp.BaseSubPresenter;
import com.baselib.mvp.BaseView;
import com.kong.app.news.beans.NewModel;

import java.util.List;

/**
 * Created by whiskeyfei on 16/11/6.
 */

public interface NewsContract {
    interface View extends BaseView<Presenter> {
        void showProgress();

        void addNews(List<NewModel> newsList);

        void hideProgress();

        void showLoadFailMsg();

        void setEnd(boolean isEnd);
    }

    interface Presenter extends BaseSubPresenter {
        void loadNews(String url, int page);
    }
}
