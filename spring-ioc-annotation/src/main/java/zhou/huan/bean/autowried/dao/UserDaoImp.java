package zhou.huan.bean.autowried.dao;


import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao{
    @Override
    public void add() {
        System.out.println("Dao do it");

    }
}
