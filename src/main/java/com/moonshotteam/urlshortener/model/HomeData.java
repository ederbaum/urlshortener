package com.moonshotteam.urlshortener.model;

import java.net.URL;

/**
 * Data to be sent to the client in the Home page
 */
public final class HomeData  {
    private final URL shortUrl;
    private final String error;
    private final String inputUrl;

    private HomeData(final String inputUrl, final URL shortUrl, final String error) {
        this.shortUrl = shortUrl;
        this.error = error;
        this.inputUrl = inputUrl;
    }

    public HomeData(ShortenResult result) {
        this(result.getInputUrl(), result.getShortUrl(),null);
    }

    public HomeData(final String originalUrl, final String error) {
        this(originalUrl, null, error);
    }

    public URL getShortUrl() {
        return shortUrl;
    }

    public String getError() {
        return error;
    }

    public boolean hasError() {
        return error != null;
    }

    public boolean hasShortUrl() {
        return shortUrl != null;
    }

    public boolean hasInputUrl() {
        return inputUrl != null;
    }

    public String getInputUrl() {
        return inputUrl;
    }
}
