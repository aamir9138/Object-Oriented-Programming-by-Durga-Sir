class ParentMethodOverriding {
    public double m1(){
        System.out.println("Parent method return type double");
        return 10.5;
    }
}

class ChildMethodOverriding extends ParentMethodOverriding{
    public int m1(){
        System.out.println("Child method return type int");
        return 5;
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
