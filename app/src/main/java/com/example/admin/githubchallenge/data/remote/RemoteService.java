package com.example.admin.githubchallenge.data.remote;

import com.example.admin.githubchallenge.models.GithubResponse;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface RemoteService {

    @GET("search/repositories")
    Single<GithubResponse> getRepositories(@QueryMap Map<String, String> query);
}
