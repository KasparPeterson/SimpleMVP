package ${packageName};

import com.kasparpeterson.simplemvp.MVPBasePresenter;
import com.kasparpeterson.simplemvp.MVPBaseView;

interface ${className}Contract {

    // Presenter -> View
    interface View extends MVPBaseView {

    }

    // View -> Presenter
    abstract class Presenter extends MVPBasePresenter<View> {

    }
}
