//// Overriding wrt instance variables
//class Parente {
//    String s = "Parent";
//}
//class Childe extends Parente{
//    String s = "Child";
//}
//class Testa{
//    public static void main(String [] args){
//        Parente p = new Parente();
//        System.out.println(p.s); // parent
//
//        Childe c = new Childe();
//        System.out.println(c.s); // child
//
//        Parente p1 = new Childe();
//        System.out.println(p1.s); // parent, it is not overriding but variables are always resolved by compile based on reference type.
//
//    }
//}

// Overriding wrt static and instance variable
class Parente {
    static String s = "Parent";
}
class Childe extends Parente{
    String s = "Child";
}
class Testa{
    public static void main(String [] args){
        Parente p = new Parente();
        System.out.println(p.s); // parent

        Childe c = new Childe();
        System.out.println(c.s); // child

        Parente p1 = new Childe();
        System.out.println(p1.s); // parent, it is not overriding but variables are always resolved by compile based on reference type.

    }
}
