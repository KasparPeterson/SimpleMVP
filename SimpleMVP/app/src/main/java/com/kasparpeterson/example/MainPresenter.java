package com.kasparpeterson.example;

import android.support.annotation.NonNull;

/**
 * Created by kaspar on 02/12/2016.
 */

public class MainPresenter extends MainMVP.PresenterViewOperations
        implements MainMVP.PresenterModelOperations {

    public MainPresenter(MainMVP.ViewOperations view) {
        super(view);
    }

    @NonNull
    @Override
    protected MainMVP.ModelOperations initialiseModel() {
        return new MainModel(this);
    }

    @Override
    public void onSaveDetailsSuccessful() {

    }

    @Override
    public void onSaveDetailsFailed() {

    }

    @Override
    void onContinue(String firstName, String lastName) {
        if (getView() != null) {
            boolean isValid = true;

            if (Utils.isStringEmpty(firstName)) {
                getView().showFirstNameError();
                isValid = false;
            }

            if (Utils.isStringEmpty(lastName)) {
                getView().showLastNameError();
                isValid = false;
            }

            if (isValid) {
                getView().showSuccess();
            }
        }
    }
}
