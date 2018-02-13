package com.example.toshiba.fmsgetretrofit22.retrofitHelper;

/**
 * Created by XSIS-NB0034 on 1/10/2018.
 */

public class utilsAPI {



    public static final String BASE_URL_API = "https://untukcobabackend.000webhostapp.com/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseAPIService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseAPIService.class);

    }

}
