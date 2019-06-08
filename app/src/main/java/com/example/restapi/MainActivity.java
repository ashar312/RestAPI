package com.example.restapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    JSONApi jsonApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.JSONbody);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonApi = retrofit.create(JSONApi.class);

        getPost();


    }

    private void getPost(){

        Call<List<Post>> call = jsonApi.getPosts();
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
}
