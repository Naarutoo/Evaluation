package com.example.evaluation;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    public static final String package_name = "saurabh.sharma";

    public static SharedPreferences preferences(Context context) {
        return context.getSharedPreferences(package_name, Context.MODE_PRIVATE);

    }

    public static void writeStringToPreference(Context context, String key, String value) {
        SharedPreferences.Editor editor = preferences(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void writeBooleanToPreference(Context context, String key, Boolean value) {
        SharedPreferences.Editor editor = preferences(context).edit();
        editor.putBoolean(key, value);
        editor.apply();

    }

    public static String getStringFromPreference(Context context, String key) {
        return preferences(context).getString(key, null);
    }

    public static boolean getBooleanFromPreference(Context context, String key) {
        return preferences(context).getBoolean(key, false);
    }
}
