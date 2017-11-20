package com.example.android.psiak;

/**
 * Created by Maciej Bialorucki on 20.11.17.
 */

public interface BasePresenter<T> {

    void attach(T view);
    void detach();
}
