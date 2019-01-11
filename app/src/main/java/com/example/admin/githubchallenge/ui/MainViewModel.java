package com.example.admin.githubchallenge.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.example.admin.githubchallenge.adapters.RepositoriesAdapter;
import com.example.admin.githubchallenge.data.repository.Repository;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {

    private Repository repository;

    @Inject
    public MainViewModel(Repository repository) {
        this.repository = repository;
    }

    public void getRepositories(String searchQuery) {
        repository.getRepositories(searchQuery);
    }

    public LiveData<RepositoriesAdapter> getRepositoriesLiveData() {
        return Transformations.map(repository.getResponseLiveData(),
                response -> new RepositoriesAdapter(response.getItems()));
    }
}
