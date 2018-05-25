package me.jessyan.mvparms.demo.mvp.model;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.integration.cache.ACache;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import java.util.List;
import java.util.Observable;

import javax.inject.Inject;

import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.mvp.contract.MainMovieContract;
import me.jessyan.mvparms.demo.mvp.model.entity.MainViewPagerTitleBean;
import me.jessyan.mvparms.demo.utils.Constant;


@ActivityScope
public class MainMovieModel extends BaseModel implements MainMovieContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public MainMovieModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public List<MainViewPagerTitleBean> getTitles(Context context) {
        if (context == null) {
            return null;
        }

         ACache.get(context).getAsString(Constant.DataKey.MOVIE_TITLES);
        String[] titles = context.getResources().getStringArray(R.array.movie_sort_titles);
        return null;
    }
}