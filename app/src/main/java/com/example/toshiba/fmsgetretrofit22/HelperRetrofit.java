package com.example.toshiba.fmsgetretrofit22;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.example.toshiba.fmsgetretrofit22.model.User;
import com.example.toshiba.fmsgetretrofit22.model.Value;
import com.example.toshiba.fmsgetretrofit22.retrofitHelper.BaseAPIService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TOSHIBA on 12/02/2018.
 */

public class HelperRetrofit {

    public static final String URL = "http://untukcobabackend.000webhostapp.com/";
    private ProgressDialog progressDialog;
    private List<User> results = new ArrayList<>();
    private CustomAdapter viewAdapter;
    private Context context;
    private RecyclerView recyclerView;

//    public void loadDataUser(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        BaseAPIService api = retrofit.create(BaseAPIService.class);
//        Call<Value> call = api.ambildataUser();
//        call.enqueue(new Callback<Value>() {
//            @Override
//            public void onResponse(Call<Value> call, Response<Value> response) {
//                String value = response.body().getValue();
//                progressDialog.dismiss();
//                if (value.equals("1")) {
//
//                    results = response.body().getResult();
//                    viewAdapter = new CustomAdapter(context,results);
//                    recyclerView.setAdapter(viewAdapter);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Value> call, Throwable t) {
//                progressDialog.dismiss();
//                Toast.makeText(context, "Server Bermasalah", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
