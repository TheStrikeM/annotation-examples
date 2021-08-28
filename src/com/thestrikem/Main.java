package com.thestrikem;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@SomeAnnotation(name = "Test", age = 20)
public class Main {
    public static void main(String[] args) {

    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SomeAnnotation{
    String name();
    int age();
}
