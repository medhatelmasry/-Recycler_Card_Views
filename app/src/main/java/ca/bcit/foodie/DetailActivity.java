package ca.bcit.foodie;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        displayFoodDetails();
    }

    private void displayFoodDetails() {
        String foodName = (String) getIntent().getExtras().get("foodName");

        Food food = Food.getFoodByName(foodName);

        if (food != null) {
            TextView food_text = findViewById(R.id.food_text);
            food_text.setText(food.getName());

            TextView food_category = findViewById(R.id.food_category);
            food_category.setText(food.getCategory());

            ImageView food_image = findViewById(R.id.food_image);
            food_image.setImageDrawable(ContextCompat.getDrawable(this, food.getImageResourceId()));
            food_image.setContentDescription(food.getName());
        }
    }

}
