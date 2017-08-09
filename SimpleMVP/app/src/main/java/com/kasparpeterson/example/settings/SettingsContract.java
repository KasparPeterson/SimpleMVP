package com.kasparpeterson.example.settings;

import com.kasparpeterson.simplemvp.MVPBasePresenter;
import com.kasparpeterson.simplemvp.MVPBaseView;

interface SettingsContract {

    // Presenter -> View
    interface View extends MVPBaseView {

    }

    // View -> Presenter
    abstract class Presenter extends MVPBasePresenter<View> {

    }
}
