package ru.sberbank.homework.bobrov.task_01;


import ru.sberbank.homework.common.annotation.ExperimentalFeature;
import ru.sberbank.homework.common.annotation.Prototype;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AnnotationFinderApp {

    public static void main(String[] args) throws NoSuchMethodException {
        AnnotationFinderApp app = new AnnotationFinderApp();
        ClassFinder clFind = new ClassFinder();
        List<Class<?>> listCl = clFind.getClassesForPackage("ru.sberbank.homework.common.entity");

        ClassAnnotateFinder anFind = new ClassAnnotateFinder();
        List<Class<?>> listAnn = anFind.findAnnotateClass(listCl);

        System.out.println(app.getAnnotationClass(listAnn));
        System.out.println(app.getAnnotationMethod(listAnn));
        System.out.println(app.getAnnotationField(listAnn));
    }


    public List<String> getAnnotationClass(List<Class<?>> list) {
        List<String> result = new ArrayList<>();
        for (Class<?> aClass : list) {
            result.add("Version = " + aClass.getAnnotation(Prototype.class).version() + " " + aClass.getSimpleName());
        }
        return result;
    }

    public List<String> getAnnotationMethod(List<Class<?>> list) {
        List<String> result = new ArrayList<>();
        Method[] arrMethod;
        for (Class<?> aClass : list) {
            arrMethod = aClass.getDeclaredMethods();
            for (Method method : arrMethod) {
                if (method.isAnnotationPresent(ExperimentalFeature.class)) {
                    result.add(method.getName());
                }
            }
        }
        return result;
    }

    public List<String> getAnnotationField(List<Class<?>> list) {
        List<String> result = new ArrayList<>();
        Field[] arrField;
        for (Class<?> aClass : list) {
            arrField = aClass.getDeclaredFields();
            for (Field field : arrField) {
                if (field.isAnnotationPresent(ExperimentalFeature.class)) {
                    result.add(field.getName());
                }
            }
        }
        return result;
    }


//        list.stream()
//                .filter(s -> s.getAnnotation(Prototype.class) != null)
//                .map(s -> s.getAnnotations().length)
//                .forEach(System.out::println);
//
//        list.stream()
//                .filter(s -> s.getAnnotation(Prototype.class) != null)
//                .map(s -> s.getAnnotations()
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
//
//        list.stream()
//                .filter (p -> {
//                    return p.getAnnotation(Prototype.class) != null;
//                }
//                ).forEach(System.out::println);


}
