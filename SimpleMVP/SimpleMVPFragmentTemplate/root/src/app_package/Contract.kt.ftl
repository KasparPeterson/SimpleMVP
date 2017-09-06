package ${packageName}

import com.kasparpeterson.simplemvp.MVPBasePresenter
import com.kasparpeterson.simplemvp.MVPBaseView

interface ${className}Contract {

    interface View: MVPBaseView

    abstract class Presenter: MVPBasePresenter<View>()
}
