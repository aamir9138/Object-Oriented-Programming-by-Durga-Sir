class Testttt {
    public void m1(Object o){
        System.out.println("object version");
    }
    public void m1(String s){
        System.out.println("String version");
    }
    public static void main(String[] args){
        Testttt t = new Testttt();
        t.m1(new Object());
        t.m1("Aamir");
        t.m1(null);
    }
}