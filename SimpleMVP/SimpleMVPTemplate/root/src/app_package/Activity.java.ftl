package ${packageName};

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.kasparpeterson.example.R;
import com.kasparpeterson.simplemvp.MVPBaseActivity;

public class ${className}Activity extends MVPBaseActivity<${className}MVP.PresenterViewOperations, ${className}MVP.ViewOperations>
        implements ${className}MVP.ViewOperations {

    private EditText firstNameEditText;
    private EditText lastNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_${classToResource(className)});

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
    protected ${className}MVP.ViewOperations getView() {
        return this;
    }

    @Override
    protected ${className}MVP.PresenterViewOperations createPresenter() {
        return new ${className}Presenter();
    }

    @Override
    public void showFirstNameError() {
        // TODO:
    }

    @Override
    public void showLastNameError() {
        // TODO:
    }
}
