package vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import vehicle.service.UserService;

/**
 * create by tan on 2018/5/18
 * 用户登录控制器是实现
 * 主要功能：对用户id和密码进行校验
 **/
@Controller
@RequestMapping("/login")
@Transactional
public class LoginController {

    @Autowired
    private UserService userService;

    // 根据id查询用户信息
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    @ResponseBody
    public String getUserById(int id) {
        try {
            if(userService.getUserById(id) == null) {
                System.out.println("id信息为："+ id);
                System.out.println("用户信息为：" + userService.getUserById(id));
                return "fail";
            } else {
                return "success";
            }
        } catch(Exception e) {
            return "error";
        }
    }

    // 根据id和密码查询用户信息
    @RequestMapping(value = "/getUserByIdAndPwd", method = RequestMethod.GET)
    @ResponseBody
    public String getUserByIdAndPwd(int id, String password) {
        try {
            if(userService.getUserByIdAndPwd(id, password) == null) {
                return "fail";
            } else {
                return "success";
            }
        } catch(Exception e) {
            return "error";
        }
    }

    // 验证成功，跳转菜单页面
    @RequestMapping(value = "/toPage")
    public String toPage() {
        System.out.println("页面跳转");
        return "html/main";
    }

}
