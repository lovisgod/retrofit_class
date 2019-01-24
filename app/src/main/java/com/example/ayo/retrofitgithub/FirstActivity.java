package com.example.ayo.retrofitgithub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    public EditText userId;
    public String userString;
    public Button button;
    public Button post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        userId = findViewById(R.id.input);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResult();
            }
        });
        post = findViewById(R.id.post);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPostActivity();
            }
        });

    }

    private void openPostActivity() {
        Intent open = new Intent(FirstActivity.this, PostActivity.class);
        startActivity(open);
    }

    private void openResult() {
        userString = userId.getText().toString();

        Toast.makeText(this, "" + userString, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(FirstActivity.this, MainActivity.class);
        intent.putExtra("input", userString);
        startActivity(intent);

    }
}