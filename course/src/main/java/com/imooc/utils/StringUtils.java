package com.imooc.utils;

public class StringUtils {

    /**
     * 判断一个字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return str == null || "".equals(str);
    }
}
