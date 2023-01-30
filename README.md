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
