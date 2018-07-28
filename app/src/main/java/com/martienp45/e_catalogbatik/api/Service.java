package com.martienp45.e_catalogbatik.api;

import com.google.gson.JsonArray;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;


public interface Service {

    @FormUrlEncoded
    @POST("api/login_android")
    Call<ResponseBody> loginRequest(@Field("username") String username,
                                    @Field("password") String password);
    //Api Login Android

    @GET("api/peminjaman_ruang/{keterangan}")
    Call<JsonArray> getPeminjamanRuang(
            @Path("keterangan") String keterangan
    );
    //Keterangan adalah keterangan hari / minggu / bulan ini

    @GET("api/{kategori}")
    Call<JsonArray> getKoleksi(@Path("kategori") String kategori);
    //Api untuk mengambil ruang yang dapat di pinjam



}
