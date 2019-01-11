package com.example.admin.githubchallenge.di.application;

import android.arch.lifecycle.MutableLiveData;

import com.example.admin.githubchallenge.data.remote.RemoteServiceHelper;
import com.example.admin.githubchallenge.data.repository.Repository;
import com.example.admin.githubchallenge.data.repository.RepositoryImpl;
import com.example.admin.githubchallenge.models.GithubResponse;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Provides
    @ApplicationScope
    public Repository providesRepository(MutableLiveData<GithubResponse> liveData, RemoteServiceHelper remoteServiceHelper) {
        return new RepositoryImpl(liveData, remoteServiceHelper);
    }
}
