package com.example.foodplanner.View.Favourate.Adapter;

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
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.R;
import com.example.foodplanner.View.Home.DetailedHomeActivity;
import com.example.foodplanner.View.Listener.OnUnFavClickListener;
import com.example.foodplanner.View.Favourate.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

public class FavGridAdapter extends RecyclerView.Adapter<FavGridAdapter.ViewHolder> {

    ArrayList<Meals> meals;
    Context context;
    boolean btnFavState = false;
    OnUnFavClickListener onUnFavClickListener;
    PreferenceManager preferenceManager;

    public FavGridAdapter(Context context, List list, OnUnFavClickListener onUnFavClickListener){
        if(list != null){
            meals = (ArrayList<Meals>) list;
        }else{
            meals = new ArrayList<>();
        }
        this.context = context;
        this.onUnFavClickListener = onUnFavClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewholder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = inflater.inflate(R.layout.fav_row, parent, false);

        viewholder = new ViewHolder(convertView);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
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


            /* Request to Activity for Removing the meal from the database */
            onUnFavClickListener.onUnFavClick(meals.get(position));
        });

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

    public void setList(List<Meals> mealsList){
        this.meals.clear();
        this.meals.addAll(mealsList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        ImageButton imageButton;
        View convertView;

        public ViewHolder(View convertView){
            super(convertView);
            this.convertView = convertView;

            imageView = convertView.findViewById(R.id.imgDetailedPlannerMeal);
            textView = convertView.findViewById(R.id.tvDetailedPlannerName);
            imageButton = convertView.findViewById(R.id.imgBtnCalMeal);
            imageButton.setSelected(false);
        }

        public ImageButton getImageButton(){
            return imageButton;
        }
    }
}
