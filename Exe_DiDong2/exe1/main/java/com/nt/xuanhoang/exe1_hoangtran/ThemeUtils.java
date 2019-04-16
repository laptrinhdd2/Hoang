package com.nt.xuanhoang.exe1_hoangtran;

import android.app.Activity;
import android.content.Intent;

public class ThemeUtils {
    private static int positionTheme;

    public final static int THEME_LIGHT = 0;
    public final static int THEME_BLUE = 1;

    public static void changeTheme(Activity activity, int position) {
        positionTheme = position;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public static void setTheme(Activity activity) {
        switch (positionTheme) {
            case THEME_LIGHT:
                activity.setTheme(R.style.Theme_Light);
                break;

            case THEME_BLUE:
                activity.setTheme(R.style.Theme_Blue);
                break;
            default:
                break;
        }
    }
}
