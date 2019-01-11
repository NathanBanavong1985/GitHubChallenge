package com.example.admin.githubchallenge.di.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.githubchallenge.R;
import com.example.admin.githubchallenge.databinding.ActivityMainBinding;
import com.example.admin.githubchallenge.factories.MainViewModelFactory;
import com.example.admin.githubchallenge.ui.MainViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public MainViewModel providesMainViewModel(MainViewModelFactory factory) {
        return ViewModelProviders.of(activity, factory).get(MainViewModel.class);
    }

    @Provides
    @ActivityScope
    public ActivityMainBinding providesActivityMainBinding() {
        return DataBindingUtil.setContentView(activity, R.layout.activity_main);
    }

}
