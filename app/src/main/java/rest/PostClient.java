package rest;

import java.util.List;

import model.Post;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PostClient {
    @POST("/posts")
    @FormUrlEncoded
    Call<Post> sendPost(@Field("title") String title,
                        @Field("body") String body,
                        @Field("USerId")  int UserId);
}
