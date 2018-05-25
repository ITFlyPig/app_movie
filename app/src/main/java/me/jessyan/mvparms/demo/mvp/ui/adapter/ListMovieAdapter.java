package me.jessyan.mvparms.demo.mvp.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;

import java.util.List;

import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.mvp.model.entity.Movie;
import me.jessyan.mvparms.demo.mvp.ui.holder.MovieItemHolder;

public class ListMovieAdapter extends DefaultAdapter<Movie> {


    public ListMovieAdapter(List<Movie> movies) {
        super(movies);
    }

    @Override
    public BaseHolder<Movie> getHolder(View v, int viewType) {
        return new MovieItemHolder(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_movie;
    }
}
