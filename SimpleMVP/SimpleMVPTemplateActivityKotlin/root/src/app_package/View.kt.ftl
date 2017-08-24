package ${packageName}

import android.content.Context
import android.widget.FrameLayout

class ${className}View(context: Context): FrameLayout(context) {

    init {
        inflate(context, R.layout.${classToResource(className)}_view, this)
    }

    fun show(state: ${className}ViewState) {

    }

}