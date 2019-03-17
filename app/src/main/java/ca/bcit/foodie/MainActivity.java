package ca.bcit.foodie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView foodRecycler = (RecyclerView) findViewById(R.id.food_recycler);

        Food[] foods = Food.getAllFoodItems();

        String[] foodNames = new String[foods.length];
        int[] foodImages = new int[foods.length];
        for (int i=0; i<foodNames.length; i++) {
            foodNames[i] = foods[i].getName();
            foodImages[i] = foods[i].getImageResourceId();
        }

        CaptionedImageAdapter adapter = new CaptionedImageAdapter(foodNames, foodImages);
        foodRecycler.setAdapter(adapter);

        //GridLayoutManager lm = new GridLayoutManager(MainActivity.this, 3);
        //LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);
        StaggeredGridLayoutManager lm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        foodRecycler.setLayoutManager(lm);


        adapter.setListener(new CaptionedImageAdapter.Listener() {
            public void onClick(String foodName) {
                Intent i = new Intent(MainActivity.this, DetailActivity.class);
                i.putExtra("foodName", foodName);
                startActivity(i);
            }
        });

    }
}
