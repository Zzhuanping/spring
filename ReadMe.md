# 2023年9月4日
> 一 .不使用new创建对象
 * 反射

> 二.如何使用反射创建的对象？<br>  

1. 加载bean.xml文件
2. 对xml文件进行解析操作
``` 
ApplicationContext context =
 new ClassPathXmlApplicationContext("bean.xml");
    User zhang = (User)context.getBean("user");         
```        
3. 获取xml文件bean的id和class属性

> 三.创建好的对象会放在哪儿

一个map集合中，Map<key,BeanDefinition> beanDefinitionMap函数中<br>
**key**: 唯一标识<br>
**value**: 类的定义，就是从这儿获取类的字节码文件

# 2023年9月5日
> 一. log4j2 添加日志

用于替换system.out.print()
#### 错误等级: TRACE<DUBUG<INFO(使用最多)<WARN<ERROR<br>

> 二. 容器: IoC

“ 控制反转 ” 一种面向对象的编程法则并非技术，能够设计出松耦合、更优良的程序
spring通过使用IoC容器来管理所有 **Java** 对象的实例化和初始化，控制对象与对象之间的依赖关系。<br>
由IoC容器管理的所有Java对象称为 **spring bean**，和使用new创建的对象没有任何区别

### 步骤
+ 创建xml配置文件，bean定义信息beanDefinition
+ 通过抽象接口 BeanDefinitionReader中的不同方法读取不同类型的配置文件
+ 通过以上的函数将**bean定义信息**加载到IoC容器中
+ IoC中BeanFactory工厂+ **反射** 将bean给实例化<br>
反射实现<br>
``
User user = Class.forName("类名");
user.getDeclaredConstructor().newInstance();   
        创立对象
``
+ 初始化对象之后通过getBean()获取最终可以使用的对象

### 控制反转
- 将对象的创建权利交给第三方容器 **IoC** 管理
- 把对象和对象之间的关系的维护权也交出去，由第三方容器管理

**依赖注入**（DI） 用于实现这种思想

> 三. 1-bean管理xml
1. 新建xml文件<br>
`` 创建User类的对象：<bean id="user" class="com.zhang.jie.User"></bean>``

+ 通过id获取bean
``` User user = (User)context.getBean("user");```

+ 通过类型
``(User)context.getBean(User.class)``

+ 通过 Id 和类型
``context.getBean("user", User.class)``

以上三种方式获取到的bean都是一样的

# 2023年9月7日

1. 通过 **类型** 得到bean时，xml文件中指定类型的bean有且只有一个：单实例

`` 报错: expected single matching bean but found 2: user,user1``

# 2023年9月8日

> 一. 依赖注入

类有属性，创建对象过程中，向属性设置值

### 1. 基于set方法
1. 传概念类定义属性，类文件中写好set方法 toString等

``  
<bean id="book" class="com.zhang.jie.di.Book">
<property name="name" value="java开发"/>
<property name="author" value="四川轻化工大学"/>
</bean>
name对应类中的属性，value对应需要设置的值
``


### 2. 基于构造器
``    
<bean id="book2" class="com.zhang.jie.di.Book">
<constructor-arg name="name" value="单片机入门"/>
<constructor-arg name="author" value="入门到送外卖"/>
 </bean>
``

**name**对应类中的属性，**value**对应需要设置的值

### 3. 传递特殊值

1. 字面量赋值：<br>

```<property name="author" value="四川轻化工大学"/> ```

2. 传递空值

``` 
 <property name="other" >
            <null/>
        </property>
不能直接把value处写成null，会被识别成字符串
```
3. xml实体

转义特殊字符&lt; |||| &gt;

4. CDATA节

```
<property name="other" >
           <value> <![CDATA[ 这里写内容 ]]> </value>
        </property>
```

### 4. 特殊类型赋值

1. 对象赋值

+ 外部bean

```
<bean id="dept" class="com.zhang.jie.ditest.Dept">
        <property name="dname" value="AD"/>
    </bean>
      ===========================================    
    <bean id="emp" class="com.zhang.jie.ditest.emp">
<!--        普通类型注入-->
        <property name="name" value="lisa"/>
        <property name="age" value="20"/>
<!--        对象注入 通过 <ref>  拿到bean-->
        <property name="dept" ref="dept"/>
    </bean>
```

