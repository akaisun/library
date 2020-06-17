package com.akaisun.library.preference

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.preference.Preference
import androidx.preference.PreferenceViewHolder
import com.akaisun.library.R

/**
 * Created by sun on 2018-01-06.
 */

class CustomPreferenceTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : Preference(context, attrs, defStyle) {

    private var mTitleView: TextView? = null
    private var mSummaryView: TextView? = null

    override fun onBindViewHolder(holder: PreferenceViewHolder?) {
        super.onBindViewHolder(holder)
        holder?.run {
            mTitleView = itemView.findViewById(R.id.custom_preference_text_title)
            mSummaryView = itemView.findViewById(R.id.custom_preference_text_summary)
            mTitleView?.text = title
            mSummaryView?.text = summary
        }

    }

    override fun setSummary(summary: CharSequence) {
        super.setSummary(summary)
        mSummaryView?.text = summary
    }
}
