package com.example.hw5_articles_goods.Services;

import com.example.hw5_articles_goods.Models.GoodItem;
import com.example.hw5_articles_goods.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GoodItemService {
    private final static ArrayList<GoodItem> itemList;

    static {
        itemList = new ArrayList<>();

        itemList.add(new GoodItem(
                "One Apple Red Delicious",
                "Red Delicious is a type of apple with " +
                        "a red exterior and sweet taste that was first recognized in " +
                        "Madison County, Iowa, in 1872. Today, " +
                        "the name Red Delicious comprises more than 50 cultivars. " +
                        "It was the most produced cultivar in the United States from 1968 to 2018," +
                        " when it was surpassed by Gala.",
                R.drawable.apple,
                0.80));
        itemList.add(new GoodItem(
                "One Carrot",
                "The carrot is a root vegetable, typically orange in colour.",
                R.drawable.carrot,
                0.35));
        itemList.add(new GoodItem(
                "One Eggplant",
                "The eggplant is most commonly purple, " +
                        "the spongy, absorbent fruit is used in several cuisines. " +
                        "Typically used as a vegetable in cooking, " +
                        "it is a berry by botanical definition.",
                R.drawable.eggplant,
                1.20));
        itemList.add(new GoodItem(
                "One Tomato",
                "The tomato is a plant whose fruit is an edible berry" +
                        " that is eaten as a vegetable. " +
                        "The tomato is a member of the nightshade family that includes tobacco," +
                        " potato, and chili peppers.",
                R.drawable.tomato,
                0.70));
    }

    public static ArrayList<GoodItem> getItems() {
        return itemList;
    }

    public static GoodItem getItemByShortDescription(String shortDescription) {
        List<GoodItem> itemsBuff = itemList.stream()
                .filter(good -> good.getShortDescription().equals(shortDescription))
                .collect(Collectors.toList());

        return itemsBuff.get(0);
    }
}
