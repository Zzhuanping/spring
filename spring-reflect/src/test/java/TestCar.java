import com.zhang.jie.Car;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCar {
//    演示类

//    1.获取class对象的多种方式
    @Test
    public void test01() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

         Class class1 = Car.class;   //通过类名.class


        Class class2 = new Car().getClass(); // getClass()


        Class class3 = Class.forName("com.zhang.jie.Car") ;       //Class.forName(全路径)

        //实例化
        Car car = (Car) class1.getDeclaredConstructor().newInstance();
        System.out.println(car);
    }



//    2.获取构造
    @Test
    public void test02() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class class1 = Car.class;   //通过类名.class
//        得到构造器数组getConstructors，getConstructors只能拿到类中的public构造方法

//        getDeclaredConstructors()得到全部的构造方法包括私有。

//        Constructor[] constructors = class1.getConstructors();
//

        Constructor[] declaredConstructor = class1.getDeclaredConstructors();

        for (Constructor c :declaredConstructor) {
            System.out.println("构造器名字： "+c.getName()+"构造器的参数个数"+c.getParameterCount());
        }

//        针对使用有参构造创建对象

//        1.public
        Constructor constructor = class1.getConstructor(String.class, int.class, String.class);
        Car car = (Car)constructor.newInstance("宾利", 10, "黑色");

        System.out.println(car);

//      2.private
        Constructor constructor02 = class1.getConstructor(String.class, int.class, String.class);
        constructor02.setAccessible(true);  //设置访问权限为true
        Car car2 = (Car)constructor.newInstance("huangse", 10, "黑色");
        System.out.println(car2);

    }

//    3.获取属性
@Test
    public void test03() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    Class class1 = Car.class;
    Car car = (Car)class1.getDeclaredConstructor().newInstance();

//    得到所有公开属性，返回数组
//    Field[] fields = class1.getFields();


//    全部私有属性
    Field[] declaredField = class1.getDeclaredFields();
    for (Field f1 : declaredField) {
        if (f1.getName().equals("name")){

            f1.setAccessible(true);
            f1.set(car,"tianya");

        }
        System.out.println("属性名"+f1.getName());
        System.out.println(car);
    }



}
//    4.获取普通方法
    @Test
    public void test04() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Class class01 = Car.class;
//       Car car = (Car) class01.getDeclaredConstructor().newInstance(); //实例化
//
        Car car = new Car("BWM",12,"write");
       Class class1=  car.getClass();

//       public


        Method[] methods = class1.getMethods();
        for (Method me: methods) {
//            System.out.println("方法名： "+me.getName());

//            执行某个方法

            if (me.getName().equals("toString")){

                System.out.println("toString 执行： "+(String)me.invoke(car));
            }
        }


//        private

        Method[] me2 = class1.getDeclaredMethods(); //得到包括私有在内的所有方法
        for (Method m1:me2
             ) {

            if (m1.getName().equals("run")){
                m1.setAccessible(true);
                m1.invoke(car);

            }
            System.out.println(m1.getName());

        }

    }
}
