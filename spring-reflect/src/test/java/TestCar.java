import com.zhang.jie.Car;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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

//    4.获取普通方法


}
