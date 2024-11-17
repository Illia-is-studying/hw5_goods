package com.example.hw5_articles_goods.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hw5_articles_goods.Models.GoodItem;
import com.example.hw5_articles_goods.Models.StyleTypeEnum;
import com.example.hw5_articles_goods.R;
import com.example.hw5_articles_goods.Services.StyleTypeService;

import java.util.List;

public class GoodListViewAdapter extends BaseAdapter {
    private final Context context;
    private final List<GoodItem> items;
    private final StyleTypeEnum styleTypeEnum;

    public GoodListViewAdapter(Context context,
                               List<GoodItem> articleItems,
                               StyleTypeEnum styleTypeEnum) {
        this.context = context;
        this.items = articleItems;
        this.styleTypeEnum = styleTypeEnum;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.good_list_item, parent, false);
        }

        Drawable background = StyleTypeService
                .getBackgroundByStyleType(context, styleTypeEnum);

        LinearLayout linearLayout = convertView.findViewById(R.id.good_list_item);
        linearLayout.setBackground(background);
        ImageView imageView = convertView.findViewById(R.id.good_image);
        TextView textView = convertView.findViewById(R.id.good_description);

        GoodItem item = items.get(position);

        imageView.setImageResource(item.getImageDrawable());
        imageView.setContentDescription(item.getShortDescription());
        textView.setText(item.getShortDescription());

        return convertView;
    }
}
