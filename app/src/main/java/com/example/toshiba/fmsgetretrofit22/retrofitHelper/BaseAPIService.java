package com.example.toshiba.fmsgetretrofit22.retrofitHelper;



import com.example.toshiba.fmsgetretrofit22.model.Value;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by XSIS-NB0034 on 1/10/2018.
 */

public interface BaseAPIService {

//@GET("search/{countryCode}")
//    retrofit2.Call<ResponseBody> cariKota(@Path("countryCode") String countryCode,
//                                          @Query("text") String text);

    @GET("viewHJUser.php")
    Call<Value> ambildataUser();


    /*// Fungsi ini untuk memanggil API http://10.0.2.2/mahasiswa/login.php
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> loginRequest(@Field("email") String email,
                                    @Field("password") String password);

    // Fungsi ini untuk memanggil API http://10.0.2.2/mahasiswa/register.php
    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> registerRequest(@Field("nama") String nama,
                                       @Field("email") String email,
                                       @Field("password") String password);*/

}
