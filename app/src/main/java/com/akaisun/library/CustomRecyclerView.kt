package com.akaisun.library

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator

class CustomRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : RecyclerView(context, attrs, defStyle) {

    init {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        setHasFixedSize(true)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomRecyclerView, defStyle, 0)
        val orientation = typedArray.getInt(R.styleable.CustomRecyclerView_android_orientation, LinearLayoutManager.VERTICAL)
        val itemDecoration = DividerItemDecoration(context, orientation).also {
            it.drawable?.setTint(context.getColor(R.color.list_decoration_color))
        }
        addItemDecoration(itemDecoration)
        itemAnimator?.let {
            if(it is SimpleItemAnimator) it.supportsChangeAnimations = false
        }
    }
}