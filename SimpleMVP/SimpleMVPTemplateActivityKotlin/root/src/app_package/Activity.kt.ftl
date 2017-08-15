package ${packageName}
<#if includeLayout>
    import android.os.Bundle
</#if>

import com.kasparpeterson.simplemvp.MVPBaseActivity

class ${className}Activity : MVPBaseActivity<${className}Contract.Presenter, ${className}Contract.View>(),
        ${className}Contract.View {
    <#if includeLayout>

    	override fun onCreate(savedInstanceState: Bundle?) {
        	super.onCreate(savedInstanceState)
        	setContentView(R.layout.activity_${classToResource(className)})
    	}
    </#if>

    override fun getView(): ${className}Contract.View {
        return this
    }

    override fun createPresenter(): ${className}Contract.Presenter {
        return ${className}Presenter()
    }
}
