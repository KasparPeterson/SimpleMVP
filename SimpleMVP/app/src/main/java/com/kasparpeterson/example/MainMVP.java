package com.kasparpeterson.example;


import com.kasparpeterson.simplemvp.MVPBaseModel;
import com.kasparpeterson.simplemvp.MVPBasePresenter;
import com.kasparpeterson.simplemvp.MVPBasePresenterModelOperations;
import com.kasparpeterson.simplemvp.MVPBaseViewOperations;

/**
 * Created by kaspar on 02/12/2016.
 */
interface MainMVP {

    // Presenter -> View
    interface ViewOperations extends MVPBaseViewOperations {
        void showFirstNameError();
        void showLastNameError();
        void showSuccess();
    }

    // View -> Presenter
    abstract class PresenterViewOperations extends MVPBasePresenter<ViewOperations, ModelOperations> {

        public static final String TAG = PresenterViewOperations.class.getSimpleName();

        public PresenterViewOperations(ViewOperations view) {
            super(view);
        }

        abstract void onContinue(String firstName, String lastName);
    }

    // Model -> Presenter
    interface PresenterModelOperations extends MVPBasePresenterModelOperations {
        void onSaveDetailsSuccessful();
        void onSaveDetailsFailed();
    }

    // Presenter -> Model
    abstract class ModelOperations extends MVPBaseModel<PresenterModelOperations> {
        public ModelOperations(PresenterModelOperations presenter) {
            super(presenter);
        }

        abstract void saveDetails(String firstName, String lastName);
    }

}
