//interface Interf{
//    void m1(); // by default these are `public abstract`
//    void m2(); // by default these are `public abstract` if we write or not
//}
//
//public class ServiceProvider implements Interf{
//
//    public void m1() {
//
//    }
//
//
//    public void m2() {
//
//    }
//}

interface Interf{
    void m1(); // by default these are `public abstract`
    void m2(); // by default these are `public abstract` if we write or not
}

abstract public class ServiceProvider implements Interf{

    public void m1() {
        System.out.println("method m1");
    }

}

class SubServiceProvider extends ServiceProvider{
    @Override
    public void m2() {
        System.out.println("method m2");
    }
}
