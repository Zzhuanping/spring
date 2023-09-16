import com.zhang.jie.User;
import com.zhang.jie.di.Book;
import com.zhang.jie.dimap.Student;
import com.zhang.jie.ditest.Dept;
import com.zhang.jie.ditest.emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    @Test
    public void testuserA(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        第一 通过id获取
        User user = (User)context.getBean("user");
        System.out.println("通过ID:"+user);
        System.out.println("==========================");
//        第二
        System.out.println("通过类型"+(User)context.getBean(User.class));

        System.out.println("==========================");
        System.out.println("同时通过ID和类型"+context.getBean("user", User.class));

    }

    @Test
    public void testBook(){
        ApplicationContext  context = new ClassPathXmlApplicationContext("bean-di.xml");
        Book book = (Book) context.getBean("book",Book.class);
        System.out.println(book);

    }

    @Test
    public void testConstructor(){
        ApplicationContext  context = new ClassPathXmlApplicationContext("bean-di.xml");
        Book book = (Book) context.getBean("book2");
        System.out.println(book);

    }
//外联样式
    @Test
    public void testDept(){
        ApplicationContext  context = new ClassPathXmlApplicationContext("bean-ditest.xml");

        emp emp = (emp)context.getBean("emp",com.zhang.jie.ditest.emp.class);
        emp.work();

    }
//内嵌
    @Test
    public void testOut(){
        ApplicationContext  context = new ClassPathXmlApplicationContext("bean-ditest.xml");
        emp ee =(emp) context.getBean("emp1");
        ee.work();

    }
//级联
        @Test
        public void testCss(){
    ApplicationContext  context = new ClassPathXmlApplicationContext("bean-di-jillian.xml");
    emp ee =(emp) context.getBean("emp", emp.class);
        ee.work();
}

//数组
    @Test
    public void testArray(){
        ApplicationContext  context = new ClassPathXmlApplicationContext("bean-di-array.xml");
        emp ee =(emp) context.getBean("emp", emp.class);
        ee.work();
    }

//list集合
    @Test
    public void testList(){
        ApplicationContext  context = new ClassPathXmlApplicationContext("bean-di-list.xml");
        Dept ee =(Dept) context.getBean("dept", Dept.class);

        ee.info();
    }

//    Map集合
@Test
public void testMap(){
    ApplicationContext  context = new ClassPathXmlApplicationContext("bean-di-map.xml");
     Student stu =(Student) context.getBean("stu", Student.class);

   stu.show();
}

//util的方式赋值map和list
@Test
public void testUtil(){
    ApplicationContext  context = new ClassPathXmlApplicationContext("bean-di-ref.xml");
    Student stu =(Student) context.getBean("stu", Student.class);
    stu.show();
}


    //p空间
    @Test
    public void testP(){
        ApplicationContext  context = new ClassPathXmlApplicationContext("bean-di-ref.xml");
        Student stu =(Student) context.getBean("student1", Student.class);
        stu.show();
    }


}
