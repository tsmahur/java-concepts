package com.customannotation;

public class MyClass {

    public static void main(String[] args) {

        System.out.println(myMethod());

    }
//    @PrintMethodExecutionTime
    @PrintMethodExecutionTime(some = "")
    public static String myMethod(){
        return "myMethod() called";
    }
}
//Marker Annotation - empty
//@interface PrintMethodExecutionTime{
//}

//Single Value Annotaion
@interface PrintMethodExecutionTime{
    String some() default "abc";
}
//Multiple Value Annotaion
//@interface PrintMethodExecutionTime{
//    String some();
//    String some2();
//}