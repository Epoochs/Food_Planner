package com.example.foodplanner.View.Favourate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.R;

import java.util.ArrayList;
import java.util.List;

public class FavGridAdapter extends BaseAdapter{

    ArrayList<Meals> meals;
    Context context;
    boolean btnFavState = false;
    OnFavClickListener onFavClickListener;

    public FavGridAdapter(Context context, List list, OnFavClickListener onFavClickListener){
        if(list != null){
            meals = (ArrayList<Meals>) list;
        }else{
            meals = new ArrayList<>();
        }
        this.context = context;
        this.onFavClickListener = onFavClickListener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.fav_row, parent, false);

            viewholder = new ViewHolder(convertView);
            convertView.setTag(viewholder);
        } else {
            viewholder = (ViewHolder) convertView.getTag();
        }
        viewholder.textView.setText(meals.get(position).getStrMeal());
        Glide.with(this.context)
                .load(meals.get(position).getStrMealThumb())
                .apply(new RequestOptions().override(200,200))
                .placeholder(R.drawable.baseline_downloading_24)
                .error(R.drawable.ic_launcher_foreground)
                .into(viewholder.imageView);

        viewholder.imageButton.setOnClickListener(v -> {
            btnFavState = !btnFavState;
            viewholder.imageButton.setSelected(btnFavState);

            /* Request to Activity for Removing the meal from the database */
            onFavClickListener.onUnFavClick(meals.get(position));
        });

        return convertView;
    }

    public class ViewHolder {
        ImageView imageView;
        TextView textView;
        ImageButton imageButton;
        View convertView;

        public ViewHolder(View convertView){
            this.convertView = convertView;

            imageView = convertView.findViewById(R.id.imgFavMeal);
            textView = convertView.findViewById(R.id.tvFavMealName);
            imageButton = convertView.findViewById(R.id.imgBtnUnFav);
            imageButton.setSelected(false);
        }

        public ImageButton getImageButton(){
            return imageButton;
        }
    }

    @Override
    public int getCount() {
        return meals.size();
    }

    @Override
    public Object getItem(int i) {
        return meals.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void setList(List<Meals> mealsList){
        meals.clear();
        meals.addAll(mealsList);
        notifyDataSetChanged();
    }
}
