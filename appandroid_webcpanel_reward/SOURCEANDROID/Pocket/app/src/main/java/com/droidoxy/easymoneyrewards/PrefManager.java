/**
 * Managing Preferences.. ie., 
 *
 * First Time Launch and Daily Checkin
 * 
 * @author DroidOXY
 */

package com.droidoxy.easymoneyrewards;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by yashDev on 05/05/16.
 */
public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "yashDev-welcome";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String IS_GET = "IsGet";
    private static final String IS_CHECKIN = "IsCheckin";
    private static final String IS_USER_ID = "IsUserId";
	
    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void setGet(boolean isGet24) {
        editor.putBoolean(IS_GET, isGet24);
        editor.commit();
    }

    public boolean isGet() {
        return pref.getBoolean(IS_GET, true);
    }

    public void setCheckin(boolean isCheckin) {
        editor.putBoolean(IS_CHECKIN, isCheckin);
        editor.commit();
    }

    public boolean isCheckin() {
        return pref.getBoolean(IS_CHECKIN, true);
    }

    public void setUserId(boolean isUserId) {
        editor.putBoolean(IS_USER_ID, isUserId);
        editor.commit();
    }

    public boolean isUserId() {
        return pref.getBoolean(IS_USER_ID, true);
    }


    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }


}