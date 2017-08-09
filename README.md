# SimpleMVP
Small Android library to help you achieve MVP (Model - View - Presenter) for your Android projects.

### Usage

Create Contract:
```kotlin
interface MyCoolContract {

    interface View: MVPBaseView {
        fun show(state: MyCoolViewState)
    }

    abstract class Presenter: MVPBasePresenter<View>() {
        abstract fun onCoolButtonClicked()
    }

}
```

Create Presenter:
```kotlin
class MyCoolPresenter: MyCoolContract.Presenter() {

    override fun onCoolButtonClicked() {
        // do some business
        onView { it.show(coolState()) }
    }

}
```

Create Activity:
```kotlin
class MyCoolActivity: BaseActivity<MyCoolContract.Presenter, MyCoolContract.View>(),
        MyCoolContract.View {

    override fun show(state: MyCoolViewState) {
        // show your new view state
    }
    
    override fun getView(): MyCoolContract.View {
        return this
    }
    
    override fun createPresenter(): MyCoolContract.Presenter {
        return MyCoolPresenter()
    }

}
```
