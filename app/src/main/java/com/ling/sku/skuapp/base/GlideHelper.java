package com.ling.sku.skuapp.base;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ling.sku.skuapp.R;


/**
 * ***************************************
 * statement:
 * auther: lingguiqin
 * date created : 2017/3/25 0025
 * ***************************************
 */

public class GlideHelper {

    private GlideHelper() {

    }

    public static void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.img_default)
                .into(imageView);
    }


}
