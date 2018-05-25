package me.jessyan.mvparms.demo.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;
import me.jessyan.mvparms.demo.di.module.ListMovieModule;
import me.jessyan.mvparms.demo.mvp.ui.fragment.ListMovieFragment;

@ActivityScope
@Component(modules = ListMovieModule.class, dependencies = AppComponent.class)
public interface ListMovieComponent {
    void inject(ListMovieFragment fragment);
}
