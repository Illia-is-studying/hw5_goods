package com.example.hw5_articles_goods.Services;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.example.hw5_articles_goods.Models.StyleTypeEnum;
import com.example.hw5_articles_goods.R;

public class StyleTypeService {
    public static Drawable getBackgroundByStyleType(Context context, StyleTypeEnum styleTypeEnum) {
        if(styleTypeEnum.equals(StyleTypeEnum.BLUE)) {
            return ContextCompat.getDrawable(context, R.drawable.card_blue_background);
        } else if(styleTypeEnum.equals(StyleTypeEnum.BROWN)) {
            return ContextCompat.getDrawable(context, R.drawable.card_brown_background);
        }

        return ContextCompat.getDrawable(context, R.drawable.card_background);
    }
}
