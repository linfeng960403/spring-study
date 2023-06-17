package com.wangzihao;

import com.sun.xml.internal.ws.runtime.config.TubelineFeatureReader;
import com.wangzihao.entity.Student;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class MainApplication {

    public static void main(String[] args) {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Student.class);

        beanDefinitionBuilder.addPropertyValue("name","wangzihao").addPropertyValue("age",18);
        beanDefinitionBuilder.addPropertyValue("name","wangzihao2").addPropertyValue("age",18);


        factory.registerBeanDefinition("student1",beanDefinitionBuilder.getBeanDefinition());

        factory.registerBeanDefinition("student2",beanDefinitionBuilder.getBeanDefinition());

//        Student stu = factory.getBean(Student.class);

//        System.out.println(stu);

        Student student2 = (Student) factory.getBean("student2");

        System.out.println("student2:"+student2);
//
        ObjectProvider<Student> beanProvider = factory.getBeanProvider(Student.class);
//
        Student provider = beanProvider.getIfAvailable();
//
//        System.out.println(provider);

    }

}
