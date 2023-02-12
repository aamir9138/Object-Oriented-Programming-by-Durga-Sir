//class Testi{
//    public static void main(String [] args){
//        Object o = new String("Durga");
//        String s = (String) o;
//        System.out.println(s);
//    }
//}

//class Testi{
//    public static void main(String [] args){
//        Object o = new String("Durga");
//        StringBuffer s = (StringBuffer) o;
//        System.out.println(s);
//    }
//}

class Testi{
    public static void main(String [] args){
        String I = new String("Durga");
        Object o = (Object) I;
        System.out.println(I == o); // True
    }
}