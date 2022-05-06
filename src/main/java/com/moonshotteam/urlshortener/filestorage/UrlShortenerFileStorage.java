package com.moonshotteam.urlshortener.filestorage;

import com.moonshotteam.urlshortener.ConfigDataManager;
import com.moonshotteam.urlshortener.UrlShortener;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Responsible for writing data to local files using the FileStorageDAO
 */
public final class UrlShortenerFileStorage implements UrlShortener {

    private final FileStorageDAO dao = new FileStorageDAO();
    private static final String URL_ROOT;
    private static final String URL_HOST;

    static {
        URL_ROOT = ConfigDataManager.getUrlRoot();
        URL_HOST = getUrlHost();
    }

    @Override
    public URL shorten(final URL url) throws IOException, URISyntaxException {
        // Is our host, no need to shorten
        if(url.getHost().equals(URL_HOST)){
            return url;
        }
        // Verify if url is valid
        url.toURI();
        final String key = dao.persist(url);
        return getURLFromKey(key);
    }


    @Override
    public URL getOriginalURL(final String uri) throws IOException {
        final String key = uri.substring(uri.lastIndexOf("/") + 1);
        final String url = dao.getURLByKey(key);
        if (url != null) {
            return new URL(url);
        }
        return null;
    }

    private URL getURLFromKey(final String key) throws MalformedURLException {
        return new URL(URL_ROOT + key);
    }

    private static String getUrlHost(){
        try {
            return new URL(URL_ROOT).getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return "";
    }

}
