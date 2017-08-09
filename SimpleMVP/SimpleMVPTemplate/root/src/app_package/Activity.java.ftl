package ${packageName};

import android.os.Bundle;

import com.kasparpeterson.example.R;
import com.kasparpeterson.simplemvp.MVPBaseActivity;

public class ${className}Activity extends MVPBaseActivity<${className}Contract.Presenter, ${className}Contract.View>
        implements ${className}Contract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_${classToResource(className)});
    }

    @Override
    protected ${className}Contract.View getView() {
        return this;
    }

    @Override
    protected ${className}Contract.Presenter createPresenter() {
        return new ${className}Presenter();
    }
}
