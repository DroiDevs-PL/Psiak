package com.example.android.psiak.utils;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.android.psiak.R;
import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

import java.util.List;


public class GooglePlayUtils {

    private final static int LAUNCHES_UNTIL_PROMPT = 4;
    static boolean userIsHappy = false;

    public static void app_launched(Context mContext) {

        SharedPreferences prefs = mContext.getSharedPreferences("apprater", 0);

        if (prefs.getBoolean("dontshowagain", false)) {
            return;
        }
        // Increment launch counter
        long launch_count = HelperSharedPrefs.getSharedPreferencesLong(mContext, "launch_count", 0) + 1;
        HelperSharedPrefs.putSharedPreferencesLong(mContext, "launch_count", launch_count);

        if (launch_count >= LAUNCHES_UNTIL_PROMPT) {
        }
    }

    @SuppressLint("ResourceAsColor")
    public static void showRateDialog(final Context mContext) {
        final AlertDialog.Builder alertadd = new AlertDialog.Builder(mContext);
        LayoutInflater factory = LayoutInflater.from(mContext);

        final View view = factory.inflate(R.layout.rating_dialog, null);

        alertadd.setView(view);
        alertadd.setCancelable(false);
        alertadd.setPositiveButton(R.string.ok, (dialog, which) -> {
            if (userIsHappy) {
                openAppInStore(mContext);
                dialog.dismiss();
            }
        });

        alertadd.setNegativeButton(R.string.another_time, (dialog, which) -> {
            dialog.dismiss();
            HelperSharedPrefs.putSharedPreferencesLong(mContext, "launch_count", 0);
        });

        TextView title = new TextView(mContext);
        title.setText(R.string.rate_title);
        title.setBackgroundResource(R.color.colorPrimaryDark);
        title.setPadding(10, 10, 10, 10);
        title.setGravity(Gravity.CENTER);
        title.setTextColor(Color.WHITE);
        title.setTextSize(20);
        alertadd.setCustomTitle(title);
        alertadd.show();

        SmileRating smileRating = view.findViewById(R.id.smile_rating);
        smileRating.setNameForSmile(BaseRating.TERRIBLE, R.string.rating_0);
        smileRating.setNameForSmile(BaseRating.GREAT, R.string.rating_3);
        smileRating.setNameForSmile(BaseRating.GOOD, R.string.rating_4);
        smileRating.setNameForSmile(BaseRating.OKAY, R.string.rating_2);
        smileRating.setNameForSmile(BaseRating.BAD, R.string.rating_1);

        smileRating.setOnSmileySelectionListener((smiley, reselected) -> {
            // reselected is false when user selects different smiley that previously selected one
            // true when the same smiley is selected.
            // Except if it first time, then the value will be false.
            switch (smiley) {
                case SmileRating.BAD:
                    userIsHappy = false;
                    break;
                case SmileRating.GOOD:
                    userIsHappy = false;
                    break;
                case SmileRating.OKAY:
                    userIsHappy = false;
                    break;
                case SmileRating.TERRIBLE:
                    userIsHappy = false;
                    break;
                case SmileRating.GREAT:
                    userIsHappy = true;
                    break;
            }
            HelperSharedPrefs.putSharedPreferencesBoolean(mContext,"dontshowagain", true);
        });
    }

    private static void openAppInStore(Context mContext) {

        String appId = mContext.getPackageName();
        Intent rateIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("market://details?id=" + appId));
        boolean marketFound = false;

        // find all applications able to handle our rateIntent
        final List<ResolveInfo> otherApps = mContext.getPackageManager()
                .queryIntentActivities(rateIntent, 0);
        for (ResolveInfo otherApp : otherApps) {
            // look for Google Play application
            if (otherApp.activityInfo.applicationInfo.packageName
                    .equals("com.android.vending")) {

                ActivityInfo otherAppActivity = otherApp.activityInfo;
                ComponentName componentName = new ComponentName(
                        otherAppActivity.applicationInfo.packageName,
                        otherAppActivity.name
                );
                // make sure it does NOT open in the stack of your activity
                rateIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                // task reparenting if needed
                rateIntent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                // if the Google Play was already open in a search result
                //  this make sure it still go to the app page you requested
                rateIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // this make sure only the Google Play app is allowed to
                // intercept the intent
                rateIntent.setComponent(componentName);
                try {
                    mContext.startActivity(rateIntent);
                } catch (android.content.ActivityNotFoundException anfe) {
                    mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + mContext.getPackageName())));
                }
                break;

            }
        }
    }

    public static void showPremiumVersion(Context mContext) {
        String appId = "pl.pzarzycki.guteklabs.tablicapl.premium";
        Intent rateIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("market://details?id=" + appId));
        // find all applications able to handle our rateIntent
        final List<ResolveInfo> otherApps = mContext.getPackageManager()
                .queryIntentActivities(rateIntent, 0);
        for (ResolveInfo otherApp : otherApps) {
            // look for Google Play application
            if (otherApp.activityInfo.applicationInfo.packageName
                    .equals("com.android.vending")) {

                ActivityInfo otherAppActivity = otherApp.activityInfo;
                ComponentName componentName = new ComponentName(
                        otherAppActivity.applicationInfo.packageName,
                        otherAppActivity.name
                );
                // make sure it does NOT open in the stack of your activity
                rateIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                // task reparenting if needed
                rateIntent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                // if the Google Play was already open in a search result
                //  this make sure it still go to the app page you requested
                rateIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // this make sure only the Google Play app is allowed to
                // intercept the intent
                rateIntent.setComponent(componentName);
                try {
                    mContext.startActivity(rateIntent);
                } catch (android.content.ActivityNotFoundException anfe) {
                    mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" +appId)));
                }
                break;

            }
        }
    }
}