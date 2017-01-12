package com.kasparpeterson.simplemvp;

import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by kaspar on 01/09/16.
 */
public abstract class MVPBaseModel<P extends MVPBasePresenterModelOperations> {

    private P presenter;

    public MVPBaseModel() {

    }

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    protected abstract void onDestroy();

    protected void onStart() {

    }

    protected void onResume() {
        // For overriding
    }

    protected void onSaveInstanceState(@NonNull Bundle outState) {
        // For overriding
    }

    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        // For overriding
    }

    @NonNull public P getPresenter() {
        return presenter;
    }
}
