package vehicle.formbean;

import java.util.HashMap;
import java.util.Map;

/**
 * create by tan on 2018/5/11
 * 封装用户登录的表单bean,接收login.jsp页面的输入值并验证合法性
 **/
public class LoginFormBean {
    private String id; // 用户编号
    private String password; // 用户登录密码
    private String code;

    private Map<String, String> errors = new HashMap<String, String>(); // 用于存储输入错误提示信息

    public boolean loginValidate() {
        boolean isOk = true;
        if ("".equals(id)) {
            isOk = false;
            errors.put("error", "请输入用户名");
        } else if (this.password == null || this.password.trim().equals("")) {
            isOk = false;
            errors.put("error", "请输入密码");
        } else if (this.code == null || this.code.trim().equals("")) {
            isOk = false;
            errors.put("error", "请输入验证码");
        }
        return isOk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "LoginFormBean{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                ", errors=" + errors +
                '}';
    }
}
