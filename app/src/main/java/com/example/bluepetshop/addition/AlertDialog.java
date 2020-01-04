package com.example.bluepetshop.addition;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

public class AlertDialog{
    public void defaultAlert(String title, String msg, Context context){
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(msg);

        String positiveText = context.getString(android.R.string.ok);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        androidx.appcompat.app.AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void directAlert(String title, String msg, final Context context, final Activity activity){
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(msg);

        String positiveText = context.getString(android.R.string.ok);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        context.startActivity(new Intent(context, activity.getClass()));
                        dialog.dismiss();
                        ((Activity) context).finish();
                    }
                });

        androidx.appcompat.app.AlertDialog dialog = builder.create();
        dialog.show();
    }
}
