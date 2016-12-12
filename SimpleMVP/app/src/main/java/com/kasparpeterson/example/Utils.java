package com.kasparpeterson.example;

import android.support.annotation.Nullable;

/**
 * Created by kaspar on 02/12/2016.
 */

public class Utils {

    public static boolean isStringEmpty(@Nullable String string) {
        return string == null || string.trim().length() == 0;
    }

}
