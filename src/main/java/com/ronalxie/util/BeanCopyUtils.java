package com.ronalxie.util;

import org.springframework.beans.BeanUtils;

public class BeanCopyUtils {

    public static <V> V copyBean(Object source,Class<V> clazz){
        V result=null;
        try{
            result=clazz.newInstance();
            BeanUtils.copyProperties(source,result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
