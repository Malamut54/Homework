package ru.sberbank.homework.bobrov.task_01;


import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 21.03.2018
 */


public class ClassFinder {

    public Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unexpected ClassNotFoundException loading class '" + className + "'");
        }
    }

    public List<Class<?>> getClassesForPackage(String pkgPath) {
        ArrayList<Class<?>> classes = new ArrayList<>();
        String relPath = pkgPath.replace('.', '/');
        URL resource = ClassLoader.getSystemClassLoader().getResource(relPath);
        if (resource == null) {
            throw new RuntimeException("Unexpected problem: No resource for " + relPath);
        }
        classes.addAll(processDirectory(new File(resource.getPath()), pkgPath));
        return classes;
    }

    public List<Class<?>> processDirectory(File directory, String pkgPath) {
        ArrayList<Class<?>> classes = new ArrayList<>();
        String[] files = directory.list();
        for (int i = 0; i < files.length; i++) {
            String fileName = files[i];
            String className = null;

            if (fileName.endsWith(".class")) {
                className = pkgPath + '.' + fileName.substring(0, fileName.length() - 6);
            }
            if (className != null) {
                classes.add(loadClass(className));
            }
        }
        return classes;
    }
}
