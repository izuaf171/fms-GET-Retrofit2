package com.example.toshiba.fmsgetretrofit22;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.toshiba.fmsgetretrofit22.model.Result;
import com.example.toshiba.fmsgetretrofit22.model.User;
import com.example.toshiba.fmsgetretrofit22.model.Value;
import com.example.toshiba.fmsgetretrofit22.retrofitHelper.BaseAPIService;
import com.example.toshiba.fmsgetretrofit22.retrofitHelper.utilsAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter viewAdapter;
    private RecyclerView recyclerView;
    private HelperRetrofit helperRetrofit;
    private List<Result> userList = new ArrayList<>();
    private ProgressDialog progressDialog;

    private BaseAPIService myApiServices;
    Context context;

    public static final String URL = "http://untukcobabackend.000webhostapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        helperRetrofit = new HelperRetrofit();
        progressDialog = new ProgressDialog(this);
        viewAdapter = new CustomAdapter(this, userList);
        myApiServices = utilsAPI.getAPIService();
        progressDialog.setTitle("Menunggu Server");
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(viewAdapter);
//        recyclerView.setAdapter(viewAdapter);
        loadDataMahasiswa();

    }

    private void loadDataMahasiswa() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        BaseAPIService api = retrofit.create(BaseAPIService.class);
        Call<Value> call = myApiServices.ambildataUser();
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                progressDialog.dismiss();
                if (value.equals("1")) {
                    userList = response.body().getResult();
//                    String message = response.body().getMessage();
//                    Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show();
                    viewAdapter = new CustomAdapter(MainActivity.this, userList);

                    recyclerView.setAdapter(viewAdapter);
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {

                progressDialog.dismiss();
                Toast.makeText(context, "Server Bermasalah", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDataMahasiswa();
    }
}
