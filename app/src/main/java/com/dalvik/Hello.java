package com.dalvik;

/**
 * @author: GY.LEE
 * @date: 2019-08-13
 * @Des:
 */
public class Hello {
    public static void main(String[] args) {
        Hello hello = new Hello();
        System.out.println(hello.foo(5, 3));
    }

    public int foo(int a, int b) {
        return (a + b) * (a - b);
    }
}