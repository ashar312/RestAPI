package com.example.restapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondAPI extends AppCompatActivity {

    TextView textView;
    EmployeeAPI employeeAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_api);

        textView = findViewById(R.id.JSONbody);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        employeeAPI = retrofit.create(EmployeeAPI.class);
        getEmployees();
    }

    private void getEmployees(){
        Call<List<EmployeeData>> call = employeeAPI.GetEmployees();
        call.enqueue(new Callback<List<EmployeeData>>() {
            @Override
            public void onResponse(Call<List<EmployeeData>> call, Response<List<EmployeeData>> response) {
                if(response.isSuccessful()){
                    List<EmployeeData> employeeDataList = response.body();
                    for(int i = 0; i < employeeDataList.size(); i++){
                        String content = "";
                        content = "id: "+employeeDataList.get(i).getId()+"\n"
                                +"name: "+employeeDataList.get(i).getEmployee_name()+"\n"
                                +"age: "+employeeDataList.get(i).getEmployee_age()+"\n"
                                +"salary: "+employeeDataList.get(i).getEmployee_salary()+"\n"
                                +"profile: "+employeeDataList.get(i).getProfile_image()+"\n"+"\n";
                        textView.append(content);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<EmployeeData>> call, Throwable t) {
                Toast.makeText(SecondAPI.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
