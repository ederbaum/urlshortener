package com.ederbaum.urlshortener.filestorage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

public class FileStorageDAOTest {

    private final FileStorageDAO dao = new FileStorageDAO();

    @Test
    public void testKeyIsValid() {

        Assertions.assertTrue(dao.isValidKey("abcdef"));
        Assertions.assertTrue(dao.isValidKey("abc123"));
        Assertions.assertTrue(dao.isValidKey("123456"));

        Assertions.assertFalse(dao.isValidKey("le.txt")); // . not allowed
        Assertions.assertFalse(dao.isValidKey("letxt")); // Size must be 6
        Assertions.assertFalse(dao.isValidKey("file.txt")); // . not allowed and size must be 6
        Assertions.assertFalse(dao.isValidKey("../abc")); // ../ not allowed and size must be 6
    }

    @Test
    public void testWriteURL() throws IOException {
        String key = dao.persist(new URL("http://www.google.com"));
        Assertions.assertNotNull(key);
    }

    private void testWriteAndRead(String urlString) throws IOException {
        final URL url = new URL(urlString);

        final String key = dao.persist(url);
        final String readUrl = dao.findOriginalURLByKey(key);

        Assertions.assertNotNull(readUrl);
        Assertions.assertEquals(url, new URL(readUrl));
    }

    @Test
    public void testWriteAndRead() throws IOException {
        testWriteAndRead("http://www.google.com");
        testWriteAndRead("https://www.google.com/search?q=hello+world&sxsrf=ALiCzsb0Ibhi03lev7RbpMCCduv6RGFCqQ%3A1651760910138&source=hp&ei=Dt9zYtGzBsfL1sQP7YuXiAM&iflsig=AJiK0e8AAAAAYnPtHuOtOZX-HFgPPqqPQ7sa3hieZ75M&oq=Hello+w&gs_lcp=Cgdnd3Mtd2l6EAMYADILCAAQgAQQsQMQgwEyCAguEIAEELEDMgsIABCABBCxAxCDATILCAAQgAQQsQMQgwEyCwgAEIAEELEDEIMBMgUIABCABDIICAAQsQMQgwEyBQguEIAEMgsIABCABBCxAxCDATIFCAAQgAQ6BAgjECc6CAgAEIAEELEDOgsILhCxAxCDARDUAjoRCC4QgAQQsQMQgwEQxwEQowI6DgguEIAEELEDEMcBENEDOgsILhCABBCxAxDUAjoICC4QgAQQ1AI6CwguEIAEELEDEIMBOgsILhCABBDHARCjAjoOCC4QgAQQsQMQgwEQ1AJQAFieFGCbG2gAcAB4AIABjAGIAcQGkgEDMC43mAEAoAEB&sclient=gws-wiz");
        testWriteAndRead("http://www.google.com/test");
        testWriteAndRead("ftp:www.google.com/test");
    }
}
