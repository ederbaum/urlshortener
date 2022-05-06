package com.moonshotteam.urlshortener;

import com.moonshotteam.urlshortener.model.ShortenResult;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *  Interface to shorten and expand urls
 */
public interface UrlShortener {
    ShortenResult shorten(String url) throws IOException, URISyntaxException;
    URL getOriginalURL(String uri) throws IOException;
}
