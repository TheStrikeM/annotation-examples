package com.thestrikem;

import java.lang.annotation.*;

public class Example1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class xiaomiClass = Class.forName("com.thestrikem.Xiaomi");
        Annotation annotation = xiaomiClass.getAnnotation(SmartPhoneAnnotation.class);
        SmartPhoneAnnotation sm = (SmartPhoneAnnotation) annotation;
        System.out.println(String.format("Model %s was created at %s", sm.companyName(), sm.createdAt()));
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
