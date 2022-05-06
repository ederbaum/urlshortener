package com.moonshotteam.urlshortener;

import com.moonshotteam.urlshortener.model.HomeData;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Receives the homepage request, and if applicable:
 * 1) shortens a received url;
 * 2) returns the data to the user;
 */
public class HomeRequestManager {


    public static final String ORIGINAL_URL_PARAM_KEY = "long-url";
    public static final String ERROR_INVALID_URL = "Invalid URL";
    public static final String ERROR_SHORTENING_URL = "Error shortening URL";
    public static final String DEFAULT_PROTOCOL = "http:";

    public HomeData getHomeData(final HttpServletRequest request)  {
        final String originalUrl = request.getParameter(ORIGINAL_URL_PARAM_KEY);
        return getHomeData(originalUrl);
    }

    public HomeData getHomeData(final String originalURL)  {
        String error = null;
        if(originalURL != null){
            final String okURL = ensureUrlProtocol(originalURL);
            try {
                final URL shortUrl = shorten(okURL);
                return new HomeData(okURL, shortUrl);
            } catch(MalformedURLException | URISyntaxException e){
                error = ERROR_INVALID_URL;
            } catch (Exception e) {
                error = ERROR_SHORTENING_URL;
                e.printStackTrace();
            }
        }
        return new HomeData(originalURL,  error);
    }

    private URL shorten(final String okURL) throws URISyntaxException, IOException {
        final URL url = new URL(okURL);
        return ConfigDataManager.getUrlShortener().shorten(url);
    }

    private String ensureUrlProtocol(String url) {
        url = url.trim();
        if(!url.matches("(http|ftp|ssh).*")){
            return DEFAULT_PROTOCOL + (url.startsWith("//") ? url : "//" + url);
        }
        return url;
    }
}
