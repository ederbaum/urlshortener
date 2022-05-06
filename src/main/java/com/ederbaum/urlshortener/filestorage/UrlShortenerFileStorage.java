package com.ederbaum.urlshortener.filestorage;

import com.ederbaum.urlshortener.filestorage.model.ShortenResultImpl;
import com.moonshotteam.urlshortener.ConfigDataManager;
import com.moonshotteam.urlshortener.UrlShortener;
import com.moonshotteam.urlshortener.model.ShortenResult;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Responsible for writing data to local files using the FileStorageDAO
 */
public final class UrlShortenerFileStorage implements UrlShortener {

    private final FileStorageDAO dao = new FileStorageDAO();
    private static final String URL_ROOT_PROPERTY_NAME = "url.root";
    public static final String URL_ROOT;
    private static final String URL_HOST;
    private static final String DEFAULT_PROTOCOL = "http:";

    static {
        URL_ROOT = ConfigDataManager.getProperty(URL_ROOT_PROPERTY_NAME);
        URL_HOST = getUrlHost();
    }

    @Override
    public ShortenResult shorten(String inputURL) throws IOException, URISyntaxException {
        inputURL = ensureUrlProtocol(inputURL);
        final URL url = new URL(inputURL);
        // Verify if url is valid
        url.toURI();
        // If Is our host, no need to shorten
        if(isOurHost(url)) {
            return new ShortenResultImpl(url, inputURL);
        }
        final String key = dao.persist(url);
        final URL shortened = buildURLFromKey(key);
        return new ShortenResultImpl(shortened, inputURL);
    }

    private String ensureUrlProtocol(String url) {
        url = url.trim();
        if(!url.matches("(http|ftp|ssh).*")){
            url = DEFAULT_PROTOCOL + (url.startsWith("//") ? url : "//" + url);
        }
        return url;
    }

    /**
     * Verify if url is our host.
     * We consider that the url is our host if it starts with our url root.
     * This is to avoid possible infinite loops.
     * @param url The url to verify
     * @return true if url is our host
     */
    private boolean isOurHost(final URL url) {
        return url.getHost().equals(URL_HOST);
    }


    @Override
    public URL getOriginalURL(final String uri) throws IOException {
        final String key = getKeyFromUri(uri);
        final String url = dao.findOriginalURLByKey(key);
        if (url != null) {
            return new URL(url);
        }
        return null;
    }

    private String getKeyFromUri(final String uri) {
        return uri.substring(uri.lastIndexOf("/") + 1);
    }

    private URL buildURLFromKey(final String key) throws MalformedURLException {
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
