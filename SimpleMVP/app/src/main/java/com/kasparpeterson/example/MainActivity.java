package com.kasparpeterson.example;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.kasparpeterson.simplemvp.MVPBaseActivity;

public class MainActivity extends MVPBaseActivity<MainContract.PresenterViewOperations, MainContract.ViewOperations>
        implements MainContract.ViewOperations {

    private EditText firstNameEditText;
    private EditText lastNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameEditText = (EditText) findViewById(R.id.first_name_edit_text);
        lastNameEditText = (EditText) findViewById(R.id.last_name_edit_text);
        findViewById(R.id.continue_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onContinue(firstNameEditText.getText().toString(),
                        lastNameEditText.getText().toString());
            }
        });
    }

    @Override
    protected MainContract.ViewOperations getView() {
        return this;
    }

    @Override
    protected MainContract.PresenterViewOperations createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void showFirstNameError() {
        // TODO:
    }

    @Override
    public void showLastNameError() {
        // TODO:
    }

    @Override
    public void showSuccess() {
        // TODO:
    }
}
