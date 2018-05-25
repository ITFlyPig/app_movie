package me.jessyan.mvparms.demo.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import me.jessyan.mvparms.demo.di.module.MainMovieModule;

import com.jess.arms.di.scope.ActivityScope;

import me.jessyan.mvparms.demo.mvp.ui.activity.MainMovieActivity;

@ActivityScope
@Component(modules = MainMovieModule.class, dependencies = AppComponent.class)
public interface MainMovieComponent {
    void inject(MainMovieActivity activity);
}