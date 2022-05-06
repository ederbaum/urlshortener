package com.moonshotteam.urlshortener.filestorage.util;

import java.io.*;

public final class IOUtil {

    public static String readFile(final File file) throws
            IOException {
        try (final BufferedReader br = new BufferedReader(new FileReader(file))) {
            final StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        }
    }



    public static void writeFile(final File destination, final String data)
            throws IOException {

        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
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
