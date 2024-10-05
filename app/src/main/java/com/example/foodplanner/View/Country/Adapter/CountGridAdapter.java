package com.example.foodplanner.View.Country.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodplanner.Model.CountryCode;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.R;
import com.example.foodplanner.View.Country.DetailedCountActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CountGridAdapter extends RecyclerView.Adapter<CountGridAdapter.ViewHolder> {

    ArrayList<Meals> mealsArrayList;
    Map<String, Integer> flags;
    Context context;

    public CountGridAdapter(Context context, List<Meals> mealsList){
        this.context = context;

        if(mealsList != null){
            mealsArrayList = (ArrayList<Meals>) mealsList;
        }else{
            mealsArrayList = new ArrayList<Meals>();
        }
    }

    @NonNull
    @Override
    public CountGridAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewholder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = inflater.inflate(R.layout.country_row, parent, false);

        viewholder = new ViewHolder(convertView);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull CountGridAdapter.ViewHolder holder, int position) {

                String area = mealsArrayList.get(position).getStrArea();

                holder.textView.setText(area);
        Glide.with(this.context)
                .load(flags.get(area))
                .apply(new RequestOptions().override(200,200))
                .placeholder(R.drawable.baseline_downloading_24)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.imageView);

                holder.convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, mealsArrayList.get(position).getStrArea(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, DetailedCountActivity.class);
                        intent.putExtra("CountName", mealsArrayList.get(position).getStrArea());
                        context.startActivity(intent);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return mealsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        View convertView;

        public ViewHolder(View convertView){
            super(convertView);
            this.convertView = convertView;

            imageView = convertView.findViewById(R.id.imgIngredMeal2);
            textView = convertView.findViewById(R.id.tvIngredMealName2);
        }
    }

    public void setMealsList(List<Meals> mealsList){
        if(mealsList != null) {
            mealsArrayList.clear();
            mealsArrayList.addAll(mealsList);
            notifyDataSetChanged();
        }
    }

    public void setFlags(Map<String, Integer> flags){
        this.flags = flags;
    }
}
