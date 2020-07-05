package com.example.calender;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStamp {

    public static long convertDateTimeToTimeStamp(String onlyDate) {

        Log.i("dhjdjhd", "convertDateTimeToTimeStamp: "+onlyDate);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+5:30"));
        Date date = null;
        try {
            date = sdf.parse(onlyDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime() / 1000;
    }
}