重点是**ref**引用

# 2023年9月9日

+ 内部bean的方式
```
<bean id="emp1" class="com.zhang.jie.ditest.emp">
        <property name="name" value="小帅"/>
        <property name="age" value="21"/>
<!--将需要赋值的类放到pro标签中-->
        <property name="dept">
            <bean id="dept1" class="com.zhang.jie.ditest.Dept">
                <property name="dname" value="财务中心"/>
            </bean>
        </property>
    </bean>
```
+ 级联样式是在外联的基础上改变值<br>

**注意** 使用级联需要在emp类中添加上层类的getter
```
    <bean id="dept3" class="com.zhang.jie.ditest.Dept">
        <property name="dname" value="管教中心（级联）"/>
    </bean>

    <bean id="emp" class="com.zhang.jie.ditest.emp">
        <property name="name" value="王大"/>
        <property name="age" value="20"/>
        <property name="dept" ref="dept3"/>
        <property name="dept.dname" value="null"/>
    </bean>
   
```
2. 数组赋值

```
在类中新建一个loves的数组，通过array标签多个赋值
 private String[] loves;
 <property name="loves">
            <array>
                <value>eat</value>
                <value>sleep</value>
                <value>drink</value>
            </array>
        </property>

```

# 2023年9月11日

3. 集合赋值--list

```
<bean id="dept" class="com.zhang.jie.ditest.Dept">
        <property name="dname" value="环境保护"/>
        <property name="emplist">
1.   用list标签来引入需要用的值，这里是对象所以用ref，一般使用 value
            <list>
                <ref bean="emp1"/>
                <ref bean="emp2"/>
            </list>
        </property>
    </bean>
1. 第一个员工信息
    <bean id="emp1" class="com.zhang.jie.ditest.emp">
        <property name="name" value="zhou"/>
        <property name="age" value="20"/>
    </bean>
2. 第二个员工信息
    <bean id="emp2" class="com.zhang.jie.ditest.emp">
        <property name="name" value="huan"/>
        <property name="age" value="21"/>
    </bean>
```

# 2023年9月12日

1. Map集合赋值

```
1.在类中创建好map属性

  private Map<String,Teacher> teacherMap;
  
2.新建xml文件，创建map中需要传入的teacher对象

    <bean id="teacone" class="com.zhang.jie.dimap.Teacher">
        <property name="tname" value="王老师"/>
        <property name="tid" value="01"/>
    </bean>

    <bean id="teactwo" class="com.zhang.jie.dimap.Teacher">
        <property name="tname" value="刘老师"/>
        <property name="tid" value="02"/>
    </bean>

3. 新建学生bean，并把老师的对象用map标签entry标签作内嵌赋值

 <bean id="stu" class="com.zhang.jie.dimap.Student">
<!--        普通-->
        <property name="sname" value="xiaowang"/>
        <property name="sid" value="011"/>
<!--        Map集合-->
        <property name="teacherMap">
            <map>
<!--        第一个教师对象-->
                <entry>
                    <key>
                        <value>1000</value>
                    </key>
                    <ref bean="teacone"/>
                </entry>
<!--                第二个对象-->
                <entry>
                    <key>
                        <value>2000</value>
                    </key>
                    <ref bean="teactwo"/>
                </entry>
            </map>
        </property>
    </bean>

```
2. 给引用类型集合的bean赋值

```

1. 新建xml文件，改写配置，添加上util单元

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/util
       http://www.springframework.org/schema/util/spring-util.xsd">

2.正常创建好老师的bean、课程的bean

3.使用util标签，map需要用entry标签赋值

 <util:list id="lessonList">
        <ref bean="lessC"/>
        <ref bean="lessM"/>
    </util:list>
    <util:map id="teacherMap">
        <entry>
            <key>
                <value>100</value>
            </key>
            <ref bean="teacC"/>
        </entry>
        <entry>
            <key>
                <value>200</value>
            </key>
            <ref bean="teacM"/>
        </entry>
    </util:map>

4.在学生类中使用ref属性来得到util的值

 <bean id="stu" class="com.zhang.jie.dimap.Student">
<!--       普通-->
        <property name="sname" value="小王"/>
        <property name="sid" value=" 001"/>
<!--        list和map属性
            ref引用的名字需要和util的id相同
-->
        <property name="lessonList" ref="lessonList"/>
        <property name="teacherMap" ref="teacherMap"/>
    </bean>

```

