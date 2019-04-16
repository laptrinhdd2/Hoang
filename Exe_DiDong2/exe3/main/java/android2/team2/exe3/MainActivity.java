package android2.team2.exe3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Food> arrayFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen1_layout);

        ListView listFood = (ListView) findViewById(R.id.lsvFood);
        arrayFood = new ArrayList<Food>();
        arrayFood.add(new Food("thit nuong", 300000, R.drawable.th1));
        arrayFood.add(new Food("trung chien", 40000, R.drawable.th2));
        arrayFood.add(new Food("thit rang", 35000, R.drawable.th3));
        arrayFood.add(new Food("thit xao", 300000, R.drawable.th1));
        arrayFood.add(new Food("trung xao", 40000, R.drawable.th2));
        arrayFood.add(new Food("cha rang", 35000, R.drawable.th3));
        arrayFood.add(new Food("thit nuong", 300000, R.drawable.th1));
        arrayFood.add(new Food("trung chien", 40000, R.drawable.th2));
        arrayFood.add(new Food("thit rang", 35000, R.drawable.th3));



        FoodAdapter foodAdapter = new FoodAdapter(MainActivity.this, R.layout.item_food_layout, arrayFood);
        listFood.setAdapter(foodAdapter);

        final Button btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(MainActivity.this, Screen2Activity.class));
               overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
            }
        });
    }
}
