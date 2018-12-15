package com.kong.web.app.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.baselib.app.AppRunTime;
import com.baselib.base.ToolBarActivity;
import com.baselib.utlis.SToast;
import com.baselib.widget.SafeWebView;
import com.kong.web.R;

public class NewsDetailActivity extends ToolBarActivity implements DetailContract.View {

    public static final String URL = "key_url";
    public static final String TITLE = "key_title";

    private String mTitle;
    private String mUrl;

    private LinearLayout mLinearLayout;
    private SafeWebView mWebView;
    private DetailContract.Presenter mNewsDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news_detail;
    }

    private void initView() {
        setTitle(mTitle);
        mLinearLayout = (LinearLayout) findViewById(R.id.detail_webview_root);
        mWebView = new SafeWebView(AppRunTime.get().getApplicationContext());
        mWebView.setScrollBarStyle(WebView.SCROLLBARS_INSIDE_OVERLAY);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        mLinearLayout.addView(mWebView, lp);
        mNewsDetailPresenter = new NewsDetailPresenter(this);
        mNewsDetailPresenter.init(mWebView);
        mNewsDetailPresenter.loadUrl(mUrl);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mTitle = intent.getStringExtra(TITLE);
            mUrl = intent.getStringExtra(URL);
        }
    }

    @Override
    protected void onPause() {
        if (mWebView != null) {
            mWebView.onPause();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        if (mWebView != null) {
            mWebView.onResume();
        }
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mLinearLayout.removeView(mWebView);
        if (mWebView != null) {
            mWebView.onDestroy();
        }
        mWebView = null;
        super.onDestroy();
    }

    @Override
    public void showLoadErrorMessage(String description) {
        mWebView.setVisibility(View.GONE);
        SToast.makeText(NewsDetailActivity.this, getString(R.string.detail_load_fail), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        mNewsDetailPresenter = presenter;
    }
}
