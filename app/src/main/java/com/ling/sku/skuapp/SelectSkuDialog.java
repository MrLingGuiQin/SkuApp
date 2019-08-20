package com.ling.sku.skuapp;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ling.sku.skuapp.base.GlideHelper;
import com.ling.sku.skuapp.base.GsonUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2017/3/22 0022
 * ***************************************
 */

public class SelectSkuDialog extends BaseCustomDialog implements View.OnClickListener, SkuAdapter.OnChangeSkuProductDataListener {

    private ImageView mImgProductImage;
    private TextView mTxtProductPrice;
    private TextView mTxtProductStorage;
    private TextView mTxtProductSelectInfo;
    private ListView mLsvSku;
    private ProductBean mProductBean;
    private Button mBtnOk;

    public SelectSkuDialog(Activity activity, int style, double widthPercentage, double heightPercentage, int gravity, boolean isCanceledOnTouchOutside) {
        super(activity, style, widthPercentage, heightPercentage, gravity, isCanceledOnTouchOutside);
        initData();
    }


    @Override
    public View initView() {
        View dialogView = mInflater.inflate(R.layout.dialog_select_sku_layout, null, false);
        mImgProductImage = (ImageView) dialogView.findViewById(R.id.img_product_sku_dialog_product_image);
        mTxtProductPrice = (TextView) dialogView.findViewById(R.id.txt_product_sku_dialog_product_price);
        mTxtProductStorage = (TextView) dialogView.findViewById(R.id.txt_product_sku_dialog_product_storage);
        mTxtProductSelectInfo = (TextView) dialogView.findViewById(R.id.txt_product_sku_dialog_select_product_info);
        mBtnOk = (Button) dialogView.findViewById(R.id.btn_product_sku_dialog_close);
        mLsvSku = (ListView) dialogView.findViewById(R.id.lsv_product_sku_dialog_product_sku);
        mBtnOk.setOnClickListener(this);
        return dialogView;
    }

    private void initData() {

        mProductBean = GsonUtil.StringToObject(ProductSkuActivity.SKU_JSON, ProductBean.class);
        // 处理不能购买的sku组合数据
        List<String> failureSkuList = new ArrayList<>();
        if (mProductBean.skuProductList != null
                && mProductBean.skuProductList.size() > 0) {
            for (ProductBean.SkuProductListBean skuProductListBean : mProductBean.skuProductList) {
                if (skuProductListBean.skuStorage.equals("0")) {
                    failureSkuList.add(skuProductListBean.skuGroup);
                }
            }
            mProductBean.skuProductFailureList = failureSkuList;
        }

        // 处理sku不可点击的数据
        if (mProductBean.skuTypeList != null
                && mProductBean.skuTypeList.size() > 0) {
            for (ProductBean.SkuTypeListBean skuTypeListBean : mProductBean.skuTypeList) {
                skuTypeListBean.skuAttributeFailureList = new ArrayList<>();
            }
        }

        SkuAdapter mAdapter = new SkuAdapter(mActivity, mProductBean, R.layout.dialog_listview_sku_item);
        mAdapter.setOnChangeSkuProductDataListener(this);
        mLsvSku.setAdapter(mAdapter);
    }

    @Override
    public void updateSkuProductData(ProductBean.SkuProductListBean skuProductListBean) {
        if (skuProductListBean != null) {
            mTxtProductPrice.setText("￥" + skuProductListBean.skuPrice);
            mTxtProductStorage.setText("库存：" + skuProductListBean.skuStorage + skuProductListBean.prodPropName);
            GlideHelper.loadImage(mActivity, skuProductListBean.prodImg, mImgProductImage);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_product_sku_dialog_close:
                cancel();
                break;
        }
    }


}
