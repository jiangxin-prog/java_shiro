package com.wsl.controller;

import com.wsl.bean.User;
import com.wsl.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

@RequestMapping(value = "/")
@Controller
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("login")
    public String login(User user) {

        if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())) {
            return "login/login.html";
        }
        /**-------密码加密 START-------**/
        String hashAlgorithmName = "MD5";
        String credentials = user.getPassword();
        int hashIterations = 1024;
        //ByteSource credentialsSalt = ByteSource.Util.bytes("user");
        String credentialsSalt = user.getUserName();
        Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
        System.out.println(obj);
        String pwd = obj.toString();
        /**-------密码加密 END -------**/

        //用户认证信息
        Subject subject = SecurityUtils.getSubject();
        //Boolean isAuthenticated = subject.isAuthenticated();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getUserName(),
                pwd//user.getPassword()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        } catch (UnknownAccountException e) {
            log.error("用户名不存在！", e);
            return "用户名不存在！";
        } catch (AuthenticationException e) {
            log.error("账号或密码错误！", e);
            return "账号或密码错误！";
        } catch (AuthorizationException e) {
            log.error("没有权限！", e);
            return "没有权限";
        }
        //return "forword:/logout.html";
        return "redirect:home/index";
    }

//    @RequiresRoles("admin")
//    @GetMapping("admin")
//    public String admin() {
//        return "admin success!";
//    }
//
//    @RequiresPermissions("query")
//    @GetMapping("logout")
//    public String index() {
//        return "login/logout.html";
//    }
//
//    @RequiresPermissions("add")
//    @GetMapping("add")
//    public String add() {
//        return "add success!";
//    }
//

    @GetMapping("logout")
    public String edit() {
        return "login/logout.html";
    }
}
