package com.akaisun.library

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

import java.io.PrintWriter
import java.io.StringWriter

class CustomViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

    override fun onTouchEvent(event: MotionEvent): Boolean {
        try {
            return super.onTouchEvent(event)
        } catch (e: Exception) {
            val sw = StringWriter()
            e.printStackTrace(PrintWriter(sw))
        }

        return false
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        try {
            return super.onInterceptTouchEvent(event)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return false
    }
}