package com.ederbaum.urlshortener.filestorage.util;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class IOUtil {

    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    public static String readFile(final File file) throws IOException {
        try (final BufferedReader reader = new BufferedReader(new FileReader(file,DEFAULT_CHARSET))) {
            final StringBuilder builder = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                builder.append(line);
                builder.append(System.lineSeparator());
                line = reader.readLine();
            }
            return builder.toString();
        }
    }



    public static void writeFile(final File destination, final String data)
            throws IOException {

        final ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes(DEFAULT_CHARSET));
        try (final OutputStream out = new FileOutputStream(destination)) {
            final byte[] buf = new byte[1024];
            int i;
            while ((i = inputStream.read(buf)) != -1) {
                out.write(buf, 0, i);
            }
            out.flush();
        }
    }
}
