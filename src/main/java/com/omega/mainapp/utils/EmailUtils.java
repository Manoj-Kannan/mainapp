package com.omega.mainapp.utils;

public class EmailUtils {
    public static void emailException(String fromClass, String msg, Throwable e) {
        emailException(fromClass, msg, e, null);
    }

    public static void emailException(String fromClass, String msg, String info) {
        emailException(fromClass, msg, null, info);
    }

    public static void emailException(String fromClass, String msg, Throwable e, String info) {

    }
}
