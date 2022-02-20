package com.customannotation;

import java.lang.annotation.*;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class CustomAnnotation {

    public static void main(String[] args) throws NoSuchMethodException {

        //Reflections API
        Class<SomeClass> obj = SomeClass.class;
//        SomeClass obj =new SomeClass();
        annotationReadMethod(SomeClass.class);
        Method method = obj.getMethod("myMethod", new Class[]{});
        annotationReadMethod(method);
//
    }

    static void annotationReadMethod(AnnotatedElement element) {
        try {
            System.out.println("-- Get annotations on -" + element.getClass().getName());
            Annotation[] annotations = element.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof MyCustomAnnotation) {
                    MyCustomAnnotation myCustomAnnotation = (MyCustomAnnotation) annotation;
                    System.out.println("str : " + myCustomAnnotation.str() + "\n intt : " + myCustomAnnotation.intt());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

@Target({ElementType.TYPE, ElementType.METHOD}) //class level, method level
@Retention(RetentionPolicy.RUNTIME)
@interface MyCustomAnnotation {
    String str() default "setting default";
    int intt() default 1;
}

@MyCustomAnnotation  //class level
class SomeClass {
    @MyCustomAnnotation(str = "Abc", intt = 2) //method level
    public String myMethod() {
        return "";
    }
}