govchat-dev
===========

The development repo for GovChat. This will used as the example for GovChat development, as the real application will go above and beyond what is here.

The basis of this project can be found in this [Oracle blog post](https://blogs.oracle.com/jtc/entry/javafx_sockets_and_threading_lessons).

#### Style Guide

##### Imports
All import should be listed in alphabetical order, as below:

```java
import java.io.IOException;
import java.net.*;
import javafx.application.Platform;
```

##### Classes
Classes should be formatted as follows:

```java
/**
 * Class description.
 * Longer class description, including functionality and limitations.
 * @author Your Name Here
 */
public class ClassName extends SuperClassName
implements InterfaceOne
implements InterfaceTwo
{
    // Constants listed first
    private static final int CONSTANT_ONE = 1;
  
    // Instance variables
    public String hello = "Hello, world!";
}
```

##### Methods
Methods should be formatted as follows:

```java
/**
 * All public methods need javadoc.
 * This documentation can be generated into helpful web pages like the API online.
 * @param x some parameter description
 * @return some return value description
 */
public int someMethod(int x)
{
    
}
```

##### General Formatting
1. No lines should have text beyond 80 characters
2. There should be a blank line before and after every loop
3. While curly braces for methods and classes occur on the next newline, this is not so for loops and control statements:

```java
public void someMethod(int x)
{
    if (x == 2) {
        System.out.println("Two");
    } else {
        System.out.println("Not two");
    }
}
```
4. Additional clauses (else, else if, catch, etc.) should follow on the same line as the previous curly brace, see above example
