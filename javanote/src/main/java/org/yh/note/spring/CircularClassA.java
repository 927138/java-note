package org.yh.note.spring;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component

public class CircularClassA {

    private final CircularClassB b;
    public CircularClassA(@Lazy CircularClassB b){
        this.b =b;
    }

    public void run(){
        System.out.println("CircularClassA.run()");
    }
}
