package com.example.android.psiak.Utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.DimenRes;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by pzarzycki on 08.12.2017.
 */

public class PsiakUtils {

    private static volatile PsiakUtils instance = null;
    private final Context mContext;
    private static int statusBarHeight = -1;

    private PsiakUtils(Context context) {
        if (context instanceof Activity) {
            mContext = context.getApplicationContext();
        } else {
            mContext = context;
        }
    }

    public static PsiakUtils getInstance() {
        if (instance == null) {
            throw new IllegalStateException(PsiakUtils.class.getSimpleName() +
                    " Initialize First!");
        }
        return instance;
    }

    public static synchronized void init(Context context) {
        if (instance == null) {
            instance = new PsiakUtils(context);
        }
    }

    public static boolean isNumericValue(final CharSequence valuetoCheck) {
        if (TextUtils.isEmpty(valuetoCheck)) {
            return false;
        }
        final int length = valuetoCheck.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(valuetoCheck.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    public DisplayMetrics getMetrics() {
        return mContext.getResources().getDisplayMetrics();
    }

    public int getDimensionPixelSize(@DimenRes int resourceId) {
        return mContext.getResources().getDimensionPixelSize(resourceId);
    }

    public int fromDpToPx(float dps) {
        float scaleFactor = getScreenDensity();
        return (int) Math.ceil(dps * scaleFactor);
    }

    private float getScreenDensity() {
        return getMetrics().density;
    }
    public int getScreenWidth() {
        return getMetrics().widthPixels;
    }

    public int getScreenHeight() {
        return getMetrics().heightPixels;
    }

    public int getStatusBarHeight() {

        if (statusBarHeight == -1) {
            int statusBarResIndex = mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
            statusBarHeight = mContext.getResources().getDimensionPixelSize(statusBarResIndex);
        }
        return statusBarHeight;
    }

    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String phoneModel = Build.MODEL;
        if (phoneModel.startsWith(manufacturer) || phoneModel.startsWith(manufacturer.toUpperCase())) {
            return phoneModel;
        }
        return manufacturer + " " + phoneModel;
    }

    public void calculateToastPosition(Toast t, View v) {
        if (v != null) {
            int[] location = new int[2];
            v.getLocationOnScreen(location);
            int viewX = location[0];
            int viewY = location[1];

            int screenWidth = getScreenWidth();
            int margin = (int) (screenWidth * 0.05);
            int xOff;

            if (viewX < getScreenWidth() / 2) {

                if (viewX - v.getWidth() / 2 < margin)
                    xOff = margin;
                else
                    xOff = viewX - margin;

                t.setGravity(Gravity.TOP | Gravity.START, xOff, viewY);

            } else {

                if (screenWidth - (viewX + (int) (1.5 * v.getWidth())) < margin)
                    xOff = margin;
                else
                    xOff = screenWidth - (viewX + (int) (1.5 * v.getWidth()));

                t.setGravity(Gravity.TOP | Gravity.END, xOff, viewY);
            }
        }
    }
}