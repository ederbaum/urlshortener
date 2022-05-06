package com.ederbaum.urlshortener.filestorage;

import com.ederbaum.urlshortener.filestorage.util.IOUtil;
import com.ederbaum.urlshortener.filestorage.util.RandomUtil;
import com.moonshotteam.urlshortener.ConfigDataManager;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * DAO responsible for writing data to local files
 */
public final class FileStorageDAO {

    private static final String STORAGE_FOLDER_PROPERTY_NAME = "storage.folder.path";
    private static final String STORAGE_FILE_EXTENSION = ".txt";
    private static final int KEY_LENGTH = 6;
    private static final String STORAGE_FOLDER = ConfigDataManager.getProperty(STORAGE_FOLDER_PROPERTY_NAME);

    public String persist(URL url) throws IOException {
        final String key = createNewKey();
        IOUtil.writeFile(getFileFromKey(key), url.toString());
        return key;
    }

    public String findOriginalURLByKey(final String key) throws IOException {
        if (isValidKey(key)) {
            final File file = getFileFromKey(key);
            if (file.exists()) {
                return IOUtil.readFile(file);
            }
        }
        return null;
    }

    private String createNewKey() {
        String key = RandomUtil.randomString(KEY_LENGTH);
        if (keyExists(key)) {
            key = createNewKey();
        }
        return key;
    }


    public boolean isValidKey(final String key) {
        return key.length() == KEY_LENGTH && key.matches("[a-zA-Z0-9]*");
    }

    private File getFileFromKey(final String key) {
        return new File(STORAGE_FOLDER + key + STORAGE_FILE_EXTENSION);
    }



    private boolean keyExists(final String key) {
        return getFileFromKey(key).exists();
    }
}
