package com.ling.sku.skuapp.base;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2017/3/22 0022
 * ***************************************
 */

public class GsonUtil {
    private static Gson mGson = new Gson();

    /**
     * 将Json字符串转化成实体对象
     *
     * @param json
     * @param classOfT
     * @return
     */
    public static <T> T StringToObject(String json, Class<T> classOfT) {
        T result = mGson.fromJson(json, classOfT);
        return result;
    }


    /**
     * 将实体对象转化成Json字符串
     *
     * @param object
     * @param <T>
     * @return
     */
    public static <T> String ObjectToString(T object) {
        return mGson.toJson(object);
    }

    /**
     * 把Json 字符串转化成List
     *
     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> List<T> StringToList(String json, Class<T> cls) {
        List<T> list = new ArrayList<>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for (final JsonElement jsonElement : array) {
            list.add(mGson.fromJson(jsonElement, cls));
        }
        return list;
    }


}