3. p命名空间赋值
```
  添加约束
  xmlns:p="http://www.springframework.org/schema/p"
 
  新建bean对象，使用属性赋值而不是标签
    <bean id="student1" class="com.zhang.jie.dimap.Student"
    p:sname="zhangjie" p:sid="100" p:teacherMap-ref="teacherMap" p:lessonList-ref="lessonList">
    </bean>
```

# 2023年9月13日

1. 引用外部属性文件

> 有多个bean时，方便修改

### 以连接数据库为例

1. 新建properties后缀文件
```

jdbc.user=root
jdbc.password=10086
jdbc.url=jdbc:mysql://localhost:3306/test
jdbc.driver=com.mysql.jdbc.Driver

```
2. 新建xml文件添加规范

```
 xmlns:context="http://www.springframework.org/schema/context"
 
  xsi:schemaLocation="
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd

```
3. 注入信息

```

<!--    引入外部属性文件-->

    <context:property-placeholder location="classpath:jdbc.properties"/>

<!--    数据库信息的注入-->

    <bean id="DruidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
<!--        表达式 ${ }     -->
        <property name="url" value="${jdbc.url}"/>
        <property name="password" value="${jdbc.password}"/>
        <property name="username" value="${jdbc.user}"/>
        <property name="driverClassName" value="${jdbc.driver}"/>

    </bean>

```

### 与传统连接数据库方式对比

```
   DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("10086");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

```

###  bean的作用域

通过配置bean标签中scop属性来指定bean的作用范围

1. singleton 默认

>在IoC容器中只有一个对象实例 ---IoC容器初始化时

2. prototype 

> 这个bean始终有多个实例    ----获取bean时

```
<bean id="orders" class="com.zhang.jie.scope.Order" scope="prototype"/>
重复getBean得到的实例不同

```

# 2023年9月14日

> 一 **bean**生命周期

1. bean对象的创建（调用无参构造）<br>

新建一个名为User的类

```
   public User() {
        System.out.println("1 调用无参数构造 创建bean对象");
    }
```

2. 给bean对象设置相关属性

```
 public void setName(String name) {
        this.name = name;

        System.out.println("2 给bean对象设置属性值");
    }
```

3. bean后置处理器（初始化之前）

```
新建一个类MyBeanPost实现BeanPostProcessor接口
覆写方法
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("3 bean的后置处理器--在初始化之前启动");
        System.out.println(beanName+"::"+ bean);

        return bean;
    }


```

4. bean对象的初始化（调用指定的方法）

```
xml中bean标签的属性值
init-method="initme" 
user类中
public void initme(){
System.out.println("4 调用指定方法用于初始化");
    }

```

5. bean的后置处理器（处理之后）

```
 @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {


        System.out.println("5 bean的后置处理器--在初始化以后执行");
        System.out.println(beanName+"::"+ bean);

        return bean;
    }

```

6. bean对象创建完成了，可以被正常使用

```

注意这里使用的不是Application接口，而是原生类方便后面调试销毁方法

 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-life.xml");
        User user1 = (User)context.getBean("demo");
        System.out.println("6 使用bean"+user1);
```

7. bean的对象销毁

```
User类：
   public void destm(){
            System.out.println("7 bean调用指定方法用于销毁");
    }
    
xml中bean标签的属性值  

destroy-method="destm"  

测试文件
  context.close();

```
8. IoC容器关闭

> 二 FactoryBean机制

配置一个factorybean类型的bean，在获取的时候并不是得到class中定义的类
而是得到getObject()方法的返回值，用于将复杂组件的创建过程给封装屏蔽掉，只留下简洁的使用界面

1. 创建一个类实现接口FactoryBean<User>

```

覆写两个方法，并把希望返回的对象写成返回值
public class MyFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
//         反射机制拿到想要创建类的字节码文件    
        return User.class;
    }


}
```

