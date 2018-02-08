package com.framgia.framgia_json_httpurlconnection.utils;

/**
 * Created by framgia on 27/04/2017.
 */

public final class StringUtils {

    private StringUtils() {
        // No-op
    }

    public static boolean isBlank(String input) {
        return input.isEmpty();
    }

    public static boolean isNotBlank(String input) {
        return !isBlank(input);
    }
}
