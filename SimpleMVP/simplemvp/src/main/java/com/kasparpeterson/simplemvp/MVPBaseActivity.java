package com.kasparpeterson.simplemvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by kaspar on 30/08/16.
 */
public abstract class MVPBaseActivity<P extends MVPBasePresenter, V extends MVPBaseView>
        extends AppCompatActivity implements MVPBaseView {

    private final String TAG = "activity_tag";
    private final String PRESENTER_TAG = "presenter_tag";
    private MVPStateMaintainer MVPStateMaintainer;
    private P presenter;

    private boolean isJustCreated;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupPresenter();
        isJustCreated = true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isJustCreated && presenter != null) {
            presenter.onViewAttached();
        }
        isJustCreated = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null)
            presenter.onDestory(isChangingConfigurations());
    }

    @Override
    public void onBackPressed() {
        if (presenter != null)
            presenter.onBackPressed();
        else
            super.onBackPressed();
    }

    @Override
    public void handleOnBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void showToast(@StringRes int stringRes) {
        showToast(getString(stringRes));
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    protected void setupPresenter() {
        createStateMaintainerIfNecessary();
        initialisePresenter();
    }

    private void createStateMaintainerIfNecessary() {
        if (MVPStateMaintainer == null)
            MVPStateMaintainer = new MVPStateMaintainer(getSupportFragmentManager(), TAG);
    }

    private void initialisePresenter() {
        if (MVPStateMaintainer.isStateMaintainerCreated())
            reinitialisePresenter();
        else
            initialisePresenterForTheFirstTime();
    }

    private void initialisePresenterForTheFirstTime() {
        presenter = createPresenter();
        //noinspection unchecked
        presenter.setView(getView());
        MVPStateMaintainer.initialiseStateMaintainer();
        MVPStateMaintainer.put(PRESENTER_TAG, presenter);
    }

    @SuppressWarnings("unchecked")
    private void reinitialisePresenter() {
        presenter = MVPStateMaintainer.get(PRESENTER_TAG);

        if (presenter == null)
            initialisePresenterForTheFirstTime();
        else
            presenter.setView(getView());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    protected P getPresenter() {
        return presenter;
    }

    protected abstract V getView();
    protected abstract P createPresenter();
}
