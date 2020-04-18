package com.betty.tinyioc.xml;

import com.betty.tinyioc.BeanDefinition;
import com.betty.tinyioc.io.ResourceLoader;
import com.sun.org.apache.xpath.internal.operations.NotEquals;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class XmlBeanDefinitionReaderTest {
    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        Assert.assertTrue(registry.size() > 0);
    }

}
