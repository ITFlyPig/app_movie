package me.jessyan.mvparms.demo.di.module;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.jess.arms.di.scope.ActivityScope;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import me.jessyan.mvparms.demo.mvp.contract.ListMovieContract;
import me.jessyan.mvparms.demo.mvp.contract.MainMovieContract;
import me.jessyan.mvparms.demo.mvp.model.ListMovieModel;
import me.jessyan.mvparms.demo.mvp.model.MainMovieModel;
import me.jessyan.mvparms.demo.mvp.model.entity.MainViewPagerTitleBean;
import me.jessyan.mvparms.demo.mvp.ui.adapter.MainMoviePagerAdapter;


@Module
public class MainMovieModule {
    private MainMovieContract.View view;
    private FragmentManager fm;

    /**
     * 构建MainMovieModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MainMovieModule(MainMovieContract.View view, FragmentManager fm) {
        this.view = view;
        this.fm = fm;

    }

    @ActivityScope
    @Provides
    MainMovieContract.View provideMainMovieView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MainMovieContract.Model provideMainMovieModel(MainMovieModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    List<MainViewPagerTitleBean> provideViewPagerTitles(){
        return new ArrayList<>();
    }

    @ActivityScope
    @Provides
    List<Fragment> provideFragments(){
        return new ArrayList<>();
    }

    @ActivityScope
    @Provides
    MainMoviePagerAdapter provideMainMoviePagerAdapter(List<Fragment> fragments, List<MainViewPagerTitleBean> titles){
        return new MainMoviePagerAdapter(fm ,titles, fragments);
    }


}