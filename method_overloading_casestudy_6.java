class Animal{

}
class Monkey extends Animal{

}

class Testttttttt {
    public void m1(Animal a){
        System.out.println("Animal version");
    }
    public void m1(Monkey m){
        System.out.println("Monkey version");
    }
    public static void main(String[] args){
        Testttttttt t = new Testttttttt();

        Animal a = new Animal();
        t.m1(a); // Animal verion

        Monkey m = new Monkey();
        t.m1(m); // Monkey version

        Animal a1 = new Monkey();
        t.m1(a1); // Animal version
    }
}