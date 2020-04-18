package com.betty.tinyioc.xml;

import com.betty.tinyioc.AbstractBeanDefinitionReader;
import com.betty.tinyioc.BeanDefinition;
import com.betty.tinyioc.PropertyValue;
import com.betty.tinyioc.io.ResourceLoader;
import org.omg.CORBA.NO_IMPLEMENT;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName XmlBeanDefinitionReader.java
 * @Description TODO
 * @createTime 2020年04月17日 15:15:00
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }
    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }
    protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputStream);
        //解析bean
        registerBeanDefinition(document);
        inputStream.close();
    }

    private void registerBeanDefinition(Document document) {
        Element root = document.getDocumentElement();
        parseBeanDefinitions(root);
    }

    protected void parseBeanDefinitions(Element root) {
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element propertyEle = (Element) node;
                processBeanDefinition(propertyEle);
            }
        }
    }

    protected void processBeanDefinition(Element propertyEle) {
        String name = propertyEle.getAttribute("name");
        String className = propertyEle.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(propertyEle, beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name, beanDefinition);
    }

    private void processProperty(Element propertyEle, BeanDefinition beanDefinition) {
        NodeList propertyNode = propertyEle.getElementsByTagName("property");
        for (int i = 0; i < propertyNode.getLength(); i++) {
            Node node = propertyNode.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                String name = propertyEle.getAttribute("name");
                String value    = propertyEle.getAttribute("value");
                beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));

            }
        }


    }
}
