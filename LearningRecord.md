#新特性

Lambda expression − Adds functional processing capability to Java.

Method references − Referencing functions by their names instead of invoking them directly. Using functions as parameter.

Default method − Interface to have default method implementation.

New tools − New compiler tools and utilities are added like ‘jdeps’ to figure out dependencies.

Stream API − New stream API to facilitate pipeline processing.

Date Time API − Improved date time API.

Optional − Emphasis on best practices to handle null values properly.

Nashorn, JavaScript Engine − A Java-based engine to execute JavaScript code.

lamda表达式，为java语言提供函数式编程。
方法引用，使用函数作为参数。类似函数指针或者函数回调或传入一个接口。(只是提供方便，使得编程更为简洁，技术的发展都是这样，革新性的创举都是少数的)
接口的默认方法。(对于前后版本兼容和整体框架重构很为重要)
新工具？jdeps？不理解。
流式操作。stream api提供管道式操作。(并行流，简化编程人员并行操作的难度）
新的时间API
Optional ？空值处理。
 JavaScript Engine。

#lamda替代匿名内部类
Lambda expression eliminates the need of anonymous class and gives a very simple yet powerful functional programming capability to Java.

lamda的scope问题
Using lambda expression, you can refer to any final variable or effectively final variable (which is assigned only once). Lambda expression throws a compilation error, if a variable is assigned a value the second time.
类似匿名内部类参数必须是final类型。

函数接口->只有一个函数的接口
Functional interfaces have a single functionality to exhibit. 

Java 8 has defined a lot of functional interfaces to be used extensively in lambda expressions.

系统定义了很多函数接口，对应使用在拉姆达表达式中，比如Consumer和Predicate接口，
前者接受一个数据没有返回值，接口方法accept。
后者predicate接口方法，接收一个数据返回一个boolean数据，可以用于对数据的筛选和验证。
系统预置的类似的函数接口用于辅助实现函数接口传递，用户传参可以传入控制行为，是对编程形式的一步归纳，这是一个思想，也是和面向接口编程的思想一致的。

设计模式无外乎两点：面向接口编程和优先使用组合，重在思想而不是拘泥于形式，万般变化于心，无招胜有招。

Default Methods.
为了使得之前的接口能够支持lamda表达式，增加一个接口的默认实现。
Java 8 introduces a new concept of default method implementation in interfaces. This capability is added for backward compatibility so that old interfaces can be used to leverage the lambda expression capability of Java 8. 
直接在根部接口添加方法，并增加默认实现。
比如foreach方法，Collection和List接口没有foreach的声明，在Iterable里添加ForEach的默认实现，使得Collection和List能够利用这个默认实现。
public interface Collection<E> extends Iterable<E> 

iterable中
    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }

？？关于静态方法的重写，是否有多态性？普通类，抽象类，接口实现类。

java提供自身的sort方法，其效率会高于大多数的程序员自己所写的排序算法，而实际场景中对效率要求很严格的比例又不是那么大，重要的是这些模板函数的效率再不断提高，针对不同场景有不同的使用方法，而且利用其编写代码很省事。
类似的java8提出Stream流概念，声明式的使用，主要潜力在多核处理并行编程上，使得开发者能够较为省力的利用并行的优势，而不必去过多地关注并行控制细节，一句话概括就是在多数场景下使得我们能够高效地编写稳定安全又高效的代码来利用并行计算能力。
编码高效和代码能力高效。


#Stream&ParallelStream
提供聚合运算，流式输出，中间值。Collector 和 Collectors。java新添加接口以及代码重构。

Stream is a new abstract layer introduced in Java 8. Using stream, you can process data in a declarative way similar to SQL statements. For example, consider the following SQL statement.
SELECT max(salary),employee_id,employee_name FROM Employee
The above SQL expression automatically returns the maximum salaried employee's details, without doing any computation on the developer's end. Using collections framework in Java, a developer has to use loops and make repeated checks. Another concern is efficiency; as multi-core processors are available at ease, a Java developer has to write parallel code processing that can be pretty error-prone.
Sequence of elements − A stream provides a set of elements of specific type in a sequential manner. A stream gets/computes elements on demand. It never stores the elements.

主要特点
Source − Stream takes Collections, Arrays, or I/O resources as input source.

Aggregate operations − Stream supports aggregate operations like filter, map, limit, reduce, find, match, and so on.

Pipelining − Most of the stream operations return stream itself so that their result can be pipelined. These operations are called intermediate operations and their function is to take input, process them, and return output to the target. collect() method is a terminal operation which is normally present at the end of the pipelining operation to mark the end of the stream.

Automatic iterations − Stream operations do the iterations internally over the source elements provided, in contrast to Collections where explicit iteration is required.

#Optional Class
Optional is a container object used to contain not-null objects. Optional object is used to represent null with absent value. This class has various utility methods to facilitate code to handle values as ‘available’ or ‘not available’ instead of checking null values. It is introduced in Java 8 and is similar to what Optional is in Guava.

有何作用？对于空值进行了一封装，针对空值是否能够设计一个狂降，进行统一处理。

Optional.of，   ofNullable，
isPresent，
 get，orElse()

#Nashorn JavaScript

#new date time api
With Java 8, a new Date-Time API is introduced to cover the following drawbacks of old date-time API.
Not thread safe − java.util.Date is not thread safe, thus developers have to deal with concurrency issue while using date. The new date-time API is immutable and does not have setter methods.

Poor design − Default Date starts from 1900, month starts from 1, and day starts from 0, so no uniformity. The old API had less direct methods for date operations. The new API provides numerous utility methods for such operations.

Difficult time zone handling − Developers had to write a lot of code to deal with timezone issues. The new API has been developed keeping domain-specific design in mind.

java8
Local − Simplified date-time API with no complexity of timezone handling.

Zoned − Specialized date-time API to deal with various timezones.

#base64
三种类型basic url 和mime
basic和url的区别在于内部使用的编码表有差别，toBase64和toBase64URL，实际上就是最后两个+ 和/ 换成了-和_，主要在于base64编码数据中的前两者在url传输的时候会转换成%XX的形式，对应数据在数据库存储的时候会出问题，%是通配符，还要再次转换才可存储，因此URLSafe的base64编码将对应字符换成-和_。

basic和mime的区别在于后者添加分隔符\r\n，MIMELINEMAX为76。

base64用途，简单的加密，不可读；二进制数据传输，http中传输的二进制进行编码得到字符串。
3字节->4字节。3*8 = 4*6 高位不0，不足3的倍数的，补0，对应的字符表元素“=”。
二进制转文本的另一个思路二进制的十六进制表示映射成字符串。1字节->2字节。

@Arrays.asList方法返回的是一个固定长度的list，支持随机访问，不能进行add。实际上返回的这个arraylist是Arrays的内部类，不像util包下的arraylist拥有那么多可操作的方法。