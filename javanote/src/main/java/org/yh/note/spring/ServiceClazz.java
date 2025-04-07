package org.yh.note.spring;

import org.springframework.stereotype.Component;

@Component
public class ServiceClazz implements Service{

    @Override
    public void run() {
        System.out.println("Service Clazz run");
    }
}
