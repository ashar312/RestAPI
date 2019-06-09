package com.example.restapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restapi.API_interfaces.JSONApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    JSONApi jsonApi;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.JSONbody);
        next = findViewById(R.id.Next);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonApi = retrofit.create(JSONApi.class);
        CreatePost();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondAPI.class));
            }
        });
    }

    private void getPost(){

        Call<List<Post>> call = jsonApi.getPosts(1,"id","desc");
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Code "+ response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    List<Post> postList = response.body();
                    for(int i = 0; i < postList.size(); i++){
                        String content = "";
                        content = "userid: "+postList.get(i).getUserid()+"\n"
                                +"id: "+ postList.get(i).getId()+"\n"
                                +"text: "+ postList.get(i).getTitle()+"\n"
                                +"body: "+ postList.get(i).getText()+"\n"+"\n";
                        textView.append(content);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getComments(){
        Call<List<Comments>> call = jsonApi.getComments(3);
        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Code "+ response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    List<Comments> commentList = response.body();
                    for(int i = 0; i < commentList.size(); i++){
                        String content = "";
                        content = "postid: "+commentList.get(i).getPostId()+"\n"
                                +"id: "+ commentList.get(i).getId()+"\n"
                                +"name: "+ commentList.get(i).getName()+"\n"
                                +"Email: "+ commentList.get(i).getEmail()+"\n"
                                +"body: "+ commentList.get(i).getText()+"\n"+"\n";
                        textView.append(content);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void CreatePost(){
        Post post = new Post(23,"Ashar Title", "Ashar text");
        Call<Post> postCall = jsonApi.createPost(post);

        postCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Code " + response.code() + response.errorBody(), Toast.LENGTH_SHORT).show();
                    return;
                }

                Post post = response.body();
                String content = "";
                content = "userid: " + post.getUserid() + "\n"
                        + "id: " + post.getId() + "\n"
                        + "Code: " + response.code() + "\n"
                        + "text: " + post.getTitle() + "\n"
                        + "body: " + post.getText() + "\n" + "\n";
                textView.setText(content);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void PatchPost(){
        Post post = new Post(20,null,"My Text");

        Call<Post> postCall = jsonApi.putPost(5,post);
        postCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, response.code()+"", Toast.LENGTH_SHORT).show();
                }
                else{
                    Post post = response.body();
                    String content = "";
                    content = "userid: " + post.getUserid() + "\n"
                            + "id: " + post.getId() + "\n"
                            + "Code: " + response.code() + "\n"
                            + "text: " + post.getTitle() + "\n"
                            + "body: " + post.getText() + "\n" + "\n";
                    textView.setText(content);
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void UpdataPost(){
        Post post = new Post(20,null,"My Text");

        Call<Post> postCall = jsonApi.putPost(5,post);
        postCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, response.code()+"", Toast.LENGTH_SHORT).show();
                }
                else{
                    Post post = response.body();
                    String content = "";
                    content = "userid: " + post.getUserid() + "\n"
                            + "id: " + post.getId() + "\n"
                            + "Code: " + response.code() + "\n"
                            + "text: " + post.getTitle() + "\n"
                            + "body: " + post.getText() + "\n" + "\n";
                    textView.setText(content);
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void DeletePost(){
        Call<Void> voidCall = jsonApi.DeletePost(2);
        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, response.errorBody()+"", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
