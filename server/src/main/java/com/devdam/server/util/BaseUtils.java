package com.devdam.server.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class BaseUtils {
    private static String BASE_URL;

    // Get the base url for the website that will be used in the email templates, etc.
    public static String getBaseURL(){
        if(BASE_URL == null) BASE_URL = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

        // In dev mode -> http://localhost:8080
        return BASE_URL;
    }

    public static boolean isWindowsOS(){
        String os = findOS();
        return os.contains("win");
    }

    public static boolean isMacOS(){
        String os = findOS();
        return os.contains("mac");
    }

    public static boolean isLinuxOS(){
        String os = findOS();
        return os.contains("nix") || os.contains("nux") || os.contains("aix");
    }

    private static String findOS() {
        return System.getProperty("os.name").toLowerCase();
    }
}
