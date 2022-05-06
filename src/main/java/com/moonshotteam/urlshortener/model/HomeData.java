package com.moonshotteam.urlshortener.model;

import java.net.URL;

/**
 * Data to be sent to the client in the Home page
 */
public final class HomeData {
    private final URL shortUrl;
    private final String error;
    private final String originalUrl;

    private HomeData(final String originalUrl,final URL shortUrl, final String error) {
        this.shortUrl = shortUrl;
        this.error = error;
        this.originalUrl = originalUrl;
    }

    public HomeData(final String originalUrl,final URL shortUrl) {
        this(originalUrl, shortUrl,null);
    }

    public HomeData(final String originalUrl,final String error) {
        this(originalUrl, null, error);
    }


    public URL getShortUrl() {
        return shortUrl;
    }

    public String getError() {
        return error;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }
}
