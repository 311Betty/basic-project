package com.betty.tinyaop.beans;

import com.betty.tinyaop.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName AbstractBeanDefinitionReader.java
 * @Description TODO
 * @createTime 2020年04月07日 14:45:00
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private Map<String ,BeanDefinition> registry;
    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<String ,BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
