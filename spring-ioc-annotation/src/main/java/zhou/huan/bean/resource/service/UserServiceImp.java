package zhou.huan.bean.resource.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhou.huan.bean.resource.dao.UserDao;

import javax.annotation.Resource;

@Service(value = "myUserServiceImp")
public class UserServiceImp implements UserService {

    //one
    @Resource(name = "myUserDaoImp")
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("is |service do it ");
        userDao.add();
    }
}
