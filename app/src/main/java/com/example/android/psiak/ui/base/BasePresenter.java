package com.example.android.psiak.ui.base;
/**
 * Base class for all presenters in application.
 * @param <V>
 */
public abstract class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    public V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public boolean isViewAttached() {
        return this.view != null;
    }
}