2. 配置xml文件

```

<bean id="user" class="com.zhang.jie.factorybean.MyFactoryBean"/>
不是得到该类的实例，而是该类方法中返回值的实例


```


> 三 基于xml的自动装配

controller service dao三层结构 其中service和dao分别作为接口用于实现具体方法

在前置层中设置好下一层的属性，并使创建set方法用于赋值

在xml文件中利用bean中的 **autowire="byType"**   属性完成自动寻找对应类型的方法
```
<bean id="controller" class="com.zhang.jie.auto.controller.UserController" autowire="byType"/>

    <bean id="service" class="com.zhang.jie.auto.service.UserServiceimp" autowire="byType"/>
    
    <bean id="dao" class="com.zhang.jie.auto.dao.UserDaoimp"/>

```
这样，在controller这个bean中会自动的寻找set方法对应的那个实例并将它给实例化


第二种 在xml文件中通过autowrie=byname这种方式完成装配，这种方式更加直观通过bean的id和类中需要装配的类的属性名相同即可

```
类中：

   private UserDao userDao;
   
   private UserService userService;
   
xml文件中：
 <bean id="controller" class="com.zhang.jie.auto.controller.UserController" autowire="byName"/>

        <bean id="userService" class="com.zhang.jie.auto.service.UserServiceimp" autowire="byName"/>

        <bean id="userDao" class="com.zhang.jie.auto.dao.UserDaoimp"/>

```

# 2023年9月15日

基于**注解**管理bean
 代码中一种特殊的标记，格式：@注解名(多个属性=属性值)

1. 引入相关依赖
   + log4j2日志输出
   + spring

2. 开启组件扫描
    ```
   添加context的命名空间
   xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
       http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
   
   使用标签context规范需要扫描的包路径
    <context:component-scan base-package="zhou.huan"/>
   
   ```
> 使用注解来定义类成spring bean，用于标记类的注解

### @component
 
+ 该注解描述spring中的bean是一个泛化的概念，仅仅表示容器中的一个组件（Bean），并且可以作用于任何的层次中，使用时只需要在类上标注即可

```

@Component(value = "nihao")
 
 //bean id="名字" 如果默认就是类名的首字母小写

```

### @Repository

+ 用于标记数据访问层（Dao），功能与component相同

### @Service

+ 用于标记业务层，并将其视为spring所管理的bean

### @Controller

+ 用于标记控制层，并将其视为spring所管理的bean

> 用于赋值注入的注解

### @Autowried

+  单独使用时 默认根据类型装配byType（属性）
  +  注解范围：
      + 构造器
      ```
         private UserService userService;

      @Autowired
      public UserController(UserService userService) {
          this.userService = userService;
      }
     ``` 
      + setter方法
      ```
         private UserService userService;
        @Autowired
        public void setUserService(UserService userService) {
        this.userService = userService;
        }
     
     ```
      
      + 形参
       
      ```
     就是在构造器的参数上打注解
      private UserService userService;

      public UserController(@Autowired  UserService userService) {
          this.userService = userService;
      }
     ``` 
      + 属性（对象）
      ```
      属性注入
      @Autowired //会根据类型自动找到对象接口，完成注入
      private UserService userService;

      @Autowired
      private UserDao userDao;


     ``` 
      + 注解<br>
      
      ```
        
         // value是bean的名称，可以解决多个实现类冲突的问题
        @Qualifier(value = "")
           @Autowired
         @Qualifier(value = "userReditsDaoimp")
         private UserDao userDao;

            public UserServiceImp(@Qualifier("userDaoImp") @Autowired UserDao userDao) {
            this.userDao = userDao;
            }
      
        ```
     
在注入时，被注入的bean必须存在不然会报错，因为存在required()


### Resource

+ 适用范围
  + 属性
  + setter方法
  
+ 所需依赖
  + 1.8< jdk | jdk > 11 才需要依赖


该注解属于是JDK的一部分，是标准注解更加具有通用性
@Autowried注解是spring框架自己的

@Resource默认byName，没有指定名称时，使用属性名作为name，通过name找不到的话会自动启用byType

@Autowried 默认byType 想要使用名称装配需要搭配上@Qualifier

