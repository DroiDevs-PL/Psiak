package com.example.android.psiak.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by Maciej Bialorucki on 12.12.17.
 */

public interface MvpView {

    void showMessage(@StringRes int messageId);
    void showErrorMessage(String errorMessage);

}
