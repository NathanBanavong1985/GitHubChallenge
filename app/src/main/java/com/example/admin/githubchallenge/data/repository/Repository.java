package com.example.admin.githubchallenge.data.repository;

import android.arch.lifecycle.LiveData;

import com.example.admin.githubchallenge.models.GithubResponse;

public interface Repository {

    void getRepositories(String search);

    LiveData<GithubResponse> getResponseLiveData();
}
