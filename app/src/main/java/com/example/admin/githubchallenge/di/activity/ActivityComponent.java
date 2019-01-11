package com.example.admin.githubchallenge.di.activity;

import com.example.admin.githubchallenge.ui.MainActivity;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
