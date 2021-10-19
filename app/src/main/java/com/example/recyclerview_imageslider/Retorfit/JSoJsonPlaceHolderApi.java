package com.example.recyclerview_imageslider.Retorfit;

import com.example.recyclerview_imageslider.Model.Slider;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JSoJsonPlaceHolderApi {

   @GET("getBestSellings")
    Call<ArrayList<Slider>> getBestSelling();


}
