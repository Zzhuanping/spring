package zhou.huan.bean.resource.dao;


import org.springframework.stereotype.Repository;

@Repository(value = "myUserDaoImp")
public class UserDaoImp implements UserDao {
    @Override
    public void add() {
        System.out.println("new style|Dao do it");

    }
}
