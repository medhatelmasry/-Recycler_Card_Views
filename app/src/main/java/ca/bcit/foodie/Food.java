package ca.bcit.foodie;

import java.util.ArrayList;

public class Food {
    private String category;
    private String name;
    private int imageResourceId;

    public static final Food[] foods = {
            new Food("Seafood", "Salmon", R.drawable.salmon),
            new Food("Bakery", "Croissant", R.drawable.croissants),
            new Food("Seafood", "Shrimp", R.drawable.shrimp),
            new Food("Bakery", "Muffin", R.drawable.muffin),
            new Food("Produce", "Cucumber", R.drawable.cucumber),
            new Food("Seafood", "Crab", R.drawable.crab),
            new Food("Produce", "Carrot", R.drawable.carrots),
            new Food("Bakery", "Cookie", R.drawable.cookies),
            new Food("Produce", "Cabbage", R.drawable.cabbage)
    };

    public static Food[] getFoodByCategory(String category) {
        ArrayList<Food> foodList = new ArrayList<Food>();
        for (int i=0; i<foods.length; i++ ) {
            Food f = foods[i];
            if (category.toLowerCase().trim().equals(f.getCategory().toLowerCase())) {
                foodList.add(f);
            }
        }

        Food[] array = foodList.toArray(new Food[foodList.size()]);
        return  array;
    }

    public static Food[] getAllFoodItems() {
        return  foods;
    }

    public static Food getFoodByName(String name) {
        Food food = null;
        for (int i=0; i<foods.length; i++ ) {
            Food f = foods[i];
            if (name.toLowerCase().trim().equals(f.getName().toLowerCase())) {
                food = f;
                break;
            }
        }

        return  food;
    }

    public Food(String category, String name, int imageResourceId) {
        this.name = name;
        this.category = category;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}

