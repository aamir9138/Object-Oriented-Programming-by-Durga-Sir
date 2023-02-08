class Testtttt {
    public void m1(String s){
        System.out.println("String version");
    }
    public void m1(StringBuffer sb){
        System.out.println("StringBuffer version");
    }
    public static void main(String[] args){
        Testtttt t = new Testtttt();
        t.m1("Aamir"); // String version
        t.m1(new StringBuffer("Aamir")); // StringBuffer version
//        t.m1(null);
    }
}