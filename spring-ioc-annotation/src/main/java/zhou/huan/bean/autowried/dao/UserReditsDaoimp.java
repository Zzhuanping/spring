package zhou.huan.bean.autowried.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserReditsDaoimp implements UserDao{

    @Override
    public void add() {
        System.out.println("Redits do it");
    }
}
