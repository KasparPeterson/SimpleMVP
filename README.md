# SimpleMVP
Small Android library to help you achieve MVP (Model - View - Presenter) for your Android projects. State maintaining Presenter can be added to Activity or Fragment.

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
class MyCoolActivity: MVPBaseActivity<MyCoolContract.Presenter, MyCoolContract.View>(),
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

Or create Fragment:
```kotlin
class MyCoolFragment : MVPBaseFragment<MyCoolContract.Presenter, MyCoolContract.View>(),
        MyCoolContract.View {
        
    override fun show(state: MyCoolViewState) {
        // show your new view state
    }

    override fun getFragmentView(): MyCoolContract.View {
        return this
    }

    override fun createPresenter(): MyCoolContract.Presenter {
        return MyCoolPresenter()
    }
    
}
```

### Templates for Android Studio

1. copy entire folder 'SimpleMVPTemplateKotlin' to /Applications/Android Studio.app/Contents/plugins/android/lib/templates/other/
2. Restart AS
3. Create package if needed (e.g. "settings")
4. Right click on package -> New -> Other -> SimpleMVP Activity
5. Enter name (e.g. "Settings")
6. Finish

There is also template for Java as well named 'SimpleMVPTemplate

### Download
```
compile 'com.kasparpeterson:simplemvp:2.3.0'
```
