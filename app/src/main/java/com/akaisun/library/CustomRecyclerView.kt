package com.akaisun.library

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator

class CustomRecyclerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : RecyclerView(context, attrs) {

    init {
        init()
    }

    private fun init() {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context, VERTICAL, false)
        val itemDecoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL).also {
            it.drawable?.setTint(context.getColor(R.color.list_decoration_color))
        }
        addItemDecoration(itemDecoration)

        itemAnimator?.let {
            if(it is SimpleItemAnimator) it.supportsChangeAnimations = false
        }
    }

}