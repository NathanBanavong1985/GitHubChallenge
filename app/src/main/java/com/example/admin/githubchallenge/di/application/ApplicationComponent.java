package com.example.admin.githubchallenge.di.application;

import com.example.admin.githubchallenge.data.remote.RemoteServiceHelper;
import com.example.admin.githubchallenge.di.activity.ActivityComponent;
import com.example.admin.githubchallenge.di.activity.ActivityModule;

import dagger.Component;

@ApplicationScope
@Component(modules = {ApplicationModule.class, LiveDataModule.class})
public interface ApplicationComponent {

    RemoteServiceHelper getRemoteServiceHelper();

    ActivityComponent newActivityComponent(ActivityModule activityModule);
}
