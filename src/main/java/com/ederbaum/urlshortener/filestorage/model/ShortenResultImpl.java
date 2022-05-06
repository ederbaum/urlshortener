package com.ederbaum.urlshortener.filestorage.model;

import com.moonshotteam.urlshortener.model.ShortenResult;

import java.net.URL;

public class ShortenResultImpl implements ShortenResult {
    private final URL shortUrl;
    private final String inputUrl;

    public ShortenResultImpl(final URL shortUrl, final String inputUrl) {
        this.shortUrl = shortUrl;
        this.inputUrl = inputUrl;
    }

    @Override
    public URL getShortUrl() {
        return shortUrl;
    }

    @Override
    public String getInputUrl() {
        return inputUrl;
    }
}
