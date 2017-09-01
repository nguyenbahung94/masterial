package com.example.nbhung.masterial.GetTokens;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by nbhung on 8/29/2017.
 */

public class Prefs {
    private static Prefs staticPrefs;
    private final String SHARED_PREFERENCES_NAME = "app_name_pref";
    //Token key
    private final String tokenKey = "token_key";
    private SharedPreferences prefs;

    /**
     * Contractor.
     *
     * @param ctx : application context.
     */
    private Prefs(Context ctx) {
        prefs = ctx.getSharedPreferences(SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
    }

    /**
     * @param ctx : application context.
     * @return Instance of Prefs.
     */
    public static Prefs getInstance(Context ctx) {
        if (staticPrefs == null) {
            synchronized (Prefs.class) {
                if (staticPrefs == null) {
                    staticPrefs = new Prefs(ctx.getApplicationContext());
                }
            }
        }
        return staticPrefs;
    }

    /**
     * @return token or null.
     */
    public String getToken() {
        return prefs.getString(tokenKey, null);
    }

    /**
     * @param token: user token. The method will remove token from share pref if it's null.
     */
    public void saveToken(String token) {
        prefs.edit().putString(tokenKey, token).apply();
    }
}
