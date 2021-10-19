package com.example.recyclerview_imageslider.Retorfit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    public static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson));

    private static Retrofit retrofit = retrofitBuilder.build();

    private static JSoJsonPlaceHolderApi holderApi = retrofit.create(JSoJsonPlaceHolderApi.class);

    public static JSoJsonPlaceHolderApi getHolderApi() {
        return holderApi;
    }
}
