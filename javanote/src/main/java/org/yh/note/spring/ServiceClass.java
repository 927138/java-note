package org.yh.note.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ServiceClass implements Service{


    @Override
    public void run() {
        System.out.println("Service class run");
    }
}
