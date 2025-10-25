package com.example.lesson_8_test.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.lesson_8_test.core.AppKey

class Pref(context: Context) {

    private val pref: SharedPreferences =
        context.getSharedPreferences(AppKey.PREF_KEY, Context.MODE_PRIVATE)

    fun savePrev(value: Int){
        pref.edit(){
            putInt(AppKey.VALUE_KEY, value)
        }
    }

    fun getPrev(): Int{
        return pref.getInt(AppKey.VALUE_KEY, 0)
    }
}