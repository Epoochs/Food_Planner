package com.example.foodplanner.View.Home.Adapters;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.app.Activity;
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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodplanner.Model.Categories;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.R;
import com.example.foodplanner.View.Category.CatGridAdapter;
import com.example.foodplanner.View.Home.DetailedHomeActivity;

import java.util.ArrayList;
import java.util.List;

public class MyInspirationAdapter extends RecyclerView.Adapter<MyInspirationAdapter.ViewHolder> {

    ArrayList<Meals> meals;
    Context context;
    boolean btnFavState;
    OnFavClickListener onFavClickListener;

    public MyInspirationAdapter(Context context, List<Meals> meals, OnFavClickListener onFavClickListener, boolean btnFavState){
        if(meals != null){
            this.meals = (ArrayList<Meals>) meals;
        }else{
            this.meals = new ArrayList<>();
        }
        this.context = context;
        this.onFavClickListener = onFavClickListener;
        this.btnFavState = btnFavState;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewholder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = inflater.inflate(R.layout.meal_inspiration_row, parent, false);

        viewholder = new ViewHolder(convertView);
        return viewholder;
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull MyInspirationAdapter.ViewHolder holder, int position) {
        holder.textView.setText(meals.get(position).getStrMeal());
        Glide.with(this.context)
                .load(meals.get(position).getStrMealThumb())
                .apply(new RequestOptions().override(200,200))
                .placeholder(R.drawable.baseline_downloading_24)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.imageView);

        /* Handling the clicks on ImageButton */
        holder.imageButton.setOnClickListener(v -> {

            btnFavState = !btnFavState;
            holder.imageButton.setSelected(btnFavState);

            if(btnFavState)
                onFavClickListener.onFavClick(meals.get(position), btnFavState);
            else
                onFavClickListener.onUnFavClick(meals.get(position));
        });

        /* Item listener */
        holder.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,meals.get(position).getStrMeal(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailedHomeActivity.class);
                intent.putExtra("MealName",meals.get(position).getStrMeal());

                if (context instanceof Activity) {
                    ((Activity) context).startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        ImageButton imageButton;
        View convertView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.convertView = itemView;
            imageView = itemView.findViewById(R.id.imageView2);
            textView = itemView.findViewById(R.id.tvMealName1);
            imageButton = itemView.findViewById(R.id.imgBtnFav);
            imageButton.setSelected(btnFavState);
        }
    }

    public void setList(List<Meals> mealsList){
        this.meals.clear();
        this.meals.addAll(mealsList);
        notifyDataSetChanged();
    }
}
