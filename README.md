## Java Source File Structure

- we can have a number of java classes in java program.
- we can have `atmost one public class` in java program. otherwise we get compile time error.
- if we have public class `public class B`. compulsory the name of the java program will be `B.java`
- if there is no public class we can use any name for the java program.
- so like this is possible in a java program name `Durga.java`. because all classes are not public
```
class A{

}
class B{

}
class C{

}
```
- `javac Durga.java` will compile fine no syntactical mistake.
- if we add a public class whose name is different than java program. it give the following error.

````
class A{

}
public class B{

}
class C{

}
$ javac Durga.java
Durga.java:14: error: class B is public, should be declared in a file named B.java
public class B{
^       
1 error
````
- so if we save it as `B.java` it will happily compile.
- if we have 2 public classes in java application. it will also give the same above error.
- the class which contain main method has no relation with this to be the name of the java application

## class files

- for every class contain in a java application a separate `.class` file will be generated
````
  class A{

}
public class B{

}
class C{

}
````
- the above code will generate 3 `.class` files
- we can compile `.java` program but we can run `.class` file. important

## multiple classes with main method in a single java application

it is possible to have multiple classes with main method in a single java application.
````
class A{
    public static void main(String[] arg){
        System.out.println("A class main method");
    }
}

class B{
    public static void main(String[] arg){
        System.out.println("B class main method");
    }
}

class C{
    public static void main(String[] arg){
        System.out.println("C class main method");
    }
}

class D{
}
````
- if we execute class A its main method will be executed. if we execute B its main method will be executed.
- but if we execute class D as it has no main method it will give us error
- to execute a java class use command `java A`, `java B`, `java D` etc
````
$ java A
A class main method
````
````
$ java D
Error: Main method not found in class D, please define the main method as:
   public static void main(String[] args)                                 
or a JavaFX application class must extend javafx.application.Application 
````
## Import Statement Introduction

- let say we are instantiating objects from classes present in libraries like `ArrayList`.
- if we use it like below
````
public class ArrayListTest {
    public static void main(String[] args){
        ArrayList l = new ArrayList();
    }
}
````
it will give us the below error while compiling
````
$ javac ArrayListTest.java 
ArrayListTest.java:4: error: cannot find symbol
        ArrayList l = new ArrayList();
        ^
  symbol:   class ArrayList
  location: class ArrayListTest
````
so java don't know from where ArrayList classes is coming. for that we can either use fully
qualified name like
`java.util.ArrayList l = new java.util.ArrayList();`
or we can import it. so readability will improve and length of code will reduce. otherwise we have 
to use everywhere fully qualified names for classes
````
import java.util.ArrayList;
public class ArrayListTest {
    public static void main(String[] args){
        ArrayList l = new ArrayList();
    }
}
````
## Types of imports

### explicit imports
````
import com.sparkasse.loan;
import com.postbank.accout;
````
### implicit imports
````
import com.sparkasse.*
import com.postbank.*
import java.util.*
````
- implicit imports are not good because we don't know from where the class is coming.
- IDEs never generate implicit imports always explicit imports.
- highly recommended explicit imports.

## important points about imports

for 2 types of classes we don't need to import the package for it.

- first is `java.lang` package from where we are getting `String` for example. `Thread`, `Exception` and `StringBuffer`
are also from `java.lang`. we don't need import statement for it.
````
class A{
    public static void main(String[] arg){
        String s = new String("Durga");
        Thread t = new Thread();
        Exception e = new Exception();
        StringBuffer sb = new StringBuffer();
    }
}
````
- second is the `current working directory`. so classes defined in the same directory are not
imported it is the `default package`. it will import automatically
- if we want to use from outside package a compulsory import statement is required.
````
  public class Student {
    public static void m1(){
        System.out.println("Student class static method");
    }
}
````
````
public class Test{
    public static void main(String[] arg){
        String s = new String("Durga");
        Thread t = new Thread();
        Exception e = new Exception();
        StringBuffer sb = new StringBuffer();
//        no need import statement for Student class because it is from current working directory
        Student st = new Student();
        st.m1();
//        or
        Student.m1();
    }
}
````
- when we are importing a package all classes from that package will be imported but not the classes of sub packages.
- let us say we have `java->util->regex->Pattern`. so writing `import java.*` will import classes only in `java` package
not the classes of `java.util` or etc sub-packages.

## Java Source File Structure - Package Statement

- a group of related items or things is a package. so a group of related classes and interfaces are a package.
- for example `java.sql` package contain related classes for the sql database 
- package is an `encapsulation` mechanism to group related classes and interfaces together
- so if we have two same classes let say `Date`. we can use both in separate packages like `java.util.Date` and `java.sql.Date`
- so we can avoid naming conflicts
- and modularity of the application will improved by packaging
- maintainability of code will improve
- package is a wall. Outside package will not access inside class so security will also improve

## how to write, compile and run package statement

- use internet domain name in reverse for package naming to be unique
- when compiling if we write like `javac Test.java` the generated `Test.class` file will be place in `current working directory`
```
javac Test.java
current working directory
│       
│
└─── Test.class
|
```
````
package com.durgasoft.ocja;

public class Test{
    public static void main(String[] arg){
        System.out.println("package example");
    }
}
````
- now if we have a package for example `com.durgasoft.ocja` and we want to compile
the `Test.java` program in the path of this package we use this command
`javac -d . Test.java`. This `Test.class` will be created in `com.durgasoft.ocja.Test.class`
- `.` means `current working directory`. if `com`, `durgasoft`,`ocja` will not be there so automatically it will be created
- if we write `javac -d E: Test.java`. The `Test.class` file will be created in path `E:` destination.
- if we want to run this class we need to give the fully qualified name like `java com.durgasoft.ocja.Test`
````
$ java com.durgasoft.ocja.Test
package example
````
## important point about package statement

1) atmost one package is allowed in a java program if we provide more than one package compile will give error
````
package pack1;
package pack2;

