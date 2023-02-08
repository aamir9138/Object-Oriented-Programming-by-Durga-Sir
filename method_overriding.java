class Parent{
    public void property(){
        System.out.println("cash, land, gold");
    }
    public void marry(){
        System.out.println("Rabia");
    }
}
class Child extends Parent{
    @Override
    public void marry() {
        System.out.println("Katarina");
    }
}
class MethodOverriding {
    public static void main(String[] arg){
       Parent p = new Parent();
       p.marry(); // Rabia

       Child c = new Child();
       c.marry(); // Katarina

       Parent p1 = new Child();
       p1.marry(); // Katarina, so here it depends on runtime Object creation, even though reference type is parent
        // child class overriden method is executed.
    }
}
