package zhou.huan.bean.resource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import zhou.huan.bean.resource.service.UserService;

@Controller(value = "resource")
public class UserController {

    @Autowired
    private UserService userService;

    public void add(){
        System.out.println("this |controller do it");
            userService.add();

    }
}
