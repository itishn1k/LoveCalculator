package com.example.lovecalculator.data

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref(context: Context) {

    private val pref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)

    //onboard
    fun setOnBoardingSeen() {
        pref.edit().putBoolean(ON_BOARDING_SEEN, true).apply()
    }

    fun isOnBoardingSeen(): Boolean {
        return pref.getBoolean(ON_BOARDING_SEEN, false)
    }

    companion object {
        private const val ON_BOARDING_SEEN = "is_seen"

        private const val PREF_NAME = "love"
    }
}
