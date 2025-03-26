package org.yh.note.searchclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClassLoadImp implements ClassLoad {

    private final static Logger log = LoggerFactory.getLogger("ClassLoadImp");
    private final String CLASSSUFFIX = ".class";

    @Override
    public List<Class<?>> getClassesByClassPath(String classPath) {

        if(Objects.isNull(classPath) || classPath.isBlank()){
            throw new IllegalArgumentException("classPath value is null or empty");
        }
        URL resource = getUrlByClassPath(classPath);
        if(Objects.isNull(resource)){
            throw new NullPointerException("Resource value queried by the input parameter (classPath) is null");
        }

        File file = new File(resource.getFile());
//        log.info("{}", resource.getPath());
        return getClassesByFile(file, classPath);
    }

    @Override
    public List<Class<?>> getClassesByFile(File file, String fqnPath) {

        if(Objects.isNull(file)){
            throw new NullPointerException("file is null");
        }
        if(Objects.isNull(fqnPath) || fqnPath.isBlank()){
            throw new IllegalArgumentException("fqnPath value is null or empty");
        }
        log.info(file.getParent());

        List<Class<?>> classes = new ArrayList<>();
        if(!file.exists()){
            return classes;
        }

        File[] files = file.listFiles();
        if(Objects.isNull(files)){
            throw new NullPointerException("file.listFiles() method run result is null");
        }

        for(File f : files){
            if(f.isDirectory()){
                String childPath = fqnPath+"."+f.getName();
                classes.addAll(getClassesByFile(f, childPath));
            }else if(f.getName().endsWith(".class")){
                // 6은 ".class" 의 길이를 뜻함.
                String className
                        = fqnPath + '.' + f.getName().substring(0, f.getName().length() - CLASSSUFFIX.length());
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

                try {
                    classes.add(Class.forName(className, false, classLoader));
                } catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
        }

        return classes;
    }

    private URL getUrlByClassPath(String classPath){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String transPath = classPath.replace('.', '/');

        return classLoader.getResource(transPath);
    }

}
