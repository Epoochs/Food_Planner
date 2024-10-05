package com.example.foodplanner.View.Home;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodplanner.Model.Day;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Presenter.Details.DetailedView;
import com.example.foodplanner.Presenter.Details.DetailsPresenter;
import com.example.foodplanner.R;
import com.example.foodplanner.View.Home.Adapters.MyIngredAdapter;

import java.util.List;

public class DetailedHomeActivity extends AppCompatActivity implements DetailedView {

    ImageView imageView;
    ImageButton imageButton;
    Button btnCalenderized;

    TextView tvMealName;
    TextView tvMealCount;
    TextView tvMealSteps;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    MyIngredAdapter myIngredAdapter;

    WebView webView;

    DetailsPresenter detailsPresenter;
    Meals meal;
    Day dayMeal;

    boolean btnFavState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.detailed_meal_activity);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Food Details");
        }

        Intent intent = getIntent();
        String mealName = intent.getStringExtra("MealName");

        init();

        detailsPresenter = DetailsPresenter.getInstance(this,this);
        detailsPresenter.getMealByName(mealName);

        imageButton.setOnClickListener(v -> {

            btnFavState = !btnFavState;
            imageButton.setSelected(btnFavState);

            if(btnFavState)
                detailsPresenter.insertMeal(meal);
            else
                detailsPresenter.removeMeal(meal);
        });

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        myIngredAdapter = new MyIngredAdapter(this,meal);
        recyclerView.setAdapter(myIngredAdapter);

        btnCalenderized.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();

            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // on below line we are creating a variable for date picker dialog.
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    // on below line we are passing context.
                    DetailedHomeActivity.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                            /* Test */
                            System.out.println(selectedDate);
                            dayMeal = new Day();
                            dayMeal.setDay(selectedDate);
                            detailsPresenter.insertDay(dayMeal);
                            System.out.println("On Date set: " + dayMeal.getDay());
                            //meal.setIsFavourate(false);
                            detailsPresenter.insertMeal(meal);
                            detailsPresenter.addMealDay(meal,dayMeal);
                        }
                    },
                    year, month, day);
            datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
            datePickerDialog.show();
        });

    }

    @SuppressLint("SetJavaScriptEnabled")
    private void init(){
        imageView = findViewById(R.id.imageView3);
        imageButton = findViewById(R.id.imgBtnCalMeal);
        btnCalenderized = findViewById(R.id.btnAddtoCalender);

        tvMealCount = findViewById(R.id.tvMealCount);
        tvMealName = findViewById(R.id.tvMealName2);
        tvMealSteps = findViewById(R.id.tvSteps);

        recyclerView =findViewById(R.id.recvIngred);

        webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
    }

    @Override
    public void showData(Meals meals) {
        meal = meals;
        /* Image View */
        if (!isFinishing() && !isDestroyed()) {
            Glide.with(this)
                    .load(meals.getStrMealThumb())
                    .apply(new RequestOptions().override(200, 200))
                    .placeholder(R.drawable.baseline_downloading_24)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(imageView);
        }

        tvMealName.setText(meals.getStrMeal());
        tvMealCount.setText(meals.getStrArea());
        myIngredAdapter.setMeal(meal);

        String videoUrl = meals.getStrYoutube();
        String[] videoEmbed = videoUrl.split("v=");
        System.out.println(videoEmbed[1]);
        String embedUrl = "https://www.youtube.com/embed/" + videoEmbed[1];

        String html = "<html><body>" +
                "<iframe width=\"100%\" height=\"100%\" " +
                "src=\"" + embedUrl + "\" " +
                "frameborder=\"0\" allowfullscreen></iframe>" +
                "</body></html>";

        webView.loadData(html, "text/html", "UTF-8");

        tvMealSteps.setText(meals.getStrInstructions());
    }

    @Override
    public void showData(List<Meals> mealsList) {

    }
}