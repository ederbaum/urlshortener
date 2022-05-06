package com.moonshotteam.urlshortener.filestorage;

import com.moonshotteam.urlshortener.ConfigDataManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlShortenerFileStorageTest {

    private final UrlShortenerFileStorage urlShortener = new UrlShortenerFileStorage();

    private void testWriteAndRead(String urlString) throws IOException, URISyntaxException {
        final URL originalURL = new URL(urlString);
        final String shortURL = urlShortener.shorten(originalURL).getPath();
        final URL storedURL = urlShortener.getOriginalURL(shortURL);

        Assertions.assertEquals(originalURL, storedURL);
    }

    @Test
    public void testRefuseToShortenMyDomainURL() throws IOException, URISyntaxException {
        final URL url = new URL(ConfigDataManager.getUrlRoot() + "test");
        URL result =  urlShortener.shorten(url);
        Assertions.assertEquals(url, result);

    }

    @Test
    public void testWriteAndRead() throws IOException, URISyntaxException {
        testWriteAndRead("http://www.google.com");
        testWriteAndRead("https://www.google.com/search?q=hello+world&sxsrf=ALiCzsb0Ibhi03lev7RbpMCCduv6RGFCqQ%3A1651760910138&source=hp&ei=Dt9zYtGzBsfL1sQP7YuXiAM&iflsig=AJiK0e8AAAAAYnPtHuOtOZX-HFgPPqqPQ7sa3hieZ75M&oq=Hello+w&gs_lcp=Cgdnd3Mtd2l6EAMYADILCAAQgAQQsQMQgwEyCAguEIAEELEDMgsIABCABBCxAxCDATILCAAQgAQQsQMQgwEyCwgAEIAEELEDEIMBMgUIABCABDIICAAQsQMQgwEyBQguEIAEMgsIABCABBCxAxCDATIFCAAQgAQ6BAgjECc6CAgAEIAEELEDOgsILhCxAxCDARDUAjoRCC4QgAQQsQMQgwEQxwEQowI6DgguEIAEELEDEMcBENEDOgsILhCABBCxAxDUAjoICC4QgAQQ1AI6CwguEIAEELEDEIMBOgsILhCABBDHARCjAjoOCC4QgAQQsQMQgwEQ1AJQAFieFGCbG2gAcAB4AIABjAGIAcQGkgEDMC43mAEAoAEB&sclient=gws-wiz");
        testWriteAndRead("http://www.google.com/test");
        testWriteAndRead("ftp:www.google.com/test");

    }
}
