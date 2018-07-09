package vehicle.controller;

import org.omg.CORBA.UserException;
import org.springframework.beans.BeanUtils;
import vehicle.entity.User;
import vehicle.formbean.LoginFormBean;
import vehicle.service.UserService;
import vehicle.service.UserServiceImpl;
import vehicle.util.WebUtil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * create by tan on 2018/7/9
 **/
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8"); // 设置字符编码
        String id1 = request.getParameter("id"); // 获取登录id
        String password = request.getParameter("password"); // 获取登录密码
        String code = request.getParameter("code"); // 获取输入的验证码
        // String serverCode = request.getParameter("picCode");
        String checkImg_server=(String) request.getSession().getAttribute("picCode"); // 获取保存在session的picCode

        LoginFormBean formBean = WebUtil.request2Bean(request, LoginFormBean.class);

        // 对输入数据是否为空做校验
        if (!formBean.loginValidate()) {
            request.setAttribute("formBean", formBean);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else if(!("admin".equals(id1))) {
            formBean.getErrors().put("error","用户不存在");
            request.setAttribute("formBean", formBean);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else if(!("liu.yuan10".equals(password))) {
            formBean.getErrors().put("error","密码不正确");
            request.setAttribute("formBean", formBean);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else if(!checkImg_server.equalsIgnoreCase(code)) {
            request.setAttribute("formBean", formBean);
            formBean.getErrors().put("error", "验证码不正确");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/html/main.html").forward(request, response);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
