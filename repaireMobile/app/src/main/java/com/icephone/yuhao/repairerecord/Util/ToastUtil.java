package com.icephone.yuhao.repairerecord.Util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

    public static void showToastShort(Context context,String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}