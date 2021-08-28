package com.thestrikem;

import java.lang.annotation.*;
import java.util.Arrays;

public class Example1 {
    public static void main(String[] args) throws ClassNotFoundException {
        SmartPhoneAnnotation xiaomiAnnotation = getParamsOfSmartPhoneAnnotation(Xiaomi.class);
        SmartPhoneAnnotation androidAnnotation = getParamsOfSmartPhoneAnnotation("Android");
        SmartPhoneAnnotation iphoneAnnotation = getParamsOfSmartPhoneAnnotation("Iphone");
        Arrays.stream(new SmartPhoneAnnotation[]{xiaomiAnnotation, androidAnnotation, iphoneAnnotation})
                .forEach(item -> System.out.println(
                        String.format("Company %s was created at %s", item.companyName(), item.createdAt())
                ));
    }

    public static SmartPhoneAnnotation getParamsOfSmartPhoneAnnotation(String className)
            throws ClassNotFoundException {
        Class someClass = Class.forName("com.thestrikem."+className);
        Annotation annotation = someClass.getAnnotation(SmartPhoneAnnotation.class);
        SmartPhoneAnnotation result = (SmartPhoneAnnotation) annotation;
        return result;
    }

    public static SmartPhoneAnnotation getParamsOfSmartPhoneAnnotation(Class inputClass) {
        Class someClass = inputClass;
        Annotation annotation = someClass.getAnnotation(SmartPhoneAnnotation.class);
        SmartPhoneAnnotation result = (SmartPhoneAnnotation) annotation;
        return result;
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhoneAnnotation{
    String companyName() default "Android";
    int createdAt() default 1900;
}

class SmartPhone {
    int model;
    double price;
}

@SmartPhoneAnnotation(companyName = "Iphone", createdAt = 22)
class Iphone extends SmartPhone {}

@SmartPhoneAnnotation()
class Android extends SmartPhone {}

@SmartPhoneAnnotation(companyName = "Xiaomi", createdAt = 2090)
class Xiaomi extends SmartPhone {}
