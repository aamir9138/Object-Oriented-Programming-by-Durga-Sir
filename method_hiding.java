//class PPPP{
//    public static void m1(){
//
//    }
//}
// class CCCC extends PPPP{
//    public void m1(){
//        // Error: Instance method 'm1()' in 'CCCC' cannot override static method 'm1()' in 'PPPP'
//
//    }
// }

//class PPPP{
//    public  void m1(){
//
//    }
//}
//class CCCC extends PPPP{
//    public static void m1(){
//        // Error: Static method 'm1()' in 'CCCC' cannot override instance method 'm1()' in 'PPPP'
//
//    }
//}

// Method hiding
//class PPPP{
//    public static void m1(){
//
//    }
//}
//class CCCC extends PPPP{
//    public static void m1(){
//
//
//    }
//}

// Method overring
//class PPPP{
//    public  void m1(){
//    }
//}
//class CCCC extends PPPP{
//    public  void m1(){
//    }
//}

// method overriding
//class PPPP{
//    public void m1(){
//        System.out.println("parent");
//    }
//}
//class CCCC extends PPPP{
//    public  void m1(){
//        System.out.println("child");
//    }
//}
//
//class Teste{
//    public static void main(String [] arg){
//        PPPP p = new PPPP();
//        p.m1(); // parent
//
//        CCCC c = new CCCC();
//        c.m1(); // child
//
//        PPPP p1 = new CCCC();
//        p1.m1(); // child
//
//    }
//}

// method hiding
class PPPP{
    public static void m1(){
        System.out.println("parent");
    }
}
class CCCC extends PPPP{
    public static void m1(){
        System.out.println("child");
    }
}

class Teste{
    public static void main(String [] arg){
        PPPP p = new PPPP();
        p.m1(); // parent

        CCCC c = new CCCC();
        c.m1(); // child

        PPPP p1 = new CCCC();
        p1.m1(); // parent

    }
}