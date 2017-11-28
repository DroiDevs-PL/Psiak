package com.example.android.psiak.data.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;

import com.readystatesoftware.chuck.ChuckInterceptor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

/**
 * Helper class for working with a remote server
 */
public class NetworkHelper {

    /**
     * Builds client which should be used with any http requests.
     * @param context app context
     * @param cache cache dir
     * @return OkHttpClient
     */
    public static OkHttpClient.Builder getBuilder(Context context, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(new ChuckInterceptor(context))
                .cache(cache);
    }

    /**
     * Builds client without cache! Use only in the last resort!
     * @param context app context
     * @return OkHttpClient
     */
    public static OkHttpClient.Builder getBuilder(Context context) {
        return new OkHttpClient.Builder()
                .addInterceptor(new ChuckInterceptor(context));
    }

    /**
     * Returns text from a URL on a web server
     *
     * @param address what page we should fetch
     * @return String|null
     * @throws IOException when can not fetch page
     */
    public static String downloadUrl(String address, Context context) throws IOException {
        String result = "";

        try {
            OkHttpClient okHttpClient = getBuilder(context)
                    .connectTimeout((long) 15000, TimeUnit.MILLISECONDS )
                    .readTimeout((long) 10000, TimeUnit.MILLISECONDS )
                    .build();
            Request request = new Request.Builder()
                    .url(address)
                    .build();

            Response httpResponse = okHttpClient.newCall(request).execute();

            if(httpResponse.isSuccessful()) {
                result = httpResponse.body().string();
            } else {
                int responseCode = httpResponse.code();
                Timber.e("Wrong response code %i", responseCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Check for Network connection status, if boolean is true it will also check for Internet access
     *
     * @param context app context
     * @param networkListener network state updated
     * @param checkForInternetAccess if user has access to internet
     * todo method not used inside project! Determine what to do with it
     */
    public static void checkInternetConnection(@NonNull Context context, NetworkListener networkListener, boolean checkForInternetAccess) {

        boolean isConnectedToInternet = IsNetworkConnected(context);
        if (checkForInternetAccess && isConnectedToInternet) {
            hasInternetAccess(networkListener);
        } else {
            networkListener.updateNetworkState(isConnectedToInternet);
        }

    }

    /**
     * Checks if user has access to the internet
     *
     * @param networkListener interface updating network state
     * todo Maybe we should generate 204 to our server instead google.com (in order to prefetch DNS)
     * @link https://stackoverflow.com/questions/1989214/google-com-and-clients1-google-com-generate-204
     */
    private static void hasInternetAccess(final NetworkListener networkListener) {
        new Thread() {
            @Override
            public void run() {
                try {
                    HttpURLConnection urlc = (HttpURLConnection) new URL("http://clients3.google.com/generate_204").openConnection();
                    urlc.setRequestProperty("User-Agent", "Android");
                    urlc.setRequestProperty("Connection", "close");
                    urlc.setConnectTimeout(1500);
                    urlc.connect();

                    if (urlc.getResponseCode() == 204 && urlc.getContentLength() == 0) {
                        networkListener.updateNetworkState(true);
                    } else {
                        networkListener.updateNetworkState(false);
                    }


                } catch (IOException e) {
                    networkListener.updateNetworkState(false);
                }
            }
        };
    }

    /**
     * Checks if user is connected to the network
     *
     * @param context app context
     * @return boolean
     */

    private static boolean IsNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        try {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return (networkInfo != null && networkInfo.isConnectedOrConnecting());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * Network listener
     *
     * Updates network state
     */
    public interface NetworkListener {
        void updateNetworkState(boolean status);
    }
}