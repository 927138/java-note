package org.yh.note.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UseService {
    private final Service service;

    @Autowired
    public UseService( Service service){
        this.service = service;
    }

    public void print(){
        service.run();
    };
}
