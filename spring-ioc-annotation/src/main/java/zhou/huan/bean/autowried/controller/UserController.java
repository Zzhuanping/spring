package zhou.huan.bean.autowried.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import zhou.huan.bean.autowried.dao.UserDao;
import zhou.huan.bean.autowried.service.UserService;
import zhou.huan.bean.autowried.service.UserServiceImp;

@Component
public class UserController {

//    第一种方式 属性注入
//    @Autowired //会根据类型自动找到对象接口，完成注入
//    private UserService userService;


////   第二种 通过set方法赋值
//    private UserService userService;
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

//    第三种，通过构造器注入值
//    private UserService userService;
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }


//    第四种  通过构造器的形参打注解注入
//    private UserService userService;
//    public UserController(@Autowired  UserService userService) {
//        this.userService = userService;
//    }


//    第五种  只有一个有参构造时，可以不用任何注解，直接上构造器
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
//双注解 解决多实现实现类冲突
    @Autowired
    @Qualifier(value = "userReditsDaoimp")
    private UserDao userDao;




//    第六种， 两个注解注入

    public void add(){
        System.out.println("controller do it");
            userService.add();
            userDao.add();
    }
}
