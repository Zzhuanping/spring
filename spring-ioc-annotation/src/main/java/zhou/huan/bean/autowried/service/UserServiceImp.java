package zhou.huan.bean.autowried.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import zhou.huan.bean.autowried.dao.UserDao;
import zhou.huan.bean.autowried.dao.UserDaoImp;

@Service
public class UserServiceImp implements UserService{

    //one
//    @Autowired
    private UserDao userDao;

    //two
//    @Autowired
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }


//    three

//    @Autowired
//    public UserServiceImp(UserDao userDao) {
//        this.userDao = userDao;
//    }


//    four


    public UserServiceImp(@Qualifier("userDaoImp") @Autowired UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        System.out.println("service do it ");
        userDao.add();
    }
}
