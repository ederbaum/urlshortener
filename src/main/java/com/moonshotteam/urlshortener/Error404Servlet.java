package com.moonshotteam.urlshortener;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

/**
 * This Servlet captures all 404 pages, and if applicable redirects to URLs in the persistence layer
 */
public class Error404Servlet extends HttpServlet {


    private static final String NOT_FOUND_PAGE = "/404.html";
    private static final String JAVAX_SERVLET_FORWARD_REQUEST_URI = "javax.servlet.forward.request_uri";

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException,
            ServletException {
       final Object attribute = request.getAttribute(JAVAX_SERVLET_FORWARD_REQUEST_URI);
        if (attribute != null) {
            redirectToFullUrl(request, response, attribute.toString());
        } else {
            show404(request,response);
        }

    }


    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws IOException, ServletException {
        this.doGet(request, response);
    }

    private void redirectToFullUrl(final HttpServletRequest request, final HttpServletResponse response,
                                   final String requestURI) throws IOException, ServletException {
        final URL url = ConfigDataManager.getUrlShortener().getOriginalURL(requestURI);
        if (url != null) {
            response.sendRedirect(url.toString());
        } else {
            show404(request, response);
        }
    }

    private void show404(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
            IOException {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        getServletContext().getRequestDispatcher(NOT_FOUND_PAGE).forward(request, response);
    }
}
