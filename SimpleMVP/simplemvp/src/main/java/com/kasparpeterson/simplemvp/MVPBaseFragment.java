package com.kasparpeterson.simplemvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by Eerik on 14/08/17.
 */

public abstract class MVPBaseFragment<P extends MVPBasePresenter, V extends MVPBaseView>
        extends Fragment implements MVPBaseView {

    private String presenterTag;
    private String TAG = "fragment_tag";
    private MVPStateMaintainer MVPStateMaintainer;
    private P presenter;

    private boolean isJustCreated;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupPresenter();
        isJustCreated = true;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (isJustCreated && presenter != null) {
            presenter.onViewAttached();
        }
        isJustCreated = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null)
            presenter.onDestory(false);
    }

    @Override
    public void handleOnBackPressed() {
        getActivity().onBackPressed();
    }

    protected void setupPresenter() {
        createStateMaintainerIfNecessary();
        initialisePresenter();
    }

    private void createStateMaintainerIfNecessary() {
        if (MVPStateMaintainer == null)
            MVPStateMaintainer = new MVPStateMaintainer(getFragmentManager(), TAG);
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
        presenter.setView(getFragmentView());
        MVPStateMaintainer.initialiseStateMaintainer();
        presenterTag = presenter.getClass().toString();
        MVPStateMaintainer.put(presenterTag, presenter);
    }

    @SuppressWarnings("unchecked")
    private void reinitialisePresenter() {
        presenter = MVPStateMaintainer.get(presenterTag);
        if (presenter == null)
            initialisePresenterForTheFirstTime();
        else
            presenter.setView(getFragmentView());
    }

    protected P getPresenter() {
        return presenter;
    }

    protected abstract V getFragmentView();
    protected abstract P createPresenter();

}
