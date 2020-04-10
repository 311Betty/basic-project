package com.betty.tinyaop.beans.io;

import java.net.URL;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName ResourceLoader.java
 * @Description TODO
 * @createTime 2020年04月07日 14:42:00
 */
public class ResourceLoader {
    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
