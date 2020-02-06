# Java Fundamentals

## Getting started

1. Install [JDK](https://openjdk.java.net/).
1. Open [command-line interface](https://en.wikipedia.org/wiki/Command-line_interface#Operating_system_command-line_interfaces).
1. Execute: `javac src/io/humb1t/Main.java`. You can find more information about Java programming language compiler 
[here](https://docs.oracle.com/javase/7/docs/technotes/tools/windows/javac.html).
1. Check that a new file named `Main.class` was created in `src/io/humb1t`.
1. Open the file, it is a [byte code](https://en.wikipedia.org/wiki/Java_bytecode).
1. Execute: `java src/io/humb1t/Main.java`. You can find more information about Java applications runner 
[here](https://docs.oracle.com/javase/7/docs/technotes/tools/windows/java.html).
1. Check the CLI (Command-line interface) output - it should be `Hello, World!`. 
_Notice that result text contains comma and sometimes exclamation mark._

## Exploring Java Objects

1. Try to execute: `javac src/io/humb1t/Main2.java`.
1. Check the CLI output - read the error, why do you think it happened?
1. Execute: `javac src/io/humb1t/*.java`.
1. Check that new files `Main2.class` and `Order.class` were created in `src/io/humb1t`.
1. Execute: `java -cp ./src io.humb1t.Main2`. You can find more information about Java applications runner's
command line arguments [here](https://docs.oracle.com/javase/7/docs/technotes/tools/windows/java.html).
`-cp` is short version of `-classpath` and it _specifies a list of directories, JAR files, 
and ZIP archives to search for class files._ Because we are using dependency from `Main2` to `Order` - we should
provide a path for dependencies' `*.class` files.
1. Check the CLI output - read lines one by one and learn more about objects 
[initialization](https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html).

## 

