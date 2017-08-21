package com.kasparpeterson.simplemvp;

import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * Created by kaspar on 01/09/16.
 */
public abstract class MVPBasePresenter<V extends MVPBaseView> {

    public interface ViewAction<V> {
        void onAction(V view);
    }

    private WeakReference<V> view;

    public void setView(V view) {
        this.view = new WeakReference<>(view);
    }

    // For overriding
    public void onViewAttached() {

    }

    // For overriding
    public void onResume() {

    }

    // For overriding
    public void onDestroy() {

    }

    void onDestory(boolean isChangingConfig) {
        view = null;
        if (!isChangingConfig) {
            onDestroy();
        }
    }

    // For overriding. Call super.onBackPressed() when not handling back button in child Presenter
    // class
    public void onBackPressed() {
        if (getView() != null)
            getView().handleOnBackPressed();
    }

    @Nullable
    @Deprecated
    // This should be made private once it is not used from outside anymore
    private V getView() {
        if (view != null) return view.get();
        return null;
    }

    protected void onView(ViewAction<V> viewAction) {
        if (getView() != null)
            viewAction.onAction(getView());
    }
}
