package com.example.uiuxdesign.custom_views.helpers;

/**
 * Created by Mostafa on 11/4/2016.
 */
public class FormatHelper {
    private static String[] persianNumbers = new String[]{"۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹"};

    public static String toPersianNumber(String text) {
        if (text.isEmpty())
            return "";
        String out = "";
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            if ('0' <= c && c <= '9') {
                int number = Integer.parseInt(String.valueOf(c));
                out += persianNumbers[number];
            } else if (c == '٫') {
                out += '،';
            } else {
                out += c;
            }

        }
        return out;
    }

    public static String toEnglishNumber(String text){
        if (text.isEmpty())
            return "";
        String out = "";
        int length = text.length();
        for (int i = 0; i < length; i++) {
            String c = text.substring(i,i+1);
            boolean flag = false;
            for(int j=0;j<10;j++){
                if (c.equals(persianNumbers[j])) {
                    out += String.valueOf(j);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                out += c;
            }
        }
        return out;
    }
}