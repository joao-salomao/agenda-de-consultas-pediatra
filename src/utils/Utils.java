/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author João Salomão
 */
public final class Utils {
    
    private static final String DEFAULT_FORMAT_DATE = "dd/MM/yyyy";
    
    public static String mapperDate(Date date, String format) {
        if (date == null) {
            return "";
        }
        if (format == null) {
            format = DEFAULT_FORMAT_DATE;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }
    
    public static Date parseStringToDate(String sDate, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = formatter.parse(sDate);
        } catch(ParseException e) {
            System.out.println("ERRO NO PARSE DE STRING PARA DATE: "+e);
        }
        return date;
    }
}
