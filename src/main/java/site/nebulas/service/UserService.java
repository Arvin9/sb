package site.nebulas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.nebulas.dao.UserDao;
import site.nebulas.entity.User;


/**
 * Created by Administrator on 2016/12/18.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Transactional
    public void insertTow(){
        User user1 = new User();
        user1.setUsername("nebula1");
        user1.setPassword("123");
        userDao.save(user1);

        User user2 = new User();
        user2.setUsername("nebula2");
        user2.setPassword("456322gfd jkgsjkdfg jhskfgsjhk gfjhsd gjhdgfjhgjgjhfsgdfjhgj");
        userDao.save(user2);
    }
}
