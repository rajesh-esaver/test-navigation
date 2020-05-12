package com.esaver.navigationsample;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * File used to store data in SharedPreferences.
 */
public class MySharedPrefUtil {

    private final SharedPreferences sharedPreferences;

    public MySharedPrefUtil(Context context) {
        sharedPreferences = context.getSharedPreferences("NavigationSample_Prefs", Context.MODE_PRIVATE);
    }

    public void updateIsLoggedIn(boolean isLoggedIn) {
        sharedPreferences.edit().putBoolean("isLoggedIn", isLoggedIn).apply();
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean("isLoggedIn", false);
    }

}
