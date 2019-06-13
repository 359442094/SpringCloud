package cn.springcloud.service.impl;

import cn.springcloud.model.entity.User;
import cn.springcloud.model.entity.UserExample;
import cn.springcloud.model.mapper.UserMapper;
import cn.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
