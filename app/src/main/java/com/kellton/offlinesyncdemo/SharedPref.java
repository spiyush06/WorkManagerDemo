package com.kellton.offlinesyncdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class SharedPref {

    public static final String MyPREFERENCES = "MyPrefs" ;
    private static final String PREF_MESSAGE = "pref_message";


    public static void saveMessage(Context pContext, String message) {
        SharedPreferences sharedpreferences = pContext.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(PREF_MESSAGE, message);
        Toast.makeText(pContext, "Saved", Toast.LENGTH_SHORT).show();
        editor.apply();
    }


    public static String getMessage(Context pContext)
    {
        SharedPreferences sharedpreferences = pContext.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String restoredText = sharedpreferences.getString(PREF_MESSAGE, null);
        return restoredText;
    }

    public static void removeMessage(Context pContext)
    {
        SharedPreferences sharedpreferences = pContext.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        sharedpreferences.edit().remove(PREF_MESSAGE).apply();
    }
}
