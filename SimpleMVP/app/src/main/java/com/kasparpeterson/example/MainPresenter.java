package com.kasparpeterson.example;

/**
 * Created by kaspar on 02/12/2016.
 */

public class MainPresenter extends MainMVP.PresenterViewOperations
        implements MainMVP.PresenterModelOperations {

    public MainPresenter(MainMVP.ViewOperations view, MainMVP.ModelOperations model) {
        super(view, model);
    }

    @Override
    public void onSaveDetailsSuccessful() {
        // TODO:
    }

    @Override
    public void onSaveDetailsFailed() {
        // TODO:
    }

    @Override
    void onContinue(String firstName, String lastName) {
        if (getView() != null) {
            boolean isValid = true;

            if (Utils.isStringEmpty(firstName) || firstName.length() < 2) {
                getView().showFirstNameError();
                isValid = false;
            }

            if (Utils.isStringEmpty(lastName) || lastName.length() < 2) {
                getView().showLastNameError();
                isValid = false;
            }

            if (isValid) {
                getView().showSuccess();
            }
        }
    }
}
