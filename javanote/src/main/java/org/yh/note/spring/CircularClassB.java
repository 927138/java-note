package org.yh.note.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularClassB {
    private final CircularClassA a;

    @Autowired
    public CircularClassB(CircularClassA a){
        this.a = a;
    }

    public void run(){
        System.out.println("CircularClassB.run()");
    }
}
