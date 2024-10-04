package com.example.foodplanner.View.Category.Adapters;

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

public class MyFilteredCat extends RecyclerView.Adapter<MyFilteredCat.ViewHolder> {
    List<Meals> mealsList;
    Context context;
    boolean btnFavState;
    OnFavMealClickListener onFavCountClickListener;

    public MyFilteredCat(Context context, ArrayList<Meals> mealsList, OnFavMealClickListener onFavCountClickListener){
        this.context = context;
        if(mealsList != null){
            this.mealsList = mealsList;
        }else{
            this.mealsList = new ArrayList<>();
        }
        this.onFavCountClickListener = onFavCountClickListener;
    }

    @NonNull
    @Override
    public MyFilteredCat.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewholder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = inflater.inflate(R.layout.filtered_cat_row, parent, false);

        viewholder = new ViewHolder(convertView);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyFilteredCat.ViewHolder holder, int position) {
        holder.tvMealName.setText(mealsList.get(position).getStrMeal());
        Glide.with(this.context)
                .load(mealsList.get(position).getStrMealThumb())
                .apply(new RequestOptions().override(200,200))
                .placeholder(R.drawable.baseline_downloading_24)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.imageView);

        holder.imageButton.setOnClickListener(v -> {

            btnFavState = !btnFavState;
            holder.imageButton.setSelected(btnFavState);

            if(btnFavState)
                onFavCountClickListener.onFavClick(mealsList.get(position),btnFavState);
            else
                onFavCountClickListener.onUnFavClick(mealsList.get(position));
        });

        holder.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,mealsList.get(position).getStrMeal(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailedHomeActivity.class);
                intent.putExtra("MealName", mealsList.get(position).getStrMeal());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mealsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvMealName;
        ImageButton imageButton;
        View convertView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            convertView = itemView;
            imageButton = convertView.findViewById(R.id.imgBtnCalMeal);
            tvMealName = convertView.findViewById(R.id.tvDetailedPlannerName);
            imageView = convertView.findViewById(R.id.imgDetailedPlannerMeal);
        }
    }

    public void setMealsList(List<Meals> mealsList){
        this.mealsList.clear();
        this.mealsList.addAll(mealsList);
        notifyDataSetChanged();
    }
}
