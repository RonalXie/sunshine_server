package com.ronalxie.util;

public class IDUtils {
    public static synchronized Long nextId(){
        return System.currentTimeMillis();
    }
}
