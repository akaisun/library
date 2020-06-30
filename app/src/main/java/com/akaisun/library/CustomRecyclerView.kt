package com.akaisun.library

import android.content.Context
import android.util.AttributeSet
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

    private var decor: ItemDecoration? = null
    private var orientation = LinearLayoutManager.VERTICAL

    private fun init(attrs: AttributeSet?, defStyle: Int) {

        val a = context.obtainStyledAttributes(attrs, R.styleable.CustomRecyclerView, defStyle, 0)
        orientation = a.getInt(R.styleable.CustomRecyclerView_android_orientation, LinearLayoutManager.VERTICAL)

        layoutManager = when(orientation) {
            LinearLayoutManager.HORIZONTAL -> LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            else -> LinearLayoutManager(context)
        }
        itemAnimator?.let { if(it is SimpleItemAnimator) it.supportsChangeAnimations = false }
        setHasFixedSize(true)
        setLineColor(context.getColor(R.color.list_decoration_color))
    }

    fun setLineColor(color: Int) {
        decor?.let { removeItemDecoration(it) }
        decor = DividerItemDecoration(context, orientation).also {
            it.drawable?.setTint(color)
        }.apply {
            addItemDecoration(this)
        }
    }
}