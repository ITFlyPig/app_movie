package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.di.component.DaggerMainMovieComponent;
import me.jessyan.mvparms.demo.di.module.MainMovieModule;
import me.jessyan.mvparms.demo.mvp.contract.MainMovieContract;
import me.jessyan.mvparms.demo.mvp.presenter.MainMoviePresenter;
import me.jessyan.mvparms.demo.mvp.ui.adapter.MainMoviePagerAdapter;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainMovieActivity extends BaseActivity<MainMoviePresenter> implements MainMovieContract.View {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Inject
    MainMoviePagerAdapter mMainMoviePagerAdapter;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainMovieComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainMovieModule(new MainMovieModule(this, getSupportFragmentManager()))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        viewpager.setAdapter(mMainMoviePagerAdapter);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

}
