package ${packageName};
<#if includeLayout>
    import android.os.Bundle;
</#if>

import com.kasparpeterson.simplemvp.MVPBaseActivity;

public class ${className}Activity extends MVPBaseActivity<${className}Contract.Presenter, ${className}Contract.View>
        implements ${className}Contract.View {
    <#if includeLayout>
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_${classToResource(className)});
        }
    </#if>

    @Override
    protected ${className}Contract.View getView() {
        return this;
    }

    @Override
    protected ${className}Contract.Presenter createPresenter() {
        return new ${className}Presenter();
    }
}
