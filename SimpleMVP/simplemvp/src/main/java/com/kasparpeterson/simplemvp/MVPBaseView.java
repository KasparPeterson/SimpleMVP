package com.kasparpeterson.simplemvp;

import android.support.annotation.StringRes;

/**
 * Created by kaspar on 01/09/16.
 */
public interface MVPBaseView {
    void handleOnBackPressed();
    void finish();
    void showToast(@StringRes int stringRes);
    void showToast(String text);
}
