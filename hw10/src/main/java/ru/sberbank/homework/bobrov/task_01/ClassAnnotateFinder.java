package ru.sberbank.homework.bobrov.task_01;


import ru.sberbank.homework.common.annotation.Prototype;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 23.03.2018
 */


public class ClassAnnotateFinder {
    public List<Class<?>> findAnnotateClass(List<Class<?>> listClass) {
        return listClass.stream()
                .filter(s -> s.getAnnotation(Prototype.class) != null)
                .collect(Collectors.toList());
    }
}
