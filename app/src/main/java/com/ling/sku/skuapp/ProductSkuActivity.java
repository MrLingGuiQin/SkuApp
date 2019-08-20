package com.ling.sku.skuapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2017/3/21 0021
 * ***************************************
 */

public class ProductSkuActivity extends AppCompatActivity {
    private SelectSkuDialog mSelectSkuDialog;
    public static String SKU_JSON = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_sku_layout);
        initData();
        findViewById(R.id.btn_select_sku).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(SKU_JSON)) return;

                if (mSelectSkuDialog == null) {
                    mSelectSkuDialog = new SelectSkuDialog(ProductSkuActivity.this,
                            R.style.bottomDialogStyle,
                            1,
                            0.7,
                            Gravity.BOTTOM,
                            true);
                }
                mSelectSkuDialog.show();
            }
        });
    }


    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 本地模拟请求服务器数据
                InputStream stream = getResources().openRawResource(R.raw.sku_json);
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                StringBuilder jsonStr = new StringBuilder();
                String line;
                try {
                    while ((line = reader.readLine()) != null) {
                        jsonStr.append(line);
                    }
                    SKU_JSON = jsonStr.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