public class Test{
}
````
if we compile the above program using `javac -d . Test.java` it give below error
````
$ javac -d . Test.java
Test.java:24: error: class, interface, or enum expected
package pack2;                                         
^                                                      
1 error
````
2) first non-commented line must be package. declaring package after imports is not allowed.
````
import java.util.*
package pack1;

public class Test{
}
````
the above thing will give error.
````
$ javac -d . Test.java
Test.java:24: error: class, interface, or enum expected
package pack2;                                         
^                                                      
1 error
````
the order is important and will be like this.
```
package statement
│       
└─── import statement
│   
└─── class/interface/enums
```
## class level modifiers: public and default

we have to provide information to the JVM about the behaviour of the class. for that we use `modifiers`. To let the program
know that this class is accessable from anywhere or not. 

- if class is `public` we can access it in any package. this package or any other package.
- if no modifier is used the class is `default` and only accessable in current package. not to the outside
- if class is `abstract` object creation is not possible
- if class is not `abstract` object can be created happily
- if the class is `final` than the child class creation is not possible
- if class is not `final` child classes can be created happily.

### what are allowed modifiers for top level classes?

the only applicable modifiers for top level classes are `public`,`default means nothing`, `abstract`,`final` and `strictfp`


### what are allowed modifiers for inner classes?

- the applicable modifiers for inner classes are 8 `public`,`default means nothing`, `abstract`,`final`, `private`,`protected`,`static` and `strictfp`
- `private`,`protected`,`static` are only allowed for inner classes.

## Abstract Method

`abstract` modifier is the most important modifier. where we can use `abstract` modifier?

1. with methods possible
2. with classes possible
3. with variables `abstract` modifier is not possible.

abstract in general mean partial, not completed something like this.

### important point about Abstract Method

1. `abstract methods` will have only declaration and not implementation.
2. `abstract methods` has no body or you can say no curly braces.
3. `abstract methods` ends  with a semicolon `;` and have no implementation
4. The class containing the `abstract mehod` must also be declared as `abstract` otherwise error
5. `abstract methods` will be implemented by the `child classes`

we will discuss these points with some examples. The below example is correct and will compile correctly
````
public abstract class abstract_method {
    public abstract int getNoOfWheels();
    public abstract String getTaste();
    public abstract double getLoanInterest();
}
````
as we can see in all the 3 cases we don't know the return value that is the reason we declared it as `abstract methods`.
it means no of wheels, fruit taste and interest loan can be different not a single value. which we will implement in the child classes.

Below we present some scenario and determine if it is a valid syntax or not.

````
public abstract void m1(){}   // not valid as we have curly braces
public void m1();             // not valid because not abstract still we don't have implementation we need {}
public abstract void m1();    // valid
public void m1(){}            // valid
````
## abstract class

abstract class means incomplete class. if a class start with `abstract` modifier are `abstract class`. some important points about it are below.

