package com.moonshotteam.urlshortener.model;

import java.net.URL;

public interface ShortenResult {

    URL getShortUrl();

    String getInputUrl();
}
