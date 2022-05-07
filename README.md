# Urlshortener
A Url Shortener using only pure Java.

## To work locally
Please change the value of `storage.folder.path` in the file [src/main/config/config.properties]. Is necessary to point to a folder where it's possible to read and write files.
Don't forget to use at the end of the given path `/` if you are running on Unix, Mac or Linux systems, or `\` for Windows.

If desired, also change the value of `url.root`.

I tested locally using both Eclipse and Netbeans with Tomcat 9.

Running the tests will ensure that the changed settings are working.

## How Urlshortener handles requests

Browser requests are handled primarily by these files:
- [index.jsp];
- [Error404Servlet];

### [index.jsp]
This file displays the main user interface. This will call the [HomeRequestManager] class, which will handle the request, shortening the URL if it is informed, or returning errors if applicable.

### [Error404Servlet]
This servlet, as its name implies, takes all requests where there is no page or file defined, waiting for URIs such as `/abcd123` which would be the short keys to find the original URLs stored in the persistence layer. If a stored full URL is found, the user will be redirected to it, otherwise an 404 error will be displayed.

[src/main/config/config.properties]: https://github.com/ederbaum/urlshortener/blob/master/src/main/config/config.properties
[HomeRequestManager]: https://github.com/ederbaum/urlshortener/blob/master/src/main/java/com/moonshotteam/urlshortener/HomeRequestManager.java
[index.jsp]: https://github.com/ederbaum/urlshortener/blob/master/src/main/webapp/index.jsp
[Error404Servlet]: https://github.com/ederbaum/urlshortener/blob/master/src/main/java/com/moonshotteam/urlshortener/Error404Servlet.java
