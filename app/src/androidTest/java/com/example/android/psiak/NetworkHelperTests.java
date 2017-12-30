package com.example.android.psiak;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.android.psiak.data.network.NetworkHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import okhttp3.OkHttpClient;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class NetworkHelperTests {

    @Test
    public void useAppContext() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.android.psiak", appContext.getPackageName());
    }

    @Test
    public void downloadUrlTest() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();

        String response = NetworkHelper.downloadUrl("https://qjs.quartic.pl/", appContext);
        assertEquals("index\n", response);
    }

    @Test
    public void downloadUrlFailureTest() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();

        String response = NetworkHelper.downloadUrl("http://malformed.url", appContext);
        assertEquals("", response);
    }

    @Test
    public void checkIfgetBuilderWithContextHasInterceptor() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();

        OkHttpClient.Builder client = NetworkHelper.getBuilder(appContext);
        assertEquals(1, client.interceptors().toArray().length);
    }

    @Test
    public void checkIfFirstInterceptorIsChuck() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();

        OkHttpClient.Builder client = NetworkHelper.getBuilder(appContext);
        assertEquals("ChuckInterceptor", client.interceptors().toArray()[0].getClass().getSimpleName());
    }

}
