package com.icephone.yuhao.repairerecord.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeUtil {


    public static String getUploadTime(Calendar calendar) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(calendar.getTime());
    }

    public static String getShowTime(Calendar calendar) {
        SimpleDateFormat df = new SimpleDateFormat("时间：yyyy年MM月dd日");
        return df.format(calendar.getTime());
    }

}
