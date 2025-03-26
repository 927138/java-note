package org.yh.note.searchclass;

import java.io.File;
import java.util.List;

public interface ClassLoad {
    List<Class<?>> getClassesByClassPath(String classPath);
    List<Class<?>> getClassesByFile(File file, String fqnPath);
}
