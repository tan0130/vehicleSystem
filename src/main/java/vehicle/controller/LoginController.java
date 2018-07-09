package vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import vehicle.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * create by tan on 2018/5/18
 * 用户登录控制器是实现
 * 主要功能：对用户id和密码进行校验
 **/

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    // 根据id查询用户信息
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    @ResponseBody
    public String getUserById(String id) {
        try {
            System.out.println("id为：" + id);
            /*if(userService.getUserById(id) == null) {
                System.out.println("id信息为："+ id);
                System.out.println("用户信息为：" + userService.getUserById(id));
                return "fail";
            } else {
                return "success";
            }*/
            if (("admin").equals(id)) {
                return "true";
            } else {
                return "false";
            }
        } catch(Exception e) {
            return "error";
        }
    }

    // 根据id和密码查询用户信息
    @RequestMapping(value = "/getUserByIdAndPwd", method = RequestMethod.GET)
    @ResponseBody
    public String getUserByIdAndPwd(String id, String password) {
        try {

            if (("admin").equals(id) && ("liu.yuan10").equals(password)) {
                return "true";
            } else {
                return "false";
            }
        } catch(Exception e) {
            return "error";
        }
    }

    // 验证成功，跳转菜单页面
   /* @RequestMapping(value = "/toPage")
    public String toPage() {
        return "html/main";
    }
*/

    // 登录验证
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    @ResponseBody
    public String page(HttpServletRequest request,
                       HttpServletResponse response) {
        String id = request.getParameter("id").trim();
        String password = request.getParameter("password").trim();
        if (!("admin".equals(id))) {
            return "idNotExist";
        } else if (!("liu.yuan10".equals(password))) {
            return "errorPassword";
        } else {
            return "success";
        }
    }

    // 验证码
    @RequestMapping(value = "/checkCode")
    @ResponseBody
    public StringBuffer getValidCode() {
        StringBuffer sb = new StringBuffer("");
        String baseChar = "0123456789ABCDEFGHJKLMNPQRSTUVWXYZ"; //不包括字母O，只有数字0
        for(int i = 0 ; i < 4 ; i++){
            sb.append(baseChar.charAt(new Random().nextInt(baseChar.length())) + "");
        }
        return sb;
    }
}