1. 默认使用id注入
```
被注入的类id为myUserServiceImp 
        @Service(value = "myUserServiceImp")
    public class UserServiceImp implements UserService {
    
    
    将id放入该标签的name属性中
  @Resource(name = "myUserServiceImp")        //根据名称注入--名字就是需要注入类的id
    private UserService userService;
```   

2. 使用属性名注入
```
使用属性名注入--不需要写注解的属性值
    @Service(value = "myUserServiceImp")
    public class UserServiceImp implements UserService {
    
    
    
    @Resource     //根据属性名和类的id去寻找匹配
    private UserService myUserServiceImp;
 

```

3. 什么也不写的情况下识别成byType

```

  @Resource // 不写name属性
    private UserDao userDao;
    
    //类名和属性名不相同，说明是按照类型注入
    @Repository(value = "myUserDaoImp")
    public class UserDaoImp implements UserDao {


```


# 2023年9月16日

> 全注解开发----使用配置类来替代配置文件xml

```
打上标记类的注解
@Configuration      //标志为配置类
@ComponentScan("zhou.huan.bean")        //开启组件扫描

启动类中新建AnnotationConfigApplicationContext，并得到配置类的class文件

ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
```

### IoC的实现

对于任意一个类都能知道他的所有属性和方法，对于任意一个对象都能调用它的任意方法和属性，这种动态实时获取对象方法的功能就是反射机制

反射机制指的就是能够运行时获取自身的信息。

####  Class class1 = Car.class;   //通过类名.class

#### Class class2 = new Car().getClass(); // getClass()

#### Class class3 = Class.forName("com.zhang.jie.Car") ;   //Class.forName(全路径)


实例化对象的方法

        Car car = (Car) class1.getDeclaredConstructor().newInstance();

        通过Class提供的方法，然后将返回值返回到原本的类再类型强转

拿到类中的构造器

```
      
得到构造器数组getConstructors，
        1. getDeclaredConstructors()得到全部的构造方法包括私有。
        2. getConstructors只能拿到类中的public构造方法
      
      Constructor[] constructors = class1.getConstructors();
      
      Constructor[] declaredConstructor = class1.getDeclaredConstructors();

        for (Constructor c :declaredConstructor) {
            System.out.println("构造器名字： "+c.getName()+"构造器的参数个数"+c.getParameterCount());
        }
```
针对使用public权限的构造器

```

Constructor constructor = class1.getConstructor(String.class, int.class, String.class);

Car car = (Car)constructor.newInstance("宾利", 10, "黑色");
```


使用private权限的构造器，除了需要设置访问权限以外别的操作都一样

```

Constructor constructor02 = class1.getConstructor(String.class, int.class, String.class);

constructor02.setAccessible(true);  //设置访问权限为true

Car car2 = (Car)constructor.newInstance("huangse", 10, "黑色");

```

得到属性

1. public
````

//    得到所有公开属性，返回数组
//    Field[] fields = class1.getFields();

````
2. private

```

    Car car = (Car)class1.getDeclaredConstructor().newInstance();
    
     Field[] declaredField = class1.getDeclaredFields(); //拿到所有包括私有在内的属性
     
    for (Field f1 : declaredField) {
    
        if (f1.getName().equals("name")){

            f1.setAccessible(true); //设置控制权限
            
            f1.set(car,"tianya");   //调用方法为其赋值

        }
        System.out.println("属性名"+f1.getName());
      
    }

```

得到普通方法

> 实例化对象

```
   Car car = new Car("BWM",12,"write");
       Class class1=  car.getClass();

```

1. public

```
   Method[] methods = class1.getMethods(); //得到公开方法
        for (Method me: methods) {
//            System.out.println("方法名： "+me.getName());



            if (me.getName().equals("toString")){

                System.out.println("toString 执行： "+(String)me.invoke(car));//            执行某个方法
            }
        }

```

2. private

```

  Method[] me2 = class1.getDeclaredMethods(); //得到包括私有在内的所有方法
        for (Method m1:me2
             ) {

            if (m1.getName().equals("run")){
                m1.setAccessible(true);  //添加允许权限
                m1.invoke(car);  //执行指定方法

            }
            System.out.println(m1.getName());

        }

```