1. if a class contain atleast one `abstract method` the class must be declared as `abstract` otherwise compiler error
2. even though if we don't have `abstract methods` we can declare a class as abstract if the methods declared are dummy or incomplelte.
3. we cannot create `object` of abstract classes.
4. in other words we cannot instantiate it. because of the reason that these classes are incomplete.

we cannot instantiate because if we do it and try to access an `abstract method` it will give error because it has no implementation.
or if we have dummy methods we cannot get anything.

abstract class with abstract method
````
abstract public class abstract_class {
    public abstract int getNoOfWheels();
}
````
abstract class with dummy methods
````
abstract public class abstract_class {
    public void m1(){}
    public void m2(){}
    public void m3(){}
}
````
- in future we will see every `Adapter class` is an abstract class
- also the `httpservlet classes` are abstract classes. which even doesn't contain abstract methods.

## abstract class vs abstract method

let say we have an abstract class
````
abstract class Test{
    public abstract void m1();
    public abstract void m2();
}
````
to implement these abstract methods we need a child class for example
````
public class SubTest extends Test{
    public void m1(){}
}
````
to make a child class we have to use the `extends` keyword as above. and you observe we have implemented the
method `m1(){}` in child class `SubTest` but compiler will give error. why because we implement only one method
from the parent class we have to implement all the methods from parent class in the child class.

so the possible fixes are 2

1. provide implementation for all the abstract methods in the child classes.
2. if we are going to provide implementation for only one method than declare the child class also `abstract`. because
it is not complete.

we will provide a real life example here
````
abstract class vehicle{
    public abstract int getNoOfWheels();
}

class bus extends vehicle{
    public int getNoOfWheels(){
        return 6;
    }
}

class Auto extends vehicle{
    public int getNoOfWheels(){
        return 3;
    }
}

public class child_classes {
    public static void main(String[] args){
        bus b = new bus();
        Auto a = new Auto();
        System.out.println(b.getNoOfWheels());  // 6
        System.out.println(a.getNoOfWheels());  // 3
    }
}
````
The question is why are we giving abstract methods in the parent. even without this the code will run. this is because
if we want to force the user to create classes for which it is necessary.

## Member Modifiers: public, default and private

member means it may be a `variable` or may be a `method`. member modifiers are 12 but we will discuss only 4 here.

### public modifier

- if a member is declared as `public` we can access it from anywhere inside a package or outside
- but where ever the public member is declared the enclosed class must also be `public` if class is not public than we cannot access it.

### default modifier

if there is no modifier that member is default.
- default member are only accessable within the same package. outside the package it is not possible.
- even though the enclosing class is public but if the member i.e variable or method is default we cannot access it from outside the package

### private members

private members are only accessable within the same class.

- private -- class level
- default -- package level
- public -- global level

1. recommended modifiers for data members `variable` is always `private`. 
2. recommended modifiers for methods is `public`

## Member modifiers as protected

if a member is declared as `protected` it means that it is accessable inside the package plus   the child classes outside of the package.

````
protected = <default> + kids
````
### how we know a child class

the class which is extended from another class is a child class.
````
class B extends A
````
here B is a child of class A.

````
package com.protectedmembers;

class A {
    protected void m1(){
        System.out.println("A class protected methods");
    }
}

class B extends A {
    public static void main(String [] args){
        A a = new A();
        a.m1(); // valid parent reference parent object

        B b = new B();
        b.m1(); // valid child reference child object

        A a1 = new B();
        a1.m1(); // valid parent reference child object
    }
}
````
within the same package we can use any reference either parent reference or child reference.
first compile `javac -d . protected_members.java`
then run using `java com.protectedmembers.B`

````
$ java com.protectedmembers.B
A class protected methods
A class protected methods
A class protected methods
````
### important about protected

- if we are accessing the protected members in the same package we can access it either with parent class reference or child class reference no problem.
- but if we are accessing the protected members in a different package with a child class we can access it only with the `child class reference` not with the `parent class reference`.

````
package pack1;

public class A {
    protected void m1(){
        System.out.println("A class protected methods");
    }
}
````
````
package com.pack2;
import pack1.A

public class B extends A {
    public static void main(String [] args){
        A a = new A();
        a.m1(); // not valid because different package and parent reference

        B b = new B();
        b.m1(); // valid even different package child class but reference is child class

        A a1 = new B();
        a1.m1(); // not valid because reference is a parent class
    }
}
````
````
$ javac -d . packs/pack2/B.java
packs\pack2\B.java:8: error: m1() has protected access in A
        a.m1();
         ^
