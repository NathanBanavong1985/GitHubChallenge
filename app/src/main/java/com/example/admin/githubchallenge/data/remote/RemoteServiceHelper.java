package com.example.admin.githubchallenge.data.remote;

import com.example.admin.githubchallenge.common.Constants;
import com.example.admin.githubchallenge.models.GithubResponse;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteServiceHelper {

    @Inject
    public RemoteServiceHelper() {

    }

    public Single<GithubResponse> getRepositories(String search) {
        Retrofit retrofit = getRetrofit();
        RemoteService service = retrofit.create(RemoteService.class);
        Map<String, String> queries = new HashMap<>();
        queries.put("q", search);
        queries.put("sort", Constants.SORT_BY);
        queries.put("order", Constants.SORT_ORDER);
        return service.getRepositories(queries);
    }

    private Retrofit getRetrofit() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
