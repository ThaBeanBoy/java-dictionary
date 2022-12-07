# Java Dictionary - Generics Experiment

## Description

In this project, I wanted to experiment with 2 things, mainly:
- Generics
- Throwing custom exception

## Generics

### Dictionary Class - Using Generics

Generics are so easy to implement in Java. It's just a matter of putting the typenames in angle brackets

The reason why I made the keys a set, is because it would be better if each key had a unique name.
Whereas the values could be in an ArrayList. The reason I picked an array list was because I 
assumed the size of the dictionary would increase & decrease.
```java
import java.util.HashSet;
import java.util.ArrayList;

public class Dictionary <T, K> {
    final private HashSet<T> _keys;
    final private ArrayList<K> _values;
}
```

## Throwing Custom Exceptions

### InvalidKeyException
Making the custom Exception class was really easy, I just had to extend the Exception class &
call the constructor of the Exception.

[Resource that helped](https://www.baeldung.com/java-new-custom-exception)

```java
public class InvalidKeyException extends Exception{
    public InvalidKeyException(){
        super("Invalid key");
    }
}
```
### Throwing InvalidKeyException
Throwing the exception was really easy, I used an Iterator that would loop through all the 
keys, if a key has the same name as the key passed in as an argument, the value will be returned.
In the case that a key is not found, an InvalidKeyException is thrown. 
```java 
public K retrieve(T key) throws InvalidKeyException{
    Iterator<T> it = _keys.iterator();

    int indexToReturn = 0;
    while(it.hasNext()){
        T current = it.next();

        if(current.equals(key)){
            return _values.get(indexToReturn);
        }

        indexToReturn++;
    }

    // The key was not found
    throw new InvalidKeyException();
}
```