packs\pack2\B.java:14: error: m1() has protected access in A
        a1.m1();
          ^
2 errors
````

## Summary of public, protected, default and private modifiers

| Visibility                                    | public | protected                                 | default | private | 
|-----------------------------------------------|--------|------------------------------------------ | ------- |-------- |
| within the same class                         |  yes   |  yes                                      |  yes    |  yes    |
| from child class of same package              |  yes   |  yes                                      |  yes    |  no     |
| from non-child class of same package          |  yes   |  yes                                      |  yes    |  no     |
| from child class of different package         |  yes   |  yes [we sholud use child reference only] |  no     |  no     |
| from non-child class of outside package       |  yes   |  no                                       |  no     |  no     |

`privat < default < protected < public` is the ascending order of restriction.

## interface Declaration and implementation

interface is defined by using `interface` keyword.
- class is responsible for implementation of `interface`. to implement class use the keyword `implements`.
- by default all the methods in `interface` are `public` and `abstract`. if we declare it or not all of it are `public` and `abstract`

### important point for implementation of interface in a service provider class

1. The class must declare the method of `interface` as public while implementing it otherwise error.
2. All the methods of the `interface` must need to be implemented otherwise error.
3. if we want implement some of the method of the interface than we have to declare the service provider class as `abstract` because it is not giving the implementation for all the methods
4. we can use the child class of service provider class to implement the remaining methods.

````
interface Interf{
    void m1(); // by default these are `public abstract`
    void m2(); // by default these are `public abstract` if we write or not
}

public class ServiceProvider implements Interf{

    public void m1() {

    }


    public void m2() {

    }
}
````
The above code will work fine. if implement only 1 method than we can also do like this.
````
interface Interf{
    void m1(); // by default these are `public abstract`
    void m2(); // by default these are `public abstract` if we write or not
}

abstract public class ServiceProvider implements Interf{

    public void m1() {

    }

}
````
and to implement the second method we can use child classes
````
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
````
## Data Hiding

It means outside person should not access out internal data directly. we have to hide it. example of gmail inbox was giving. without my data validation that is email and password is not possible.
for this we declare the variable as `private` and then if we need data we use `getMethods`

````
public class Account{
    private double balance;

