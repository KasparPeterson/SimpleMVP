package com.kasparpeterson.example;

import android.os.Bundle;

import com.kasparpeterson.simplemvp.MVPBaseActivity;

public class MainActivity extends MVPBaseActivity<MainMVP.PresenterViewOperations>
        implements MainMVP.ViewOperations {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void callSetupPresenter() {
        setupPresenter(this, TAG, MainMVP.PresenterViewOperations.TAG);
    }

    @Override
    protected MainMVP.PresenterViewOperations initialisePresenter() {
        return new MainPresenter(this, new MainModel());
    }

    @Override
    public void showFirstNameError() {
        // TODO:
    }

    @Override
    public void showLastNameError() {
        // TODO:
    }

    @Override
    public void showSuccess() {
        // TODO:
    }
}
