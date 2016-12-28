###JDK动态代理
JDK 1.3以后，Java提供了动态代理的技术，允许开发者在运行期创建接口的代理实例。在Sun刚推出动态代理时，还很难想象它有多大的实际用途，
现在我们终于发现动态代理是实现AOP的绝好底层技术。
JDK的动态代理主要涉及到java.lang.reflect包中的两个类：Proxy和InvocationHandler。其中InvocationHandler是一个接口，
可以通过实现该接口定义横切逻辑，并通过反射机制调用目标类的代码，动态将横切逻辑和业务逻辑编织在一起。
而Proxy利用InvocationHandler动态创建一个符合某一接口的实例，生成目标类的代理对象。这样讲一定很抽象，
我们马上着手使用Proxy和InvocationHandler这两个魔法戒对上一节中的性能监视代码进行革新。

###CGLib动态代理
使用JDK创建代理有一个限制，即它只能为接口创建代理实例，这一点我们可从Proxy的接口newProxyInstance(ClassLoader loader,
 Class[] interfaces, InvocationHandler h)的方法签名中就看得很清楚：第二个入参interfaces就是需要代理实例实现的接口列表。
 虽然面向接口编程的思想被很多大师级人物（包括Rod Johnson）推崇，但在实际开发中，许多开发者也对此深感困惑：难道对一个简单
 业务表的操作也需要老老实实地创建5个类（领域对象类、Dao接口，Dao实现类，Service接口和Service实现类）吗？难道不能直接通过
 实现类构建程序吗？对于这个问题，我们很难给出一个孰好孰劣的准确判断，但我们确实发现有很多不使用接口的项目也取得了非常好
 的效果（包括大家所熟悉的SpringSide开源项目）。
对于没有通过接口定义业务方法的类，如何动态创建代理实例呢？JDK的代理技术显然已经黔驴技穷，CGLib作为一个替代者，填补了这个空缺。

###代理知识小结
Spring AOP的底层就是通过使用JDK动态代理或CGLib动态代理技术为目标Bean织入横切逻辑。在这里，我们对前面两节动态创建代理对象作一个小结。

我们虽然通过PerformanceHandler或CglibProxy实现了性能监视横切逻辑的动态织入，但这种实现方式存在三个明显需要改进的地方：
1）目标类的所有方法都添加了性能监视横切逻辑，而有时，这并不是我们所期望的，我们可能只希望对业务类中的某些特定方法添加横切逻辑；
2）我们通过硬编码的方式指定了织入横切逻辑的织入点，即在目标类业务方法的开始和结束前织入代码；
3）我们手工编写代理实例的创建过程，为不同类创建代理时，需要分别编写相应的创建代码，无法做到通用。

以上三个问题，在AOP中占用重要的地位，因为Spring AOP的主要工作就是围绕以上三点展开：Spring AOP通过Pointcut（切点）指定
在哪些类的哪些方法上织入横切逻辑，通过Advice（增强）描述横切逻辑和方法的具体织入点（方法前、方法后、方法的两端等）。
此外，Spring通过Advisor（切面）将Pointcut和Advice两者组装起来。有了Advisor的信息，Spring就可以利用JDK或CGLib的动态代理技术
采用统一的方式为目标Bean创建织入切面的代理对象了。

JDK动态代理所创建的代理对象，在JDK 1.3下，性能强差人意。虽然在高版本的JDK中，动态代理对象的性能得到了很大的提高，
但是有研究表明，CGLib所创建的动态代理对象的性能依旧比JDK的所创建的代理对象的性能高不少（大概10倍）。但CGLib在创建代理对象
时所花费的时间却比JDK动态代理多（大概8倍），所以对于singleton的代理对象或者具有实例池的代理，因为无须频繁创建代理对象
，所以比较适合用CGLib动态代理技术，反之适合用JDK动态代理技术。值得一提的是，由于CGLib采用动态创建子类的方式生成代理对象，
所以不能对目标类中的final方法进行代理。