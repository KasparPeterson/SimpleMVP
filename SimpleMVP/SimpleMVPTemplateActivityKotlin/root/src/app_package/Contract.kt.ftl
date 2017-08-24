package ${packageName}

import com.kasparpeterson.simplemvp.MVPBasePresenter
import com.kasparpeterson.simplemvp.MVPBaseView

interface ${className}Contract {

	<#if !includeView>
    	interface View: MVPBaseView
    </#if>
	<#if includeView>
		interface View: MVPBaseView {
			fun show(state: ${className}ViewState)
		}
    </#if>

    abstract class Presenter: MVPBasePresenter<View>()
}
