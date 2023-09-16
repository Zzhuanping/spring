package zhou.huan.bean.resource.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "dao")
public class UserMyDaoImp implements UserDao{
    @Override
    public void add() {
        System.out.println("this is private class");
    }
}
