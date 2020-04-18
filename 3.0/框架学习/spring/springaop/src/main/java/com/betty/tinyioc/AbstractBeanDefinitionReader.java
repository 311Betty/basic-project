package com.betty.tinyioc;

import com.betty.tinyioc.io.ResourceLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName AbstractBeanDefinitionReader.java
 * @Description TODO
 * @createTime 2020年04月17日 15:15:00
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {

        this.registry = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}
