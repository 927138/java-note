package org.yh.note.spring;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;


public class SpringCoreP {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        UseService use = (UseService) context.getBean("useService");
        use.print();


    }
}
