package com.devdam.server.util;

import java.util.prefs.Preferences;

public class JarUtils {
    private static final Preferences jarPrefs = Preferences.userRoot();

    public static void setJarConfig(boolean built){
        // Set preferences
        jarPrefs.putBoolean("lazer_jar_already_built", built);

        save();
    }

    public static boolean isJarConfigSet(){
        // Set preferences
        return  jarPrefs.getBoolean("lazer_jar_already_built", false);
    }

    public static void removeJarConfig(){
        jarPrefs.remove("lazer_jar_already_built");

        save();
    }

    private static void save(){
        // Save preferences (optional)
        try {
            jarPrefs.flush();
        } catch (Exception ignore) {}
    }
}
