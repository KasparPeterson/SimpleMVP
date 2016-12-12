package com.kasparpeterson.simplemvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * Created by kaspar on 01/09/16.
 */
public abstract class MVPBasePresenter<V extends MVPBaseViewOperations, M extends MVPBaseModel>
        implements MVPBasePresenterModelOperations {

    private WeakReference<V> view;
    private M model;

    public MVPBasePresenter(V view, M model) {
        this.view = new WeakReference<>(view);
        this.model = model;
        model.setPresenter(this);
    }

    void onConfigurationChanged(V view) {
        this.view = new WeakReference<>(view);
    }

    public void onStart() {
        model.onStart();
        // For overriding
    }

    public void onResume() {
        model.onResume();
        // For overriding
    }

    void onDestory(boolean isChangingConfig) {
        view = null;
        if (!isChangingConfig) {
            model.onDestroy();
        }
    }

    protected void onSaveInstanceState(@NonNull Bundle outState) {
        model.onSaveInstanceState(outState);
        // For overriding
    }

    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        model.onRestoreInstanceState(savedInstanceState);
        // For overriding
    }

    @Nullable
    protected V getView() {
        if (view != null) return view.get();
        return null;
    }

    @NonNull protected M getModel() {
        return model;
    }
}
