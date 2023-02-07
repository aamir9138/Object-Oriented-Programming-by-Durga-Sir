class P {
    public void m1(){
        System.out.println("parent");
    }
}

class C extends P{
    public void m2(){
        System.out.println("child");
    }
}

class Testt {
    public static void main(String[] args){
        P p = new P();
        p.m1();
//        p.m2(); cannot access child methods

        C c = new C();
        c.m1();
        c.m2(); // we can call both parent and child methods

        P p1 = new C();
        p1.m1();
//        p1.m2(); parent reference can be used to hold the child object. but we cannot use it to access the child methods
    }
}
