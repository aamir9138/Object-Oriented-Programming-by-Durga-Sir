class Testttttt {
    public void m1(int i){
        System.out.println("General method");
    }
    public void m1(int... i){
        System.out.println("Var-arg method");
    }
    public static void main(String[] args){
        Testttttt t = new Testttttt();
        t.m1(); // Var-arg method
        t.m1(2,3); // Var-arg method
        t.m1(10); // General method
    }
}