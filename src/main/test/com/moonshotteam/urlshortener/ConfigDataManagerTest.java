package com.moonshotteam.urlshortener;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ConfigDataManagerTest {

    @Test
    public void testGetUrlShortener() {
        UrlShortener shortener = ConfigDataManager.getUrlShortener();
        Assertions.assertNotNull(shortener);
    }


}
