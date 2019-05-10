# What is OOP?

OOP or Object Orientation Programming, is a style of programming that uses real world representations of Objects to preform a task in a program. Java is an Object-Orientated Programing language, meaning that it can be used to make programs that implement objects who have behaviors and attributes. Using OOP methods such as **Objects & Classes**, **Inheritance**, **Encapsulation**, **Abstraction**, and **Polymorphism** (more on that in OOP2), a programmer can create working reusable methods (behaviors) and variables (attributes) who can interact with each other in a hierarchy without a loss in security.

# Objects and Classes

---

In Object-Orientated Programing, the main focus is on the implementation of classes and objects. Objects have **attributes** (representing values of the object) and **behaviors** (representing functions or actions that the object can "preform"). In Java, another characteristic is needed for an Object, it's **reference variable** (an ID of sorts, so that the object can be recognized during runtime). This reference is initialized when an object is made through instantiation. Objects are able to exhibit attributes and behaviors because they are** instances** of a class that defines them.

#### Classes

Now, what is a class then? A class is a blueprint for which objects can be made from. It contains some main characteristics to function properly. Attributes, Behaviors, and **Constructors** (allows the creation of objects within memory). An instance of a class using the keyword **new** creates an object located in the memory during runtime (a reference variable determines the specific object, acts like an ID).

Here is an example class that shows some of the concepts from above using the Programmer class.

```java
class Programmer {
    //declaration of attribute
    String name;

    //defining behaviour program
    public void program(){
        //method 
    }

    //creating main method to run the instance of Programmer inside the Programmer class
    public static void main(String args[]) {
        //Creating an new object through instantiation
        Programmer p = new Programmer();//instance of class Programmer
        p.program();//using the objects' behaviour
        System.out.println(p.name);//accessing an attribute through the reference variable
    }
}  
```

#### Constructors

A **constructor** within a java class is called when an instance of the class is created. It locates the memory needed for the object. Every single time an instance of an object is created, a constructor must be called to create the object. In java there are two types of constructors: **Default constructors** (with no-arg/parameters) and **constructors with parameters**. These constructors initialize the attributes for an object, within a default constructor, the values are default with no parameters (set by the programmer), but in a constructor with parameters, the values are passed into the constructor through the parameters allowing them to be changed.
A constructor can be made using the following template:<code class="prettyprint">&lt;class name>(params){} </code>
If a constructor is not defined by the programmer, than a default constructor is made. A constructor must be present in a class for an instance of the class to be made. Multiple constructors can also be present by making constructors with different parameter lists. This is known as **constructor overloading**.

# Inheritance

---

Inheritance is an OOP concept where one object exhibits the attributes and behaviors of a parent object. This concept is important to the core foundations of OOP as it allows for class hierarchies to form, where one class builds on another using the it's own and the parent's attributes and behaviors.
<br>

#### Sub Classes & Super Classes

**Sub Class/Child Class:** A Subclass is a class which inherits the Super class. It is also called an extended class or a child class.
<br>
**Super Class/Parent Class:** A Superclass is the class from where a subclass inherits it's  features. It is also called a parent class.
<br>

#### Implementing Inheritance

The keyword **extends** allows the implementation of Inheritance within a class. Within inheritance, there are relationships that link classes and there attributes and behaviors. The two relationships are an **IS-A** and **HAS-A** relationships. Sub classes have a IS-A relationship with their super classes, as they are the extension of that class. classes also have HAS-A relationships when the class has a reference to an instance of another class or another instance of the same class.

#### Types of Inheritances

In Java there are 3 basic types of relationships between classes through inheritance:  single, multilevel and hierarchical. There is also multiple and hybrid inheritance, yet they are only achievable by implementing multiple interfaces. In this example, 3 classes are shown using multilevel inheritance



# Encapsulation

---

Encapsulation is a concept in OOP that allows security to be established within classes and hierarchies. This is achieved by using **access modifiers**. By making certain fields **private**, information is protected and is not able to be modified beyond the intentions of the program. Access is given to the fields through **public** method who access the attributes through their class. This way object attributes and components can be re-used without allowing open access to the client.

Encapsulation is yet again a very powerful tool in OOP. It lets the programmer to re-use functionality while still having security within the program. It allows access to components of code to be used as many times as needed with more efficiency, it also allows the programmer to change data without the program crashing

Encapsulation can be thought about using the analogy of a pill capsule as all the data inside a class is put into one unit like a capsule. one pill with many different part within. In Java, the difference is that the data can be accessed and modified through **setter** and **getter** methods. Where getters, "get" the data (Ex. <code class="prettyprint"> public String getName() {} <code>) and setters that "set"/modify the data (Ex. <code class="prettyprint"> public void setName (String name) {} <code>)

#### Access Modifiers

In Java, access modifiers determine the "usefulness" of variables and methods within a program (basically where the memory of said variable/method is cashed). In java there are 4 access modifiers:

- **private:** Means that the modified entity is only available inside the current class.
- **default:** If no modifier is assigned, then the default one is given. Default modifiers are only accessed within a package.
- **protected:** Allows the access to anything within a inheritance hierarchy, it can be applied to data, methods, constructors, but not classes.
- **public:** This modifier means that it is able to be accessed anywhere within a program.

In the example below, the OOP concept, encapsulation, is demonstrated in  a Java program. The attribute "model" is encapsulated by the access modifier private.

# Abstraction

---

Abstraction may not seem like an important concept within OOP, yet is plays a role in keeping one's code neat, tidy, organized, and readable. What data abstraction aims to do, is to represent complex content in a more simplified manner (to be defined later). It's like knowing how to use a computer to type, without knowing the complex systems running behind it. In Java, abstraction is demonstrated with classes, variables, and methods representing more detailed code which is later defined within other layers of the program. It is also yet again another way of allowing content to become reusable within a program.

Abstraction is a process of finding characteristics of a program and only representing the functionality of the program to the client/user. It focuses more on what actions are to be done, then how they are achieved. In Java Abstraction is achieved by **interfaces** and **abstract classes**.

#### Abstract Classes

An Abstract class is any Java class that is declared abstract using the **abstract** keyword. In an abstract class, there can be abstract and non-abstract methods. The class itself needs to be extended and all abstract methods need to be instantiated. The class itself cannot be instantiated. note: Abstract methods do not have implementation, they are implemented later within classes that have extended the abstract class (the abstract methods must be implemented within the subclass unless it is another abstract class)

- Are declared with the abstract keyword.
- May have abstract, non-abstract, and static methods.
- May have constructors.
- Cannot be instantiated.

An example for the usage of abstract classes can be seen in the Shape class and the classes that extend it. In this example the Shape class just shows the functionality of the program and not the math behind it.

#### Interfaces

An Interface is not a class, it acts more like a blueprint of a class. It contains static **finals** (constants) and abstract methods. interfaces can only have abstract methods (and default yet it isn't too important) and is a tool to achieve abstraction and multiple inheritance. in an inheritance hierarchy they represent an IS-A relationship. (note: interfaces like abstract classes cannot be instantiated). Interfaces can be declared using the the **interface** keyword and by following the format: <code class="prettyprint">interface <interface_name>{} </code>
##### Reasons to Use an Interface
There are 3 reasons why interfaces are useful in OOP: They can be used to achieve abstraction, they can show functionality of a program, and they allow for multiple inheritances with interfaces through loose coupling.

In the following example, multiple inheritance is shown. Notice that the methods within the interfaces are not given modifiers (default is abstract)