// var-arg to normal method overloading
//class PPPPP {
//    public void m1(int... i){
//        System.out.println("parent");
//    }
//}
//
//class CCCCC extends PPPPP{
//    public void m1(int i){
//        System.out.println("child");
//    }
//}
//
//class Testee{
//    public static void main (String [] arg){
//        PPPPP p = new PPPPP();
//        p.m1(10); // parent
//
//        CCCCC c = new CCCCC();
//        c.m1(10); // child
//
//        PPPPP p1 = new CCCCC();
//        p1.m1(10); // parent
//    }
//}

// var-arg to var-arg overriding
class PPPPP {
    public void m1(int... i){
        System.out.println("parent");
    }
}

class CCCCC extends PPPPP{
    public void m1(int... i){
        System.out.println("child");
    }
}

class Testee{
    public static void main (String [] arg){
        PPPPP p = new PPPPP();
        p.m1(10); // parent

        CCCCC c = new CCCCC();
        c.m1(10); // child

        PPPPP p1 = new CCCCC();
        p1.m1(10); // child, based on the JVM runtime object.
    }
}