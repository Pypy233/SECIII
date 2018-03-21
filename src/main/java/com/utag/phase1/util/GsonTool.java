package com.utag.phase1.util;

import com.google.gson.Gson;

/**
 * Gson工具类，提高读取一条和多条的方法
 */
public class GsonTool {

    public static <T> T getBean(String jsonStr, Class<T> tClass){
        Gson gson = new Gson();
        T result = gson.fromJson(jsonStr, tClass);
        return result;
    }

    public static String toJson(Object o){
        Gson gson = new Gson();
        return gson.toJson(o);
    }



}
