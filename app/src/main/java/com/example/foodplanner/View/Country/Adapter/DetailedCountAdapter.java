package com.example.foodplanner.View.Country.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.R;
import com.example.foodplanner.View.Listener.OnFavMealClickListener;
import com.example.foodplanner.View.Home.DetailedHomeActivity;

import java.util.ArrayList;
import java.util.List;

public class DetailedCountAdapter extends RecyclerView.Adapter<DetailedCountAdapter.ViewHolder> {

    ArrayList<Meals> mealsArrayList;
    Context context;
    boolean btnFavState;
    OnFavMealClickListener onFavCountClickListener;

    public DetailedCountAdapter(Context context, List<Meals> mealsList, OnFavMealClickListener onFavCountClickListener){
        this.context = context;

        if(mealsList != null){
            mealsArrayList = (ArrayList<Meals>) mealsList;
        }else{
            mealsArrayList = new ArrayList<Meals>();
        }
        this.onFavCountClickListener = onFavCountClickListener;
    }

    @NonNull
    @Override
    public DetailedCountAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewholder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = inflater.inflate(R.layout.detailed_count_row, parent, false);

        viewholder = new ViewHolder(convertView);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailedCountAdapter.ViewHolder holder, int position) {

        holder.textView.setText(mealsArrayList.get(position).getStrMeal());


       Glide.with(this.context)
                .load(mealsArrayList.get(position).getStrMealThumb())
                .apply(new RequestOptions().override(200,200))
                .placeholder(R.drawable.baseline_downloading_24)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.imageView);

       holder.imageButton.setOnClickListener(v -> {

           btnFavState = !btnFavState;
           holder.imageButton.setSelected(btnFavState);

           if(btnFavState)
               onFavCountClickListener.onFavClick(mealsArrayList.get(position),btnFavState);
           else
               onFavCountClickListener.onUnFavClick(mealsArrayList.get(position));
       });

        holder.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,mealsArrayList.get(position).getStrMeal(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailedHomeActivity.class);
                intent.putExtra("MealName",mealsArrayList.get(position).getStrMeal());
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
        ImageButton imageButton;
        View convertView;

        public ViewHolder(View convertView){
            super(convertView);
            this.convertView = convertView;

            imageButton = convertView.findViewById(R.id.imgBtnCalMeal);
            imageView = convertView.findViewById(R.id.imgDetailedPlannerMeal);
            textView = convertView.findViewById(R.id.tvDetailedPlannerName);
        }
    }

    public void setMealsList(List<Meals> mealsList){
        mealsArrayList.clear();
        mealsArrayList.addAll(mealsList);
        notifyDataSetChanged();
    }
}
