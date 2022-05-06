package com.ederbaum.urlshortener.filestorage.util;

import java.util.concurrent.ThreadLocalRandom;

public final class RandomUtil {

    private static final char[] CHARS = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9'};


    public static String randomString(final int length) {
        final StringBuilder b = new StringBuilder();
        for (int i = 0; i < length; i++) {
            b.append(CHARS[ThreadLocalRandom.current().nextInt(CHARS.length)]);
        }
        return b.toString();
    }
}
