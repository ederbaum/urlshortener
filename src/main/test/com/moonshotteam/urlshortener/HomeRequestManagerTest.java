package com.moonshotteam.urlshortener;

import com.moonshotteam.urlshortener.model.HomeData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class HomeRequestManagerTest {

    private final HomeRequestManager manager = new HomeRequestManager();

    private void assertNull(Object... data){
        for(Object d : data){
            Assertions.assertNull(d);
        }
    }

    @Test
    public void testNUllUrl() {
        HomeData data = manager.getHomeData((String) null);
        assertNull(data.getShortUrl(), data.getOriginalUrl(), data.getError());
    }

    @Test
    public void testNoProtocolUrl() {
        String url = "www.google.com";
        HomeData data = manager.getHomeData(url);
        Assertions.assertEquals(data.getOriginalUrl(), "http://" + url);
        Assertions.assertNotNull(data.getShortUrl());
        assertNull(data.getError());
    }

    private void testNormalUrl(String url) {
        HomeData data = manager.getHomeData(url);
        Assertions.assertEquals(data.getOriginalUrl(), url);
        Assertions.assertNotNull(data.getShortUrl());
        assertNull(data.getError());
    }

    @Test
    public void testNormalUrl() {
        testNormalUrl("http://www.google.com");
        testNormalUrl("ftp:www.google.com");
    }


    @Test
    public void testInvalidUrl() {
        String url = "wrong url";
        HomeData data = manager.getHomeData(url);
        Assertions.assertEquals(url, data.getOriginalUrl());
        Assertions.assertNull(data.getShortUrl());
        Assertions.assertEquals("Invalid URL", data.getError());
    }
}
