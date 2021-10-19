package com.example.recyclerview_imageslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerview_imageslider.Adapters.Recycelrview_Adapter;
import com.example.recyclerview_imageslider.Model.Slider;
import com.example.recyclerview_imageslider.Retorfit.JSoJsonPlaceHolderApi;
import com.example.recyclerview_imageslider.Retorfit.ServiceGenerator;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    RecyclerView test_recycler;
    public ArrayList<Slider> bestsellers = new ArrayList<>();
    Recycelrview_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test_recycler = findViewById(R.id.test_recycler);

        getBestSellers();
    }

    private void getBestSellers () {
        JSoJsonPlaceHolderApi holderApi = ServiceGenerator.getHolderApi();
        Call<ArrayList<Slider>> call = holderApi.getBestSelling();

        call.enqueue(new Callback<ArrayList<Slider>>() {
            @Override
            public void onResponse(Call<ArrayList<Slider>> call, retrofit2.Response<ArrayList<Slider>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Server Error", Toast.LENGTH_SHORT).show();
                    Log.e("Its_not_successful", response.message());
                }

                ArrayList<Slider> sellersArrayList = response.body();
                if(sellersArrayList != null) {

                    for (int i = 0; i < sellersArrayList.size(); i++) {

                            bestsellers.add(sellersArrayList.get(i));
                            Log.e("BestSell_Images", "" + sellersArrayList.get(i).getImg());

                    }
                }
                else{
                    Log.e("ListNull","");
                }

                setupRecyclerView(MainActivity.this,bestsellers);
            }

            @Override
            public void onFailure(Call<ArrayList<Slider>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
                Log.e("Its_not_successful", t.getMessage());
            }
        });

    }

    private void setupRecyclerView(Context context, ArrayList<Slider>bestSellers) {


        if (bestSellers == null) {
            Log.e("CheckList", "");
        } else {

            test_recycler.setHasFixedSize(true);
            test_recycler.setVisibility(View.VISIBLE);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
            adapter = new Recycelrview_Adapter(bestSellers,this);

            test_recycler.setLayoutManager(mLayoutManager);
            test_recycler.setAdapter(adapter);


        }
    }
}