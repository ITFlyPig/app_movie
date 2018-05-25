package me.jessyan.mvparms.demo.mvp.ui.holder;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jess.arms.base.BaseHolder;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindView;
import io.reactivex.Observable;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.mvp.model.entity.Movie;

public class MovieItemHolder extends BaseHolder<Movie> {
    @BindView(R.id.iv_poster)
    ImageView ivPoster;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_rank)
    TextView tvRank;
    @BindView(R.id.tv_type)
    TextView tvType;

    private AppComponent mAppComponent;
    private ImageLoader mImageLoader;//用于加载图片的管理类,默认使用 Glide,使用策略模式,可替换框架


    public MovieItemHolder(View itemView) {
        super(itemView);
        //可以在任何可以拿到 Context 的地方,拿到 AppComponent,从而得到用 Dagger 管理的单例对象
        mAppComponent = ArmsUtils.obtainAppComponentFromContext(itemView.getContext());
        mImageLoader = mAppComponent.imageLoader();
    }

    @Override
    public void setData(Movie data, int position) {
        Observable.just(data.name)
                .filter(s -> TextUtils.isEmpty(s))
                .subscribe(s -> tvTitle.setText(s));

        Observable.just(data.rank)
                .filter(rank -> rank <= 0)
                .map(rank -> "评分：" + rank)
                .subscribe(rank -> tvRank.setText(rank));

        Observable.just(data.type)
                .filter(type -> TextUtils.isEmpty(type))
                .subscribe(type -> {tvType.setText(type); tvType.setVisibility(View.VISIBLE);});


        //itemView 的 Context 就是 Activity, Glide 会自动处理并和该 Activity 的生命周期绑定
        mImageLoader.loadImage(itemView.getContext(),
                ImageConfigImpl
                        .builder()
                        .url(data.poster)
                        .imageView(ivPoster)
                        .build());


    }

    @Override
    protected void onRelease() {
        super.onRelease();
        mImageLoader.clear(mAppComponent.application(), ImageConfigImpl.builder()
                .imageViews(ivPoster)
                .build());
    }
}
