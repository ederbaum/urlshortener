package com.moonshotteam.urlshortener;

import com.moonshotteam.urlshortener.model.HomeData;
import com.moonshotteam.urlshortener.model.ShortenResult;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 * Receives the homepage request, and if applicable:
 * 1) shortens a received url;
 * 2) returns the data to the user;
 */
public class HomeRequestManager {


    private static final String ORIGINAL_URL_PARAM_KEY = "long-url";
    private static final String ERROR_INVALID_URL = "Invalid URL";
    private static final String ERROR_DEFAULT = "Error shortening URL";


    public HomeData getHomeData(final HttpServletRequest request) {
        final String originalUrl = request.getParameter(ORIGINAL_URL_PARAM_KEY);
        return getHomeData(originalUrl);
    }

    public HomeData getHomeData(final String originalURL) {
        String error = null;
        if (originalURL != null) {
            try {
                final ShortenResult shortenResult = ConfigDataManager.getUrlShortener().shorten(originalURL);
                return new HomeData(shortenResult);
            } catch (MalformedURLException | URISyntaxException e) {
                error = ERROR_INVALID_URL;
            } catch (Exception e) {
                error = ERROR_DEFAULT;
                e.printStackTrace();
            }
        }
        return new HomeData(originalURL, error);
    }


}
