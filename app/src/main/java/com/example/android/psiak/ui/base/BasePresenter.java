package com.example.android.psiak.ui.base;

/**
 * Created by Maciej Bialorucki on 20.11.17.
 */

public abstract class BasePresenter<T> {

    //TODO consider another layout of abstraction
    //BasePresenter<T extends MvpView> implments MvpPresenter<V>
    public T view;

    public void attach(T view) {
        this.view = view;
    }

    public void detach() {
        this.view = null;
    }

    public boolean isViewAttached(){
        return this.view != null;
    }
}
