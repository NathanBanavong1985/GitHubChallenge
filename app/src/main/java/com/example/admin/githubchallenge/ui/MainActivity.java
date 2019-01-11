package com.example.admin.githubchallenge.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.KeyEvent;

import com.example.admin.githubchallenge.AppController;
import com.example.admin.githubchallenge.databinding.ActivityMainBinding;
import com.example.admin.githubchallenge.di.activity.ActivityModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainViewModel mainViewModel;

    @Inject
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppController) getApplication())
                .getApplicationComponent()
                .newActivityComponent(new ActivityModule(this))
                .inject(this);
        binding.etSearch.setOnKeyListener((view, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
                mainViewModel.getRepositories(binding.etSearch.getText().toString());
                return true;
            }
            return false;
        });
        mainViewModel.getRepositoriesLiveData().observe(this, repositoriesAdapter -> {
            binding.rvRepos.setAdapter(repositoriesAdapter);
            binding.rvRepos.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            binding.rvRepos.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
        });

    }
}
