package com.ling.sku.skuapp;

import java.util.List;

/**
 * ***************************************
 * statement:
 * auther: lingguiqin
 * date created : 2017/3/22 0022
 * ***************************************
 */

public class ProductSkuBean {

    private List<SkuProductListBean> skuProductList;
    private List<SkuTypeListBean> skuTypeList;

    public List<SkuProductListBean> getSkuProductList() {
        return skuProductList;
    }

    public void setSkuProductList(List<SkuProductListBean> skuProductList) {
        this.skuProductList = skuProductList;
    }

    public List<SkuTypeListBean> getSkuTypeList() {
        return skuTypeList;
    }

    public void setSkuTypeList(List<SkuTypeListBean> skuTypeList) {
        this.skuTypeList = skuTypeList;
    }

    public static class SkuProductListBean {
        /**
         * originPrice : 1072.00
         * prodBulk : null
         * prodColorPropImg : http://image.gxyj.com/v4/images/1/9000000024/1446363457472.jpg
         * prodImg : http://image.gxyj.com/v4/images/1/9000000024/1446356779290.jpg
         * prodPropName : 件
         * prodSkuId : 00000000000000006627
         * prodWeight : null
         * skuGroup : [{"prodEnumId":"0000023343","prodPropId":"0000100306"},{"prodEnumId":"0000023364","prodPropId":"0000100307"},{"prodEnumId":"0000023408","prodPropId":"0000100322"}]
         * skuPrice : 1072.00
         * skuStorage : 100
         * status : 1
         */

        private String originPrice;
        private String prodBulk;
        private String prodColorPropImg;
        private String prodImg;
        private String prodPropName;
        private String prodSkuId;
        private String prodWeight;
        private String skuPrice;
        private String skuStorage;
        private String status;
        private List<SkuGroupBean> skuGroup;

        public String getOriginPrice() {
            return originPrice;
        }

        public void setOriginPrice(String originPrice) {
            this.originPrice = originPrice;
        }

        public String getProdBulk() {
            return prodBulk;
        }

        public void setProdBulk(String prodBulk) {
            this.prodBulk = prodBulk;
        }

        public String getProdColorPropImg() {
            return prodColorPropImg;
        }

        public void setProdColorPropImg(String prodColorPropImg) {
            this.prodColorPropImg = prodColorPropImg;
        }

        public String getProdImg() {
            return prodImg;
        }

        public void setProdImg(String prodImg) {
            this.prodImg = prodImg;
        }

        public String getProdPropName() {
            return prodPropName;
        }

        public void setProdPropName(String prodPropName) {
            this.prodPropName = prodPropName;
        }

        public String getProdSkuId() {
            return prodSkuId;
        }

        public void setProdSkuId(String prodSkuId) {
            this.prodSkuId = prodSkuId;
        }

        public String getProdWeight() {
            return prodWeight;
        }

        public void setProdWeight(String prodWeight) {
            this.prodWeight = prodWeight;
        }

        public String getSkuPrice() {
            return skuPrice;
        }

        public void setSkuPrice(String skuPrice) {
            this.skuPrice = skuPrice;
        }

        public String getSkuStorage() {
            return skuStorage;
        }

        public void setSkuStorage(String skuStorage) {
            this.skuStorage = skuStorage;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<SkuGroupBean> getSkuGroup() {
            return skuGroup;
        }

        public void setSkuGroup(List<SkuGroupBean> skuGroup) {
            this.skuGroup = skuGroup;
        }

        public static class SkuGroupBean {
            /**
             * prodEnumId : 0000023343
             * prodPropId : 0000100306
             */

            private String prodEnumId;
            private String prodPropId;

            public String getProdEnumId() {
                return prodEnumId;
            }

            public void setProdEnumId(String prodEnumId) {
                this.prodEnumId = prodEnumId;
            }

            public String getProdPropId() {
                return prodPropId;
            }

            public void setProdPropId(String prodPropId) {
                this.prodPropId = prodPropId;
            }
        }
    }

    public static class SkuTypeListBean {
        /**
         * skuAttributeList : [{"skuAttribute":"200x230cm","skuAttributeCode":"0000023343"}]
         * skuTitle : 尺寸
         * skuTitleCode : 0000100306
         */

        private String skuTitle;
        private String skuTitleCode;
        private List<SkuAttributeListBean> skuAttributeList;

        public String getSkuTitle() {
            return skuTitle;
        }

        public void setSkuTitle(String skuTitle) {
            this.skuTitle = skuTitle;
        }

        public String getSkuTitleCode() {
            return skuTitleCode;
        }

        public void setSkuTitleCode(String skuTitleCode) {
            this.skuTitleCode = skuTitleCode;
        }

        public List<SkuAttributeListBean> getSkuAttributeList() {
            return skuAttributeList;
        }

        public void setSkuAttributeList(List<SkuAttributeListBean> skuAttributeList) {
            this.skuAttributeList = skuAttributeList;
        }

        public static class SkuAttributeListBean {
            /**
             * skuAttribute : 200x230cm
             * skuAttributeCode : 0000023343
             */

            private String skuAttribute;
            private String skuAttributeCode;

            public String getSkuAttribute() {
                return skuAttribute;
            }

            public void setSkuAttribute(String skuAttribute) {
                this.skuAttribute = skuAttribute;
            }

            public String getSkuAttributeCode() {
                return skuAttributeCode;
            }

            public void setSkuAttributeCode(String skuAttributeCode) {
                this.skuAttributeCode = skuAttributeCode;
            }
        }
    }
}
