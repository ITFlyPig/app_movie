package me.jessyan.mvparms.demo.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.Unbinder;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.di.component.DaggerListMovieComponent;
import me.jessyan.mvparms.demo.di.module.ListMovieModule;
import me.jessyan.mvparms.demo.mvp.contract.ListMovieContract;
import me.jessyan.mvparms.demo.mvp.presenter.ListMoviePresenter;
import me.jessyan.mvparms.demo.mvp.ui.adapter.ListMovieAdapter;

public class ListMovieFragment extends BaseFragment<ListMoviePresenter> implements ListMovieContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Inject
    RecyclerView.LayoutManager mLayoutManager;

    @Inject
    ListMovieAdapter mListMovieAdapter;

    Unbinder unbinder;

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerListMovieComponent
                .builder()
                .appComponent(appComponent)
                .listMovieModule(new ListMovieModule(this))
                .build()
                .inject(this);


    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initRecyclerView();
        return inflater.inflate(R.layout.fragment_movie_list, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {


    }

    @Override
    public void setData(@Nullable Object data) {


    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void launchActivity(@NonNull Intent intent) {

    }

    @Override
    public void killMyself() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initRecyclerView() {
        ArmsUtils.configRecyclerView(mRecyclerView, mLayoutManager);
        mRecyclerView.setAdapter(mListMovieAdapter);
    }



}
