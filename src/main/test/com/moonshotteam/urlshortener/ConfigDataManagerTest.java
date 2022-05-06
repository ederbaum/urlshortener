package com.moonshotteam.urlshortener;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ConfigDataManagerTest {

    @Test
    public void testGetUrlRoot()  {
        Assertions.assertNotNull(ConfigDataManager.getUrlRoot());
    }

    @Test
    public void testGetUrlShortener() {
        Assertions.assertNotNull(ConfigDataManager.getUrlShortener());
    }


}
