class ParentMethodOverriding {
    public Object m1(){
        System.out.println("Parent method return type Object");
        return null;
    }
}

class ChildMethodOverriding extends ParentMethodOverriding{
    public String m1(){
        System.out.println("Child method return type String");
        return null;
    }
}
class MethodOverridingRulesPart1 {
    public static void main(String [] args) {
        ParentMethodOverriding p = new ParentMethodOverriding();
        p.m1(); // Parent method return type Object

        ChildMethodOverriding c = new ChildMethodOverriding();
        c.m1(); // Child method return type String
    }
}
