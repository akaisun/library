package com.akaisun.library

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.akaisun.library.databinding.WidgetProgressBinding

class ProgressContainer @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    private val binding: WidgetProgressBinding by lazy {
        WidgetProgressBinding.inflate(LayoutInflater.from(context), this)
    }

    fun show() {
        binding.widgetProgress.show()
    }

    fun hide() {
        binding.widgetProgress.hide()
    }
}