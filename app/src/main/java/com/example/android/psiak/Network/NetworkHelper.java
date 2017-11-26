package com.example.android.psiak.Network;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;

import com.readystatesoftware.chuck.ChuckInterceptor;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

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
    public static OkHttpClient buildClient(Context context, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(new ChuckInterceptor(context))
                .cache(cache).build();
    }

    /**
     * Builds client without cache! Use only in the last resort!
     * @param context app context
     * @return OkHttpClient
     */
    public static OkHttpClient buildClient(Context context) {
        return new OkHttpClient.Builder()
                .addInterceptor(new ChuckInterceptor(context))
                .build();
    }

    /**
     * Returns text from a URL on a web server
     *
     * @param address what page we should fetch
     * @return String|null
     * @throws IOException when can not fetch page
     */
    public static String downloadUrl(String address, Context context) throws IOException {

        InputStream is = null;
        try {

            URL url = new URL(address);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new IOException("Got response code " + responseCode);
            }
            is = conn.getInputStream();
            return readStream(is);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }
        }
        return null;
    }

    /**
     * Reads an InputStream and converts it to a String.
     *
     * @param stream text fetched form server
     * @return String|null
     * @throws IOException when wasn't able  to read stream
     */
    private static String readStream(InputStream stream) throws IOException {

        byte[] buffer = new byte[1024];
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        BufferedOutputStream out = null;
        try {
            int length = 0;
            out = new BufferedOutputStream(byteArray);
            while ((length = stream.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.flush();
            return byteArray.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (out != null) {
                out.close();
            }
        }
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