package com.betty.tinyaop.beans.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName UrlResource.java
 * @Description TODO
 * @createTime 2020年04月07日 14:43:00
 */
public class UrlResource  implements Resource{
    private final URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
