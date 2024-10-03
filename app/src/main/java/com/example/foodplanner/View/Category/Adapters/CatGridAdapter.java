package com.example.foodplanner.View.Category.Adapters;

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
import com.example.foodplanner.Model.Categories;
import com.example.foodplanner.R;
import com.example.foodplanner.View.Category.FilteredCategoryActivity;

import java.util.ArrayList;
import java.util.List;

public class CatGridAdapter extends RecyclerView.Adapter<CatGridAdapter.ViewHolder> {

    ArrayList<Categories> categories;
    Context context;

    public CatGridAdapter(Context context, List<Categories> meals){

        if(meals != null){
            this.categories = (ArrayList<Categories>) meals;
        }else{
            this.categories = new ArrayList<>();
        }
        this.context = context;
    }

    public void setList(List<Categories> categoriesList){
        if(categoriesList != null) {
            this.categories.clear();
            this.categories.addAll(categoriesList);
            notifyDataSetChanged();
        }else{
            Toast.makeText(context,"Category List is not found", Toast.LENGTH_SHORT).show();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewholder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = inflater.inflate(R.layout.category_row, parent, false);

        viewholder = new ViewHolder(convertView);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(categories.get(position).getStrCategory());
        Glide.with(this.context)
                .load(categories.get(position).getStrCategoryThumb())
                .apply(new RequestOptions().override(200,200))
                .placeholder(R.drawable.baseline_downloading_24)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.imageView);

        holder.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,categories.get(position).getStrCategory(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, FilteredCategoryActivity.class);
                intent.putExtra("Categ", categories.get(position).getStrCategory());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
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
}
