import com.zhang.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestUser {
//创建logger对象
    private Logger log = LoggerFactory.getLogger(TestUser.class);




    @Test
    public void testuserclass(){
//        加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        获取创建的对象
        User zhang = (User)context.getBean("user");      //强制转换类型

        zhang.add();

//        手动写日志
        log.info("调用add方法");
    }
}
