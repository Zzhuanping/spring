package zhou.huan.bean.resource.controller;


import org.springframework.stereotype.Controller;

import zhou.huan.bean.resource.dao.UserDao;
import zhou.huan.bean.resource.dao.UserMyDaoImp;
import zhou.huan.bean.resource.service.UserService;

import javax.annotation.Resource;

@Controller(value = "resource")
public class UserController {

    @Resource    //根据属性名和类的id去寻找匹配
    private UserService myUserServiceImp;

    @Resource(name = "dao")
    private UserDao userDao;

    public void add(){
        System.out.println("this |controller do it");
        myUserServiceImp.add();
        userDao.add();

    }
}
