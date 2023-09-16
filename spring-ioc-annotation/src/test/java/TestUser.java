import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zhou.huan.bean.resource.controller.UserController;

public class TestUser {

    @Test
    public  void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserController userController =(UserController) context.getBean("resource", UserController.class);
        userController.add();
//        test00();
    }

    @Test
    public  void test00(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        zhou.huan.bean.autowried.controller.UserController userController = (zhou.huan.bean.autowried.controller.UserController)context.getBean(zhou.huan.bean.autowried.controller.UserController.class);
        userController.add();

    }

}
