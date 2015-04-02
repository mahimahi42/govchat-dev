# govchat-dev

The development repo for GovChat. This will used as the example for GovChat development, as the real application will go above and beyond what is here.

The basis of this project can be found in this [Oracle blog post](https://blogs.oracle.com/jtc/entry/javafx_sockets_and_threading_lessons).

#### Running This Example
Import the project into NetBeans, then run the `GCLauncher.java` file. This will allow you to spawn both a server and client to try.

#### Style Guide

##### Imports
All import should be listed in alphabetical order, as below:

```java
import java.io.IOException;
import java.net.Socket;
import javafx.application.Platform;
```

If you are using less than six classes from an imported package, import each class individually. If you're using more than six, use the `*` wildcard:

```java
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
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

// Classes with only interfaces should be as follows
public class ClassName implements InterfaceOne
implements InterfaceTwo
{}
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
- No lines should have text beyond 80 characters
- There should be a blank line before and after every loop
- While curly braces for methods and classes occur on the next newline, this is not so for loops and control statements:

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
- Additional clauses (else, else if, catch, etc.) should follow on the same line as the previous curly brace, see above example