    public double getBalance(){
        // validation
        if(validation is correct){
        return balance
        }
    }
````
## Abstraction

we are providing the following services. but how these services are implemented is hided this is called `Abstraction`. so hiding of implementation is `Abstraction`. This is done for security reasons.
`interfaces` are used to implement `Abstraction`.

### importance

1. Security
2. Enhancement
3. maintainability will improved
4. Modularity will improved

## Encapsulation

The process of grouping the `data members` and the `methods` together is called `encapsulation`. `class` is an example of `encapsulation`.

`Encapsulation = Data hiding + Abstraction`

- `getter` and `setter` are used for validation.

Hiding data behind methods is infact `Encapsulation`

### importance

1. Security
2. Enhancement
3. maintainability will improved
4. Modularity will improved

## Tightly Encapsulated Class

a class is `Tightly Encapsulated Class` if and only if all the variables inside it are `private`.

- if parent class in not Tightly encapsulated than no child class is tightly encapsulated.

## Inheritance Introduction

1. inheritance is relationship
2. for code reuseability
3. `extends` keyword is used for relationship

This child classes which will be build using `extends` keyword contain all the methods of its parent class by default 
because it is inherited from it.

parent reference can be used to hold the child object. but we cannot use it to access the child methods
````
class P {
    public void m1(){
        System.out.println("parent");
    }
}

class C extends P{
    public void m2(){
        System.out.println("child");
    }
}

class Testt {
    public static void main(String[] args){
        P p = new P();
        p.m1();
//        p.m2(); cannot access child methods

        C c = new C();
        c.m1();
        c.m2(); // we can call both parent and child methods

        P p1 = new C();
        p1.m1();
//        p1.m2(); parent reference can be used to hold the child object. but we cannot use it to access the child methods
    }
}

````
Parent reference can be used to hold the child Object but child reference cannot be used to hold the parent object.
````
C c1 = new P(); // Parent reference can be used to hold the child Object but child reference cannot be used to hold the parent object.
````
## Importance of Inheritance

The importance that the classes will get reduced we will not need to write classes again in child classes.
- which class is the root of all the classes ---> `Object Class`
- `Object Class` contains the most common methods for all Java classes.

## Types of Inheritance

### Single inheritance

`Class B extends A` it is possible in Java

### multiple inheritance

multiple inheritance is not possible in Java

`Class C extends A,B` is not possible

### multi-level inheritance

this is possible in Java.

`Class A`
`Class B extends A`
`Class C extends B`

### hierarchial inheritance

it is supported. it means if from one class many classes inherit separately
`Class A`
`Class B extends A`
`Class C extend A`
`Class D extends A`

## Multiple Inheritance

Java provide supports for `multiple inheritance` only in `interface` but not classes. because interfaces are not implementing the classes.
so 
````
interface P1{}
interface P2{}
interface C extends P1,P2
````
is perfectly fine.

- in java 1.8 and onwards we can use `default methods` in interfaces but still multiple inheritance will not make any problem.

if interviewer ask that if every class is the child of `Object` class and the we are extending some classes also. so how is
multiple inheritance not possible in java.

The answer is that when we have simple class i.e `class A` so it is extending from `Object class`. if we have `class B extends A`
than it is extending not from `Object` class but from the `Class A` and then class A is extending Object class.

## Cyclic Inheritance

it is not supported in java.

`class A extends A`  --- not possible
````
class A extends B
class B extends A
````
this also not possible

## Method Signature

what is `method signature` ? 
method signature contains the following
1. Method Name
2. Method arguments types
3. Order of arguments must be same
4. the name of arguments can be different but type must be same

if we have a method let say
`public int m1(int i, float f)`

its method signature is `m1(int, float)`

- in C++ return type is also the part of method signature but in java return type is not.

compiler is using `method signature` to resolve `method calls`.

compiler will maintain a `Method Table` for every class.
if a method signature is not there in a method table for a class and we are trying to call it.
it will give compile time error. suppose we are calling a method with a double value and it is not
present the error message will be.

`cannot find symbol, method m3(double)`

### important

- 2 methods with the same signature is not acceptable in a class.
````
class Test{
public void m1(int i){}   // signature m1(int)
public int m1(int j){return 10}  // signature m1(int)
}
````
the error we get by compiler is.
`method m1 is already defined`

## Overloading Introduction

when methods names are same and arguments are different is called `overloading`.
In C `method overloading` is not available. so there 2 methods with same name is not possible. in C
````
abs(int) // for int data type
labs(long) // for long data type
fabs(float) // for float data type
````
In java we can use same `abs` method for different argument type.
````
abs(int)
abs(long)
abs(float)
````
code complexity decreases in java.

### important

suppose `Test t = new Test()`
here `Test t` is the `reference type`.

in overloading `method resolution` is always taken care by the compiler based on `reference type` but not based on `runtime object`.
that is why `overloading` is also known as `compile time polymorphism` or `static polymorphism` or `early binding`

## Method Overloading case study - 1

````
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
        t.m1('a'); // automatic promotion to int
        t.m1(10l); // automatic promotion to float
        t.m1(10.5); // it is double and we don't have and can't be promoted so compiler error
    }
}
````
the output will be
````
$ java Testtt
int-arg method
float-arg method
int-arg method
float-arg method
````
so if you notice the one with character `t.m1('a')` is promoted to int which is the next higher type. This is called `automatic
promotion`. here is chart for it.

![automatio promotion](./pictures/automatic_promotion_chart.PNG)

so the compiler will not give error immediately. first it will promote the argument to the next level. if there is some type it will use that.

## Method Overloading case study - 2

in case we have overloaded methods of `Object` and `String`
````
class Testttt {
    public void m1(Object o){
        System.out.println("object version");
    }
    public void m1(String s){
        System.out.println("String version");
    }
    public static void main(String[] args){
        Testttt t = new Testttt();
        t.m1(new Object()); // Object version will call
        t.m1("Aamir");      // String version
        t.m1(null);         // null is both String and Object but String will be called
    }
}
````
output is
````
$ java Testttt
object version
String version
String version
````
as you can see `null` can be both `String` and `Object` in such case where we have overloaded methods of both `parent` and `child`
than `child` method will be get called. here `String` is the child of `Object`.

if in case `child` is not present `parent` method will be executed.

## Method Overloading case study - 3

In this case if we have same level child from let say `Object`. than while overloading a `null` value will give error.
because compiler is confuse. `Ambigous method call`

![same level childs](./pictures/same_level_childs.PNG)

````
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
//        t.m1(null); // will give compiler error because String and StringBuffer are same level child from Object
    }
}
````
