package com.example.android.psiak.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.util.Log;

import com.example.android.psiak.ui.main.MainActivity;
import com.example.android.psiak.ui.main.MainPresenter;

/**
 * Created by Rewan on 09.02.2018.
 */

public class NetworkState extends BroadcastReceiver {

    IntentFilter mNetworkIntentFilter;
    NetworkStateDataListener networkStateDataListener;


    public NetworkState(NetworkStateDataListener dataListner) {
        super();
        mNetworkIntentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        this.networkStateDataListener = dataListner;
    }

    public IntentFilter getIntentFilter(){
        return mNetworkIntentFilter;
    }

    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public IBinder peekService(Context myContext, Intent service) {
        return super.peekService(myContext, service);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (isNetworkAvailable(context)) {
            networkStateDataListener.refreshAnimalsData();
        }
    }
}
