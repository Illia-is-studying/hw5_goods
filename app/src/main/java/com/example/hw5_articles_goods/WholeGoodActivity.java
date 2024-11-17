package com.example.hw5_articles_goods;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hw5_articles_goods.Models.GoodItem;
import com.example.hw5_articles_goods.Models.StyleTypeEnum;
import com.example.hw5_articles_goods.Services.GoodItemService;
import com.example.hw5_articles_goods.Services.StyleTypeService;

import java.text.DecimalFormat;

public class WholeGoodActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_whole_good);

        Intent intent = getIntent();
        String shortDescription = intent.getStringExtra("shortDescription");
        GoodItem goodItem = GoodItemService.getItemByShortDescription(shortDescription);

        StyleTypeEnum styleType = (StyleTypeEnum) intent
                .getSerializableExtra("stylesType");

        if (styleType != null) {
            LinearLayout linearLayout = findViewById(R.id.whole_good);
            linearLayout.setBackground(StyleTypeService
                    .getBackgroundByStyleType(this, styleType));
        }

        TextView textView = findViewById(R.id.good_title);
        textView.setText(goodItem.getShortDescription());

        textView = findViewById(R.id.good_full_description);
        textView.setText(goodItem.getFullDescription());

        textView = findViewById(R.id.good_price);
        textView.setText(new DecimalFormat("$0.00").format(goodItem.getPrice()));

        ImageView imageView = findViewById(R.id.good_image);
        imageView.setImageResource(goodItem.getImageDrawable());
        imageView.setContentDescription(goodItem.getShortDescription());
    }
}
