package com.protectedmembers;

class A {
    protected void m1(){
        System.out.println("A class protected methods");
    }
}

class B extends A {
    public static void main(String [] args){
        A a = new A();
        a.m1(); // valid parent reference parent object

        B b = new B();
        b.m1(); // valid child reference child object

        A a1 = new B();
        a1.m1(); // valid parent reference child object
    }
}

