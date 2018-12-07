package com.accenture.smsf.codegen.utils;

public class StringUtils {

    public static String toLowerCaseFirstChar(String str) {
        if (Character.isLowerCase(str.charAt(0))) {
            return str;
        } else {
            char[] chars = str.toCharArray();
            chars[0] = Character.toLowerCase(chars[0]);
            return new String(chars);
        }
    }
}
