package com.dustin.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname DateConverter
 * @Descrption TODO
 * @Date 2021/7/23上午 02:04
 * @Created By Dustin_Peng
 */
//<String, Date>將String轉換成Date
public class DateConverter implements Converter<String, Date> {
    public Date convert(String s) {
        //將日期字符串轉換成日期對象
        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = smf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
