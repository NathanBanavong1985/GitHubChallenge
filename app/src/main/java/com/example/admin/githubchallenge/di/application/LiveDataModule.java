package com.example.admin.githubchallenge.di.application;

import android.arch.lifecycle.MutableLiveData;

import com.example.admin.githubchallenge.models.GithubResponse;

import dagger.Module;
import dagger.Provides;

@Module
public class LiveDataModule {

    @Provides
    public MutableLiveData<GithubResponse> providesGithubResponseMutableLiveData() {
        return new MutableLiveData<>();
    }
}
