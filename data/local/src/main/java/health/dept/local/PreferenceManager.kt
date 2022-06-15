package health.dept.local

import android.annotation.SuppressLint
import android.content.SharedPreferences
import com.google.gson.Gson
import javax.inject.Inject

class PreferenceManager @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    fun getBoolean(key: Key, defaultValue: Boolean = false): Boolean {
        return sharedPreferences.getBoolean(key.name, defaultValue)
    }

    fun getString(key: Key): String? {
        return sharedPreferences.getString(key.name, null)
    }

    fun getInt(key: Key): Int {
        return sharedPreferences.getInt(key.name, -1)
    }

    fun store(key: Key, data: Any, backgroundThread: Boolean = true) {
        sharedPreferences.putAny(key.name, data, backgroundThread)
    }

    enum class Key {
        TOKEN,
        //...
    }

    private fun SharedPreferences.putAny(
        key: String,
        value: Any,
        backgroundThread: Boolean = true
    ) {
        with(edit()) {
            when (value) {
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Float -> putFloat(key, value)
                is Boolean -> putBoolean(key, value)
                is Long -> putLong(key, value)
                else -> {
                    val json = Gson().toJson(value)
                    putString(key, json)
                }

            }
            @SuppressLint("ApplySharedPref")
            if (backgroundThread) apply() else commit()
        }
    }
}