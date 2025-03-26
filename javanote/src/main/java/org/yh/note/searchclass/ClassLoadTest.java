package org.yh.note.searchclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

public class ClassLoadTest {

    private final static Logger log = LoggerFactory.getLogger("ClassLoadTest");

    public static void main(String[] args) {
        ClassLoad classLoad = new ClassLoadImp();

        File f = new File("./org/yh/note/searchclass/ClassLoadImp.class");
        System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
        System.out.println(f.getPath());
        System.out.println(f.isFile() + " " + f.exists());
        List<Class<?>> classes = classLoad.getClassesByClassPath("org");
        classes.forEach(System.out::println);
    }
}
