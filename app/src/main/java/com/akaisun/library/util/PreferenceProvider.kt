package com.akaisun.library.util

import android.content.Context
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class PreferenceProvider(context: Context) {

    private val pref = PreferenceManager.getDefaultSharedPreferences(context)

    fun setValue(key: String, value: Any?) {
        when (value) {
            is String? -> pref.edit { putString(key, value) }
            is Int -> pref.edit { putInt(key, value) }
            is Boolean -> pref.edit { putBoolean(key, value) }
            is Float -> pref.edit { putFloat(key, value) }
            is Long -> pref.edit { putLong(key, value) }
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }

    @Suppress("IMPLICIT_CAST_TO_ANY")
    fun<Any> get(key: String, defaultValue: Any): Any {
        return when (defaultValue) {
            is String -> pref.getString(key, defaultValue)
            is Int -> pref.getInt(key, defaultValue)
            is Boolean -> pref.getBoolean(key, defaultValue)
            is Float -> pref.getFloat(key, defaultValue)
            is Long -> pref.getLong(key, defaultValue)
            else -> throw UnsupportedOperationException("Not yet implemented")
        } as Any
    }
}

