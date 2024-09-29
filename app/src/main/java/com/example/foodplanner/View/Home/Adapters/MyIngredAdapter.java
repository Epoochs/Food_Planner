package com.example.foodplanner.View.Home.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.R;

import java.util.ArrayList;
import java.util.List;

public class MyIngredAdapter extends RecyclerView.Adapter<MyIngredAdapter.ViewHolder> {

    Meals meals;
    ArrayList<String> ingredients;
    ArrayList<String> measurements;
    Context context;

     public MyIngredAdapter(Context context, Meals meals){
         this.context = context;
         setMeal(meals);
     }
    @NonNull
    @Override
    public MyIngredAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewholder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = inflater.inflate(R.layout.ingred_row, parent, false);

        viewholder = new ViewHolder(convertView);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyIngredAdapter.ViewHolder holder, int position) {

        String ingredient = ingredients.get(position);
        String measurement = measurements.get(position);
        String imageUrl = "https://www.themealdb.com/images/ingredients/" + ingredient + "-Small.png";

        Glide.with(this.context)
                .load(imageUrl)
                .apply(new RequestOptions().override(200,200))
                .placeholder(R.drawable.baseline_downloading_24)
                .error(R.drawable.ic_launcher_foreground)
                .transform(new CircleCrop())
                .into(holder.imageView);

        holder.tvIngredName.setText(ingredient);
        holder.tvMeasurements.setText(measurement);
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

         View convertView;
         ImageView imageView;
         TextView tvIngredName;
         TextView tvMeasurements;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            convertView = itemView;

            imageView = convertView.findViewById(R.id.imgIngred);
            tvIngredName = convertView.findViewById(R.id.tvIngredName);
            tvMeasurements = convertView.findViewById(R.id.tvMeasurements);
        }
    }

    public void setMeal(Meals meal){
        this.meals = meal;
        if (meals != null) {
            ingredients = (ArrayList<String>) meals.getIngredients();
            measurements = (ArrayList<String>) meals.getMeasurements();
        } else {
            ingredients = new ArrayList<>();
            measurements = new ArrayList<>();
        }
        notifyDataSetChanged();
    }
}
