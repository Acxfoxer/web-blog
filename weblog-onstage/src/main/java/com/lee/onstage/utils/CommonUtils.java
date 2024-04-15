package com.lee.onstage.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 公共工具类
 * @author Acxfoxer
 * @date 20240413
 */
public class CommonUtils {

    public static boolean checkEmail(String email){
        Pattern pattern = Pattern.compile("^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
