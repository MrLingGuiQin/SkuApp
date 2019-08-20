package com.ling.sku.skuapp;

import java.util.List;

/**
 * ***************************************
 * statement:
 * auther: lingguiqin
 * date created : 2017/4/8 0008
 * ***************************************
 */

public class ProductBean {

    public List<SkuProductListBean> skuProductList; // sku的所有组合
    public List<String> skuProductFailureList; // 不支持购买的sku组合
    public List<SkuTypeListBean> skuTypeList; // sku 具体数据

    public static class SkuProductListBean {
        public String prodImg;
        public String prodPropName;
        public String prodSkuId;
        public String skuGroup;
        public String skuPrice;
        public String skuStorage;
        public String skuProdEnumValue;

    }

    public static class SkuTypeListBean {
        /**
         * skuAttributeList : [{"skuAttribute":"200x230cm","skuAttributeCode":"0000023343"}]
         * skuTitle : 尺寸
         * skuTitleCode : 0000100306
         */

        public String skuTitle;
        public String skuTitleCode;
        public List<SkuAttributeListBean> skuAttributeList;
        public List<String> skuAttributeFailureList;

        public static class SkuAttributeListBean {
            /**
             * skuAttribute : 200x230cm
             * skuAttributeCode : 0000023343
             */
            public String skuAttribute;
            public String skuAttributeCode;

        }
    }
}
