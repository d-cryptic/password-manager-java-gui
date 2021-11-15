// objects define their interaction with the outside world through the methods that they expose. Methods form the object's interface with the outside world; 
// an interface is a group of related methods with empty bodies.

// An interface in Java is a blueprint of a class. It has static constants and abstract methods.

// The interface in Java is a mechanism to achieve abstraction. 
//There can be only abstract methods in the Java interface, not method body. 
//It is used to achieve abstraction and multiple inheritance in Java.

// In other words, you can say that interfaces can have abstract methods and variables. It cannot have a method body.

// Java Interface also represents the IS-A relationship.

// There are mainly three reasons to use interface. They are given below.

// It is used to achieve abstraction.
// By interface, we can support the functionality of multiple inheritance.
// It can be used to achieve loose coupling.


public interface hashTableMap {

    Object get_Acc(Object Account);
    int add_Acc(Object Account, Object passwd);
    Object remove_Acc(Object Account);
}

// HashMap and Hashtable store key and value pairs in a hash table. 
// When using a Hashtable or HashMap, we specify an object that is used as a key and the value that you want to be linked to that key.
//The key is then hashed, and the resulting hash code is used as the index at which the value is stored within the table

//HashMap is non-synchronized. It is not thread-safe and can’t be shared between many threads without proper synchronization code whereas Hashtable is synchronized. It is thread-safe and can be shared with many threads.
// HashMap allows one null key and multiple null values whereas Hashtable doesn’t allow any null key or value.
//HashMap is generally preferred over HashTable if thread synchronization is not needed