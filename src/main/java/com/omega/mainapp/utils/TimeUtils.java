package com.omega.mainapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    public static String getCurrentTime() {
        long currentTimeMillis = System.currentTimeMillis();
        Date currentTime = new Date(currentTimeMillis);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy--HH:mm:ss");
        String formattedTime = dateFormat.format(currentTime);
        return formattedTime;
    }
}
