package com.example.hw5_articles_goods;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hw5_articles_goods.Adapters.GoodListViewAdapter;
import com.example.hw5_articles_goods.Models.GoodItem;
import com.example.hw5_articles_goods.Models.StyleTypeEnum;
import com.example.hw5_articles_goods.Services.GoodItemService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StyleTypeEnum styleTypeEnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        styleTypeEnum = StyleTypeEnum.DEFAULT;

        ListView listView = updateListViewAdapter();

        listView.setOnItemClickListener(((parent, view, position, id) -> {
            TextView textView = view.findViewById(R.id.good_description);
            String shortDescription = textView.getText().toString();
            goToGood(shortDescription);
        }));
    }

    public void goToGood(String shortDescription) {
        Intent intent = new Intent(this, WholeGoodActivity.class);
        intent.putExtra("shortDescription", shortDescription);
        intent.putExtra("stylesType", styleTypeEnum);
        startActivity(intent);
    }

    public void setBrownStyles(View view) {
        styleTypeEnum = StyleTypeEnum.BROWN;
        updateListViewAdapter();
    }

    public void setBlueStyles(View view) {
        styleTypeEnum = StyleTypeEnum.BLUE;
        updateListViewAdapter();
    }

    public void setDefaultStyles(View view) {
        styleTypeEnum = StyleTypeEnum.DEFAULT;
        updateListViewAdapter();
    }

    public ListView updateListViewAdapter() {
        List<GoodItem> items = GoodItemService.getItems();

        GoodListViewAdapter adapter =
                new GoodListViewAdapter(this, items, styleTypeEnum);

        ListView listView = findViewById(R.id.good_list_view);
        listView.setAdapter(adapter);

        return listView;
    }
}