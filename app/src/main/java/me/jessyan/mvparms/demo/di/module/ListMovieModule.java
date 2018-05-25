package me.jessyan.mvparms.demo.di.module;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
import me.jessyan.mvparms.demo.mvp.model.entity.Movie;
import me.jessyan.mvparms.demo.mvp.ui.adapter.ListMovieAdapter;
import me.jessyan.mvparms.demo.mvp.ui.adapter.MainMoviePagerAdapter;


@Module
public class ListMovieModule {
    private ListMovieContract.View view;

    /**
     * 构建MainMovieModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ListMovieModule(ListMovieContract.View view) {
        this.view = view;

    }

    @ActivityScope
    @Provides
    ListMovieContract.View provideListMovieView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ListMovieContract.Model provideListMovieModel(ListMovieModel model) {
        return model;
    }



    @ActivityScope
    @Provides
    RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(view.getActivity());
    }

    @ActivityScope
    @Provides
    ListMovieAdapter provideListMovieAdapter(List<Movie> movies) {
        return new ListMovieAdapter(movies);
    }

    @ActivityScope
    @Provides
    List<Movie> provideMovieList() {
        return new ArrayList<>();
    }


}