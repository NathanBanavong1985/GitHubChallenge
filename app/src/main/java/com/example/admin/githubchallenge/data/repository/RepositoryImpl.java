package com.example.admin.githubchallenge.data.repository;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.admin.githubchallenge.data.remote.RemoteServiceHelper;
import com.example.admin.githubchallenge.models.GithubResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RepositoryImpl implements Repository {

    private MutableLiveData<GithubResponse> githubResponseMutableLiveData;
    private RemoteServiceHelper remoteServiceHelper;

    public RepositoryImpl(MutableLiveData<GithubResponse> githubResponseMutableLiveData, RemoteServiceHelper remoteServiceHelper) {
        this.githubResponseMutableLiveData = githubResponseMutableLiveData;
        this.remoteServiceHelper = remoteServiceHelper;
    }

    @SuppressLint("CheckResult")
    @Override
    public void getRepositories(String search) {
        remoteServiceHelper.getRepositories(search)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> githubResponseMutableLiveData.setValue(response), Throwable::printStackTrace);

    }

    @Override
    public LiveData<GithubResponse> getResponseLiveData() {
        return githubResponseMutableLiveData;
    }
}
