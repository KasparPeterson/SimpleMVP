package com.kasparpeterson.example;

import com.kasparpeterson.simplemvp.MVPBasePresenter;
import com.kasparpeterson.simplemvp.MVPBaseView;

/**
 * Created by kaspar on 02/12/2016.
 */
interface MainContract {

    // Presenter -> View
    interface ViewOperations extends MVPBaseView {
        void showFirstNameError();
        void showLastNameError();
        void showSuccess();
    }

    // View -> Presenter
    abstract class PresenterViewOperations extends MVPBasePresenter<ViewOperations> {
        abstract void onContinue(String firstName, String lastName);
    }
}
