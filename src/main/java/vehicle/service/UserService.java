package vehicle.service;

import vehicle.entity.User;

/**
 * create by tan on 2018/5/18
 * 用户操作业务逻辑层
 **/
public interface UserService {
    public User getUserById(int id); // 根据id查询用户
    public User getUserByIdAndPwd(int id, String password); // 根据id和密码查询用户
}
