package com.moonshotteam.urlshortener;

import com.moonshotteam.urlshortener.model.HomeData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomeRequestManagerTest {

    private final HomeRequestManager manager = new HomeRequestManager();

    @Test
    public void testNullUrl() {
        HomeData data = manager.getHomeData((String) null);
        assertNull(data.getShortUrl(), data.getInputUrl(), data.getError());
    }

    @Test
    public void testUrlWithoutHttpProtocol() {
        String url = "www.google.com";
        HomeData data = testNormalUrl(url);
        Assertions.assertEquals(data.getInputUrl(), "http://" + url);
    }

    @Test
    public void testNormalUrl() {
        testNormalUrlWithSameInput("http://www.google.com");
        testNormalUrlWithSameInput("ftp:www.google.com");
    }


    @Test
    public void testInvalidUrl() {
        String url = "wrong url";
        HomeData data = manager.getHomeData(url);
        Assertions.assertEquals(url, data.getInputUrl());
        Assertions.assertNull(data.getShortUrl());
        Assertions.assertEquals("Invalid URL", data.getError());
        Assertions.assertTrue(data.hasError());
    }


    private void assertNull(Object... data){
        for(Object d : data){
            Assertions.assertNull(d);
        }
    }

    private HomeData testNormalUrl(String url) {
        HomeData data = manager.getHomeData(url);
        Assertions.assertNotNull(data.getShortUrl());
        Assertions.assertFalse(data.hasError());
        Assertions.assertTrue(data.hasShortUrl());
        Assertions.assertTrue(data.hasInputUrl());
        assertNull(data.getError());
        return data;
    }

    private void testNormalUrlWithSameInput(String url) {
        HomeData data = testNormalUrl(url);
        Assertions.assertEquals(data.getInputUrl(), url);
    }
}
