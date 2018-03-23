package ru.sberbank.homework.bobrov.task_02;

import ru.sberbank.homework.common.BeanFieldCopier;

import java.lang.reflect.Method;

public class ReflectionFieldCopier implements BeanFieldCopier {
    @Override
    public void copy(Object from, Object to) {
        Class<?> classTo = to.getClass();
        Class<?> classFrom = from.getClass();
        Method[] methodsTo = classTo.getMethods();
        Method[] methodsFrom = classFrom.getMethods();

        for (Method method : methodsFrom) {
            if (method.getName().startsWith("get")) {

            }
        }
    }
}
