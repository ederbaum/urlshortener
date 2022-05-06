package com.moonshotteam.urlshortener;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *  Interface to shorten and expand urls
 */
public interface UrlShortener {
    URL shorten(URL url) throws IOException, URISyntaxException;
    URL getOriginalURL(String url) throws IOException;
}
