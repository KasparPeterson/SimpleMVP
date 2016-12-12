package com.kasparpeterson.example;

/**
 * Created by kaspar on 02/12/2016.
 */

public class MainModel extends MainMVP.ModelOperations {

    public MainModel(MainMVP.PresenterModelOperations presenter) {
        super(presenter);
    }

    @Override
    void saveDetails(String firstName, String lastName) {

    }

    @Override
    protected void onDestroy() {

    }
}
