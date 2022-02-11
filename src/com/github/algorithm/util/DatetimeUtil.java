package com.github.algorithm.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @Author: zlzhang0122
 * @Date: 2022/2/10 下午2:14
 */
public class DatetimeUtil {
    public static void main(String[] args){
        Timestamp today = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String now = simpleDateFormat.format(today);
        today = Timestamp.valueOf(now);
        System.out.println(today);
    }
}
