package com.example.android.psiak.Network;

/**
 * Created by pzarzycki on 13.11.2017.
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Helper class for working with a remote server
 */
public class NetworkHelper {

    /**
     * Returns text from a URL on a web server
     *
     * @param address
     * @return
     * @throws IOException
     */
    public static String downloadUrl(String address) throws IOException {

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
     * @param stream
     * @return
     * @throws IOException
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
     * @param context
     * @param networkListener
     * @param checkForInternetAccess
     */
    public static void checkInternetConnection(@NonNull Context context, NetworkListener networkListener, boolean checkForInternetAccess) {

        boolean isConnectedToInternet = IsNetworkConnected(context);
        if (checkForInternetAccess && isConnectedToInternet) {
            hasInternetAccess(networkListener);
        } else {
            networkListener.updateNetworkState(isConnectedToInternet);
        }

    }

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

    public static boolean IsNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        try {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return (networkInfo != null && networkInfo.isConnectedOrConnecting());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public interface NetworkListener {
        void updateNetworkState(boolean status);
    }
}