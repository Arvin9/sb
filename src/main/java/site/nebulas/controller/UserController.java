package site.nebulas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.nebulas.dao.UserDao;
import site.nebulas.entity.User;
import site.nebulas.service.UserService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by Administrator on 2016/12/18.
 */
@RestController
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    /**
     * 查询所有用户列表
     * */
    @GetMapping(value = "/users")
    public List<User> userList(){
        return userDao.findAll();
    }

    /**
     * 添加一个用户
     * */
    @PostMapping(value = "users")
    public User userAdd(@RequestParam("username")String username,
                            @RequestParam("password")String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userDao.save(user);
    }

    /**
     *  查询一个用户
     * */
    @GetMapping(value = "/users/{id}")
    public User userFindOne(@PathVariable("id") Integer id){
        return userDao.findOne(id);
    }

    /**
     *  更新
     * */
    @PutMapping(value = "/users/{id}")
    public User userUpdate(@PathVariable("id") Integer id,
                            @RequestParam(value = "username",required = false)String username,
                            @RequestParam(value = "password",required = false)String password){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        return userDao.save(user);
    }

    /**
     *  删除
     * */
    @DeleteMapping(value = "/users/{id}")
    public void userDelete(@PathVariable("id") Integer id){
        userDao.delete(id);
    }

    /**
     * 通过用户名查询所有用户列表
     * */
    @GetMapping(value = "/users/username/{username}")
    public List<User> userListByName(@PathVariable("username") String username){
        return userDao.findByUsername(username);
    }

    /**
     * 添加一个用户
     * */
    @PostMapping(value = "/users/tow")
    public void userTow(){
        userService.insertTow();
    }
}
