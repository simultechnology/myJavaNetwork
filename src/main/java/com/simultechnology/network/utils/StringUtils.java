package com.simultechnology.network.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ishi on 15/02/15.
 */
public class StringUtils {

    public static Map<String, String> getQueryMap(String query) {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params) {
            String[] splitted = param.split("=");
            map.put(splitted[0], splitted[1]);
        }
        return map;
    }
}
