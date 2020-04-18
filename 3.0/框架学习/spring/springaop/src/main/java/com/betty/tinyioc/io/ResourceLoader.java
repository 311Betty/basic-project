package com.betty.tinyioc.io;

import java.net.URL;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName ResourceLoader.java
 * @Description TODO
 * @createTime 2020年04月17日 15:14:00
 */
public class ResourceLoader {
    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
