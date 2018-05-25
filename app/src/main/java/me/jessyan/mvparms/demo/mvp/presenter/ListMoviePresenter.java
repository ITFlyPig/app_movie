package me.jessyan.mvparms.demo.mvp.presenter;

import android.app.Application;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import me.jessyan.mvparms.demo.mvp.contract.ListMovieContract;
import me.jessyan.mvparms.demo.mvp.contract.MainMovieContract;
import me.jessyan.mvparms.demo.mvp.model.entity.MainViewPagerTitleBean;
import me.jessyan.mvparms.demo.mvp.ui.adapter.MainMoviePagerAdapter;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;


@ActivityScope
public class ListMoviePresenter extends BasePresenter<ListMovieContract.Model, ListMovieContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;
    @Inject
    List<MainViewPagerTitleBean> mTitles;
    @Inject
    MainMoviePagerAdapter mViewPageAdapter;


    @Inject
    public ListMoviePresenter(ListMovieContract.Model model, ListMovieContract.View rootView) {
        super(model, rootView);
    }

    public void initTitle() {


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }
}
