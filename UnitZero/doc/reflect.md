Java语言允许通过程序化的方式间接对Class进行操作，Class文件由类装载器装载后，在JVM中将形成一份描述Class结构的元信息对象，
通过该元信息对象可以获知Class的结构信息：如构造函数、属性和方法等。Java允许用户借由这个Class相关的元信息对象间接调用
Class对象的功能，这就为使用程序化方式操作Class对象开辟了途径。

在ReflectTest中，使用了几个重要的反射类，分别是ClassLoader、Class、Constructor和Method，通过这些反射类就可以间接调用目标Class的各项功能了。
在①处，我们获取当前线程的ClassLoader，然后通过指定的全限定类“com.baobaotao.beans.Car”装载Car类对应的反射实例。
在②处，我们通过Car的反射类对象获取Car的构造函数对象cons，通过构造函数对象的newInstrance()方法实例化Car对象，其效果等同于new Car()。
在③处，我们又通过Car的反射类对象的getMethod（String methodName,Class paramClass）获取属性的Setter方法对象，
第一个参数是目标Class的方法名；第二个参数是方法入参的对象类型。获取方法反射对象后，
即可通过invoke（Object obj,Object param）方法调用目标类的方法，该方法的第一个参数是操作的目标类对象实例；第二个参数是目标方法的入参。

####类装载器ClassLoader
#####类装载器工作机制
类装载器就是寻找类的节码文件并构造出类在JVM内部表示对象的组件。在Java中，类装载器把一个类装入JVM中，要经过以下步骤：
[1.]装载：查找和导入Class文件；
[2.]链接：执行校验、准备和解析步骤，其中解析步骤是可以选择的：
    [2.1]校验：检查载入Class文件数据的正确性；
    [2.2]准备：给类的静态变量分配存储空间；
    [2.3]解析：将符号引用转成直接引用；
[3.]3．初始化：对类的静态变量、静态代码块执行初始化工作。

类装载工作由ClassLoader及其子类负责，ClassLoader是一个重要的Java运行时系统组件，它负责在运行时查找和装入Class字节码文件。
JVM在运行时会产生三个ClassLoader：根装载器、ExtClassLoader（扩展类装载器）和AppClassLoader（系统类装载器）。其中，
根装载器不是ClassLoader的子类，它使用C++编写，因此我们在Java中看不到它，根装载器负责装载JRE的核心类库，如JRE目标下的rt.jar、charsets.jar等。
ExtClassLoader和AppClassLoader都是ClassLoader的子类。其中ExtClassLoader负责装载JRE扩展目录ext中的JAR类包；
AppClassLoader负责装载Classpath路径下的类包。

这三个类装载器之间存在父子层级关系，即根装载器是ExtClassLoader的父装载器，ExtClassLoader是AppClassLoader的父装载器。
默认情况下，使用AppClassLoader装载应用程序的类

JVM装载类时使用“全盘负责委托机制”，“全盘负责”是指当一个ClassLoader装载一个类的时，除非显式地使用另一个ClassLoader，
该类所依赖及引用的类也由这个ClassLoader载入；“委托机制”是指先委托父装载器寻找目标类，只有在找不到的情况下才从自己的
类路径中查找并装载目标类。这一点是从安全角度考虑的，试想如果有人编写了一个恶意的基础类（如java.lang.String）并装载到
JVM中将会引起多么可怕的后果。但是由于有了“全盘负责委托机制”，java.lang.String永远是由根装载器来装载的，这样就避免了上述事件的发生。


#####ClassLoader重要方法

在Java中，ClassLoader是一个抽象类，位于java.lang包中。下面对该类的一些重要接口方法进行介绍：
Class loadClass(String name)
    name参数指定类装载器需要装载类的名字，必须使用全限定类名，如com.baobaotao. beans.Car。
 该方法有一个重载方法loadClass(String name ,boolean resolve)，resolve参数告诉类装载器是否需要解析该类。在初始化类之前，
 应考虑进行类解析的工作，但并不是所有的类都需要解析，如果JVM只需要知道该类是否存在或找出该类的超类，那么就不需要进行解析。
Class defineClass(String name, byte[] b, int off, int len)
   将类文件的字节数组转换成JVM内部的java.lang.Class对象。字节数组可以从本地文件系统、远程网络获取。name为字节数组对应的全限定类名。
Class findSystemClass(String name)
   从本地文件系统载入Class文件，如果本地文件系统不存在该Class文件，将抛出ClassNotFoundException异常。该方法是JVM默认使用的装载机制。
Class findLoadedClass(String name)
  调用该方法来查看ClassLoader是否已装入某个类。如果已装入，那么返回java.lang.Class对象，否则返回null。如果强行装载已存在的类，将会抛出链接错误。
ClassLoader getParent()
   获取类装载器的父装载器，除根装载器外，所有的类装载器都有且仅有一个父装载器，ExtClassLoader的父装载器是根装载器，
   因为根装载器非Java编写，所以无法获得，将返回null。

#####Java反射机制

Class反射对象描述类语义结构，可以从Class对象中获取构造函数、成员变量、方法类等类元素的反射对象，并以编程的方式通过这些反射对象
对目标类对象进行操作。这些反射对象类在java.reflect包中定义，下面是最主要的三个反射类：
  Constructor：类的构造函数反射类，通过Class#getConstructors()方法可以获得类的所有构造函数反射对象数组。
在JDK5.0中，还可以通过getConstructor(Class... parameterTypes)获取拥有特定入参的构造函数反射对象。
Constructor的一个主要方法是newInstance(Object[] initargs)，通过该方法可以创建一个对象类的实例，相当于new关键字。
在JDK5.0中该方法演化为更为灵活的形式：newInstance (Object... initargs)。

  Method：类方法的反射类，通过Class#getDeclaredMethods()方法可以获取类的所有方法反射类对象数组Method[]。
在JDK5.0中可以通过getDeclaredMethod(String name, Class... parameterTypes)获取特定签名的方法，name为方法名；Class...为方法入参类型列表。
Method最主要的方法是invoke(Object obj, Object[] args)，obj表示操作的目标对象；args为方法入参，代码清单3 10③处演示了这个反射类的使用方法。
在JDK 5.0中，该方法的形式调整为invoke(Object obj, Object... args)。此外，Method还有很多用于获取类方法更多信息的方法：
     1）Class getReturnType()：获取方法的返回值类型；
     2）Class[] getParameterTypes()：获取方法的入参类型数组；
     3）Class[] getExceptionTypes()：获取方法的异常类型数组；
     4）Annotation[][] getParameterAnnotations()：获取方法的注解信息，JDK 5.0中的新方法；

  Field：类的成员变量的反射类，通过Class#getDeclaredFields()方法可以获取类的成员变量反射对象数组，
通过Class#getDeclaredField(String name)则可获取某个特定名称的成员变量反射对象。Field类最主要的方法是set(Object obj, Object value)，
obj表示操作的目标对象，通过value为目标对象的成员变量设置值。如果成员变量为基础类型，用户可以使用Field类中提供的带类型名的值设置方法，
如setBoolean(Object obj, boolean value)、setInt(Object obj, int value)等。
