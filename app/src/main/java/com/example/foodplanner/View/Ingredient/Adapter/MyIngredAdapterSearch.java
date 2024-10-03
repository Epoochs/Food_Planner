package com.example.foodplanner.View.Ingredient.Adapter;

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
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.R;
import com.example.foodplanner.View.Ingredient.DetailedIngredActivity;

import java.util.ArrayList;
import java.util.List;

public class MyIngredAdapterSearch extends RecyclerView.Adapter<MyIngredAdapterSearch.ViewHolder> {
    Context context;
    ArrayList<Meals> meals;

    public MyIngredAdapterSearch(Context context, List<Meals> meals){
        this.context = context;
        if(meals != null){
            this.meals = (ArrayList<Meals>) meals;
        }else{
            this.meals = new ArrayList<Meals>();
        }
    }

    public void setList(List<Meals> mealsList){
        if(mealsList != null) {
            this.meals.clear();
            this.meals.addAll(mealsList);
            notifyDataSetChanged();
        }
    }

    public void setClear(){
        this.meals.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyIngredAdapterSearch.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewholder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = inflater.inflate(R.layout.ingred_search_row, parent, false);

        viewholder = new ViewHolder(convertView);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyIngredAdapterSearch.ViewHolder holder, int position) {

        String ingredents = meals.get(position).getStrIngredient();
        String imgURL = "https://www.themealdb.com/images/ingredients/";

        holder.tvIngredName.setText(meals.get(position).getStrIngredient());
        Glide.with(this.context)
                .load(imgURL + ingredents + ".png")
                .apply(new RequestOptions().override(200,200))
                .placeholder(R.drawable.baseline_downloading_24)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.imageView);

        holder.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,ingredents,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailedIngredActivity.class);
                intent.putExtra("IngredName", ingredents);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvIngredName;
        View convertView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            convertView = itemView;
            imageView = convertView.findViewById(R.id.imgIngredMeal2);
            tvIngredName = convertView.findViewById(R.id.tvIngredMealName2);
        }
    }
}
