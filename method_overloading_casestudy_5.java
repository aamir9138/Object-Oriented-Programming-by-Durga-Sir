class Testtttttt {
    public void m1(int i, float f){
        System.out.println("int and float argument types");
    }
    public void m1(float f, int i){
        System.out.println("float and int argument types");
    }
    public static void main(String[] args){
        Testtttttt t = new Testtttttt();
        t.m1(10, 10.5f); // int and float argument types
        t.m1(11.5f, 5); // float and int argument types
     //   t.m1(6,6); //Ambiguous method call. Both
     //   t.m1(6.6f,6.6f); // Cannot resolve method 'm1(float, float)'
    }
}