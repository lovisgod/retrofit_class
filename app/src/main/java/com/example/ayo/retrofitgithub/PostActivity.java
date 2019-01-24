package com.example.ayo.retrofitgithub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import model.Post;
import rest.PostClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostActivity extends AppCompatActivity {
    public static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private static final String TAG = "PostActivity";
    Retrofit retrofit;
    EditText userTitle;
    TextView userRespose;
    EditText userBody;
    String title;
    String body;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        userBody = findViewById(R.id.et_body);
        userTitle = findViewById(R.id.et_title);
        userRespose = findViewById(R.id.tv_response);
        submit= findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });

    }

    private void sendRequest() {
        getString();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostClient client = retrofit.create(PostClient.class);
        //here fetches the response from the post
        Call<Post>call = client.sendPost(title, body, (Integer) 1);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                showResponse(response.body().toString());
                Log.d(TAG, "post submitted to api : " + response.body().toString());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

                Log.d(TAG, "unable to submitted");

            }
        });
    }

    public void getString(){
        title = userTitle.getText().toString();
        body = userBody.getText().toString();
        }

    public void showResponse(String theResponse){
        if(userRespose.getVisibility()== View.GONE){
            userRespose.setVisibility(View.VISIBLE);
        }
         userRespose.setText(theResponse);
    }
}
