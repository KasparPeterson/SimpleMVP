package ${packageName}

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kasparpeterson.simplemvp.MVPBaseFragment;

class ${className}Fragment : MVPBaseFragment<${className}Contract.Presenter, ${className}Contract.View>(),
        ${className}Contract.View {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_${classToResource(className)}, container, false)
    }
    
    override fun getFragmentView(): ${className}Contract.View {
        return this
    }

    override fun createPresenter(): ${className}Contract.Presenter {
        return ${className}Presenter()
    }
}