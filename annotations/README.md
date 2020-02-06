# Java Annotations

## Code generation

1. The great example of annotations for code generation is [Project Lombok](https://projectlombok.org). 
Look at [description of `ToString`](https://projectlombok.org/features/ToString) feature.
Simple annotation transformed into Java code:
```java
@ToString
public class ToStringExample {
}
```
vs
```java
public class ToStringExample {
 @Override public String toString() {
    return "ToStringExample(" + this.getName() + ", " + this.shape + ", " + Arrays.deepToString(this.tags) + ")";
  }
}
```
1. For more details about annotation processing at compile time recommend you to read 
[this article](http://hannesdorfmann.com/annotation-processing/annotationprocessing101).

##  Runtime and Proxy
1. The other approach would add logic in runtime. The most popular web framework 
[Spring](https://spring.io) uses this technique a lot. Please read their
[blog post](https://spring.io/blog/2012/05/23/transactions-caching-and-aop-understanding-proxy-usage-in-spring)
about `Proxy`. Annotations is only one of possible configurations which was quite popular before `Java` configuration.
You can read more about annotations and Spring in [Baeldung's blog post](https://www.baeldung.com/spring-aop-annotation).


