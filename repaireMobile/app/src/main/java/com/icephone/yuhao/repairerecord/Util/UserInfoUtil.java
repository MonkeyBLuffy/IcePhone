package com.icephone.yuhao.repairerecord.Util;

import android.content.Context;

import com.icephone.yuhao.repairerecord.bean.PeopleBean;

public class UserInfoUtil {

    public final static String KEY_USER_ID = "id";
    public final static String KEY_USER_NICK_NAME = "nickname";
    public final static String KEY_USER_ACCOUNT = "account";
    public final static String KEY_USER_LIMIT = "limit";


    public static void saveUserInfo(Context context, PeopleBean bean) {
        SharedPerferenceUtils.setParam(context, KEY_USER_ID, bean.get_id());
        SharedPerferenceUtils.setParam(context, KEY_USER_ACCOUNT, bean.getAccount());
        SharedPerferenceUtils.setParam(context, KEY_USER_NICK_NAME, bean.getNick_name());
        SharedPerferenceUtils.setParam(context, KEY_USER_LIMIT, bean.getLimit());
    }

    public static void getUserName(Context context) {
        SharedPerferenceUtils.getParam(context, KEY_USER_NICK_NAME,"");
    }

    public static String getUserAccount(Context context) {
        return (String) SharedPerferenceUtils.getParam(context, KEY_USER_ACCOUNT, "");
    }

    public static boolean isSuperManager(Context context) {
        SharedPerferenceUtils.getParam(context, KEY_USER_LIMIT,"");

        return false;
    }

    public static boolean isRepairMan(Context context) {
        SharedPerferenceUtils.getParam(context, KEY_USER_LIMIT, "");

        return false;
    }

    public static boolean isCenterManager(Context context) {
        SharedPerferenceUtils.getParam(context, KEY_USER_LIMIT, "");

        return false;
    }



}
