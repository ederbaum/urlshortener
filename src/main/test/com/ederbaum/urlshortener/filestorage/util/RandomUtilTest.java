package com.ederbaum.urlshortener.filestorage.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomUtilTest {

    private void testRandomStringLength(int length) {
        String randomString = RandomUtil.randomString(length);
        Assertions.assertEquals(length, randomString.length());
    }

    @Test
    public void testRandomStringLength() {
        testRandomStringLength(1);
        testRandomStringLength(2);
        testRandomStringLength(10);
        testRandomStringLength(15);
        testRandomStringLength(30);
    }
}
