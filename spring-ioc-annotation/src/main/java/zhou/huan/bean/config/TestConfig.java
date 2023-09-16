package zhou.huan.bean.config;

import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zhou.huan.bean.resource.controller.UserController;

public class TestConfig {

    @Test
    public void testConfig(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        context.getBean(UserController.class).add();

    }
}
