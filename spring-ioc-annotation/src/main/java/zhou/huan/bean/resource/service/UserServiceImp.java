package zhou.huan.bean.resource.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhou.huan.bean.resource.dao.UserDao;

@Service(value = "myUserServiceImp")
public class UserServiceImp implements UserService {

    //one
    @Autowired
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("is |service do it ");
        userDao.add();
    }
}
