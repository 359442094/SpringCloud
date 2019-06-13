package cn.springcloud.service;

import cn.springcloud.model.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserById(int id);

}
