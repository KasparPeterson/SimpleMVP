package com.kasparpeterson.example.settings;

import android.os.Bundle;

import com.kasparpeterson.example.R;
import com.kasparpeterson.simplemvp.MVPBaseActivity;

public class SettingsActivity extends MVPBaseActivity<SettingsContract.Presenter, SettingsContract.View>
        implements SettingsContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    @Override
    protected SettingsContract.View getView() {
        return this;
    }

    @Override
    protected SettingsContract.Presenter createPresenter() {
        return new SettingsPresenter();
    }
}
