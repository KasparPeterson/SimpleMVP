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
        onView(new ViewAction<MainMVP.ViewOperations>() {
            @Override
            public void onAction(MainMVP.ViewOperations view) {
                view.showSuccess();
            }
        });
    }

    @Override
    public void onSaveDetailsFailed() {
        onView(new ViewAction<MainMVP.ViewOperations>() {
            @Override
            public void onAction(MainMVP.ViewOperations view) {
                view.showFirstNameError();
                view.showLastNameError();
            }
        });
    }

    @Override
    void onContinue(final String firstName, final String lastName) {
        onView(new ViewAction<MainMVP.ViewOperations>() {
            @Override
            public void onAction(MainMVP.ViewOperations view) {
                boolean isValid = true;

                if (Utils.isStringEmpty(firstName) || firstName.length() < 2) {
                    view.showFirstNameError();
                    isValid = false;
                }

                if (Utils.isStringEmpty(lastName) || lastName.length() < 2) {
                    view.showLastNameError();
                    isValid = false;
                }

                if (isValid) {
                    getModel().saveDetails(firstName, lastName);
                }
            }
        });
    }
}
