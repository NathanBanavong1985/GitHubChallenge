package com.example.admin.githubchallenge;

import android.app.Application;

import com.example.admin.githubchallenge.di.application.ApplicationComponent;
import com.example.admin.githubchallenge.di.application.DaggerApplicationComponent;

public class AppController extends Application {

    private ApplicationComponent applicationComponent;

    public ApplicationComponent getApplicationComponent() {
        if (applicationComponent == null) {
            applicationComponent = createApplicationComponent();
        }
        return applicationComponent;
    }

    private ApplicationComponent createApplicationComponent() {
        return DaggerApplicationComponent.create();
    }
}
