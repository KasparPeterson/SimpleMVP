package ${packageName}
<#if includeView>
    import android.os.Bundle
</#if>

import com.kasparpeterson.simplemvp.MVPBaseActivity

class ${className}Activity : MVPBaseActivity<${className}Contract.Presenter, ${className}Contract.View>(),
        ${className}Contract.View {
    <#if includeView>

        private lateinit var view: ${className}View

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            view = ${className}View(this)
            setContentView(view)
        }

        override fun show(state: ${className}ViewState) {
            view.show(state)
        }
    </#if>

    override fun getView(): ${className}Contract.View = this

    override fun createPresenter(): ${className}Contract.Presenter = ${className}Presenter()
}
