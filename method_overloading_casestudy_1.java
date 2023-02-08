class Testtt {
    public void m1(int i){
        System.out.println("int-arg method");
    }
    public void m1(float f){
        System.out.println("float-arg method");
    }
    public static void main(String[] args){
        Testtt t = new Testtt();
        t.m1(10);
        t.m1(10.5f);
        t.m1('a');
        t.m1(10l);
    }
}
