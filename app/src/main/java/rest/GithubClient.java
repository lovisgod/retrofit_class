package rest;


import java.util.List;

import model.GithubRepo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubClient {
        @GET("/users/{user}/repos")
            //There is a defined class GitHubRepo. This class comprises required
            // class properties to map the response data.
            //the repo user method returns data type List<GithubRepo> the githubrepo is a mapper class that is passed in
            // object data / parameter into List which is a object data type
        Call<List<GithubRepo>> repoUser(
                @Path("user") String user
        );
    }