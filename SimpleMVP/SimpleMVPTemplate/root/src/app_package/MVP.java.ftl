package ${packageName};

import com.kasparpeterson.simplemvp.MVPBasePresenter;
import com.kasparpeterson.simplemvp.MVPBaseView;

interface ${className}MVP {

    // Presenter -> View
    interface ViewOperations extends MVPBaseView {
        void showFirstNameError();
        void showLastNameError();
    }

    // View -> Presenter
    abstract class PresenterViewOperations extends MVPBasePresenter<ViewOperations> {
        abstract void onContinue(String firstName, String lastName);
    }
}
