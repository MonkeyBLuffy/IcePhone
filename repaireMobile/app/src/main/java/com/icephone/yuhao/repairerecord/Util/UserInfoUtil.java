package com.icephone.yuhao.repairerecord.Util;

import android.content.Context;

import com.icephone.yuhao.repairerecord.bean.LoginBean;
import com.icephone.yuhao.repairerecord.bean.PeopleBean;

public class UserInfoUtil {

    private final static String KEY_USER_ID = "id";
    private final static String KEY_USER_NICK_NAME = "nickname";
    private final static String KEY_USER_ACCOUNT = "account";
    private final static String KEY_USER_LIMIT = "limit";
    private final static String KEY_MANAGE_CENTER = "center";

    private final static int LIMIT_SUPER_MANAGER = 0;
    private final static int LIMIT_MANAGER = 1;
    private final static int LIMIT_REPAIR_MAN = 2;

    public static void saveUserInfo(Context context, LoginBean.DataBean bean) {
        SharedPerferenceUtils.setParam(context, KEY_USER_ID, bean.get_id());
        SharedPerferenceUtils.setParam(context, KEY_USER_ACCOUNT, bean.getAccount());
        SharedPerferenceUtils.setParam(context, KEY_USER_NICK_NAME, bean.getNick_name());
        SharedPerferenceUtils.setParam(context, KEY_USER_LIMIT, bean.getLimit());
        SharedPerferenceUtils.setParam(context,KEY_MANAGE_CENTER,bean.getManage_center());
    }

    public static String getUserName(Context context) {
        return (String) SharedPerferenceUtils.getParam(context, KEY_USER_NICK_NAME,"");
    }

    public static String getUserAccount(Context context) {
        return (String) SharedPerferenceUtils.getParam(context, KEY_USER_ACCOUNT, "");
    }

    public static String getKeyManageCenter(Context context) {
        return (String) SharedPerferenceUtils.getParam(context, KEY_MANAGE_CENTER, "");
    }

    public static boolean isSuperManager(Context context) {
        return (int)SharedPerferenceUtils.getParam(context, KEY_USER_LIMIT,"") == LIMIT_SUPER_MANAGER;
    }

    public static boolean isRepairMan(Context context) {
        return (int)SharedPerferenceUtils.getParam(context, KEY_USER_LIMIT,"") == LIMIT_REPAIR_MAN;
    }

    public static boolean isCenterManager(Context context) {
        return (int)SharedPerferenceUtils.getParam(context, KEY_USER_LIMIT,"") == LIMIT_MANAGER;
    }
    
}
