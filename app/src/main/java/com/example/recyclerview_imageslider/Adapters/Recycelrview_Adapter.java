package com.example.recyclerview_imageslider.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_imageslider.Model.Slider;
import com.example.recyclerview_imageslider.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class Recycelrview_Adapter extends RecyclerView.Adapter<Recycelrview_Adapter.Viewholder> {

    private ArrayList<Slider> bestSellers;
    private Context context;

    public Recycelrview_Adapter(ArrayList<Slider> bestSellers, Context context) {
        this.bestSellers = bestSellers;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recyclerview,parent,false);

        if(v==null){
            Log.d("TAG", "onCreateViewHolder: not null");
        }

        Recycelrview_Adapter.Viewholder bestSellersViewHolder = new  Recycelrview_Adapter.Viewholder(v);

        return bestSellersViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Slider bestSeller = bestSellers.get(position);

        holder.name.setText(bestSeller.getName());
        ImageSliderAdapter adapter = new ImageSliderAdapter(context,bestSellers);
        holder.sliderView.setSliderAdapter(adapter);
        holder.sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        holder.sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        holder.sliderView.startAutoCycle();

    }

    @Override
    public int getItemCount() {
        return bestSellers.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        SliderView sliderView;
        TextView name;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            sliderView = itemView.findViewById(R.id.imageSlider);
            name = itemView.findViewById(R.id.name);
        }
    }
}
