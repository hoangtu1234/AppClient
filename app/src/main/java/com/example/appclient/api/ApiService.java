package com.example.appclient.api;

import com.example.appclient.model.TheoDoiTrangThai;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiService {
    // http://localhost:8762/task/UNX41JZB5NU/ABDCsdlasdk123
    //192.168.1.25
    //192.168.1.56
    // 192.168.43.113
//    String baseUrl = "http://192.168.43.113:8762/";
    String baseUrl = "http://192.168.185.160:8762/";
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("task/{maDonHang}/{token}")
    Call<TheoDoiTrangThai> theoDoiTrangThaiCall(@Path("maDonHang") String maDonHang,
                                                @Path("token") String token);



}
