package com.kasparpeterson.example;

/**
 * Created by kaspar on 02/12/2016.
 */

public class MainModel extends MainMVP.ModelOperations {

    @Override
    void saveDetails(String firstName, String lastName) {
        getPresenter().onSaveDetailsSuccessful();
    }

    @Override
    protected void onDestroy() {

    }
}
