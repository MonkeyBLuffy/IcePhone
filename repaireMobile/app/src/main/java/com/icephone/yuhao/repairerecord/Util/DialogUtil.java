package com.icephone.yuhao.repairerecord.Util;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;

public class DialogUtil {

    public static void showAlertDialog(Context context,
                                       @LayoutRes int resId,
                                       String title,
                                       String positiveMsg,
                                       DialogInterface.OnClickListener positiveListener,
                                       String negativeMsg,
                                       DialogInterface.OnClickListener negativeListener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setPositiveButton(positiveMsg, positiveListener);
        builder.setNegativeButton(negativeMsg, negativeListener);
        AlertDialog dialog = builder.create();
        View view = View.inflate(context, resId, null);
        dialog.setTitle(title);
        dialog.setView(view);
        dialog.show();
    }

    public static void showDateDialog(Context context,Calendar calendar,DatePickerDialog.OnDateSetListener listener) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, listener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

}
