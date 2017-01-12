package com.kasparpeterson.simplemvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * This is View in MVP (Model-View-Presenter) pattern.
 *
 * Created by kaspar on 30/08/16.
 */
public abstract class MVPBaseActivity<P extends MVPBasePresenter> extends AppCompatActivity
        implements MVPBaseViewOperations {

    private final String TAG = MVPBaseActivity.class.getSimpleName();
    private MVPStateMaintainer MVPStateMaintainer;
    private MVPBaseViewOperations viewOperations;
    private P presenter;
    private String presenterTAG;
    private Bundle savedInstanceState;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        callSetupPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestory(isChangingConfigurations());
    }

    @Override
    public void onBackPressed() {
        presenter.onBackPressed();
    }

    @Override
    public void handleOnBackPressed() {
        super.onBackPressed();
    }

    protected void setupPresenter(MVPBaseViewOperations viewOperations, String TAG, String presenterTAG) {
        this.viewOperations = viewOperations;
        this.presenterTAG = presenterTAG;

        if (MVPStateMaintainer == null) {
            MVPStateMaintainer = new MVPStateMaintainer(getSupportFragmentManager(), TAG);
        }

        if (MVPStateMaintainer.firstTimeIn()) {
            initialisePresenterForTheFirstTime();
        } else {
            reinitialisePresenter();
        }
    }

    private void initialisePresenterForTheFirstTime() {
        presenter = initialisePresenter();
        if (savedInstanceState != null) {
            presenter.onRestoreInstanceState(savedInstanceState);
        }
        MVPStateMaintainer.put(presenterTAG, presenter);
    }

    private void reinitialisePresenter() {
        presenter = MVPStateMaintainer.get(presenterTAG);

        if (presenter == null) {
            Log.d(TAG, "Reinitialising presenter!");
            initialisePresenterForTheFirstTime();
        } else {
            presenter.onConfigurationChanged(viewOperations);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

    // This is meant for the child of this class to call setupPresenter()
    protected abstract void callSetupPresenter();
    // This is meant for the child of this class to initialise and return Presenter
    protected abstract P initialisePresenter();
    protected P getPresenter() {
        return presenter;
    }
}
