package me.jessyan.mvparms.demo.mvp.contract;

import android.content.Context;

import com.jess.arms.mvp.IView;
import com.jess.arms.mvp.IModel;

import java.util.List;

import me.jessyan.mvparms.demo.mvp.model.entity.MainViewPagerTitleBean;


public interface MainMovieContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {


    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model extends IModel {

        /**
         * 获取显示的标题
         * @param context
         * @return
         */
        List<MainViewPagerTitleBean> getTitles(Context context);

    }
}
