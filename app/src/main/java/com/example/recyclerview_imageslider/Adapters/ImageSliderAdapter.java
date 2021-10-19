package com.example.recyclerview_imageslider.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.recyclerview_imageslider.Model.Slider;
import com.example.recyclerview_imageslider.R;
import com.example.recyclerview_imageslider.Retorfit.Constant;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class ImageSliderAdapter extends SliderViewAdapter<ImageSliderAdapter.SliderAdapterVH> {

    private Context context;
    private ArrayList<Slider> sliderArrayList;

    public ImageSliderAdapter(Context context, ArrayList<Slider> sliderArrayList) {
        this.context = context;
        this.sliderArrayList = sliderArrayList;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);

    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {

        Slider imagelistt = sliderArrayList.get(position);
        //viewHolder.imageViewBackground.setImageResource("http://buynear.amtotoys.com/buynear/storage/app/public/admins/"+imagelistt.getImg()));

        Glide.with(context)
                .load(Constant.IMAGE_BASE_URL + imagelistt.getImg())
                .fitCenter()
                .into(viewHolder.imageViewBackground);

    }

    @Override
    public int getCount() {
        return sliderArrayList.size();
    }

    public class SliderAdapterVH extends ViewHolder {
        View itemView;
        ImageView imageViewBackground;
        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.imageview);
            this.itemView = itemView;
        }
    }
}
