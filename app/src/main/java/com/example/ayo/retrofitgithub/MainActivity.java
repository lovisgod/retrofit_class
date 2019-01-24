package com.example.ayo.retrofitgithub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import adapter.GithubAdapter;
import model.GithubRepo;
import rest.GithubClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String API_BASE_URL = "https://api.github.com/";
    Retrofit retrofit;
    RecyclerView recyclerView;
    GithubAdapter githubAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.listrepo);
        githubAdapter = new GithubAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        makeRequest();


    }

    public void makeRequest() {

        Intent i = getIntent();
        String input = i.getExtras().getString("input");

        retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubClient client = retrofit.create(GithubClient.class);

        //this is where fetch a list repositories
        Call<List<GithubRepo>> call = client.repoUser(input);

        //here we execute the call asynchronously and get a negative or positeve callback
        //the enqueue method takes in new callback object as parameter.

        call.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {

                Toast.makeText(MainActivity.this, "OK this is working !!!!!!" , Toast.LENGTH_LONG).
                        show();
                if(response.isSuccessful()){
                    List<GithubRepo> list = response.body();
                    githubAdapter = new GithubAdapter(getApplicationContext());
                    recyclerView.setAdapter(githubAdapter);
                    githubAdapter.setREsult(list);



//                    Log.d(TAG, "The response is : " + response.body().get(1).getId());
                }

            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "We ran Into some errors " , Toast.LENGTH_LONG).show();
                Log.d("TAG","Response = "+t.toString());

            }
        });
    }
}