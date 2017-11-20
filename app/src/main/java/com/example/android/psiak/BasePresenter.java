package com.example.android.psiak;

/**
 * Created by Maciej Bialorucki on 20.11.17.
 */

public abstract class BasePresenter<T> {

    public T view;

    public void attach(T view) {
        this.view = view;
    }

    public void detach() {
        this.view = null;
    }
}
