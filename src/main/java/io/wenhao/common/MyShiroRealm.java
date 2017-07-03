package io.wenhao.common;

import io.wenhao.model.User;
import io.wenhao.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Component
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private IUserService userService;

    /*
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Set<String> roleNames = new HashSet<>();
        Set<String> permissions = new HashSet<>();
        roleNames.add("administrator");//添加角色
        permissions.add("newPage.html");  //添加权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);
        return info;
    }

    /*
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

        //获取用户登录信息
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = token.getUsername();
        char[] password = token.getPassword();
        User user = userService.getUserByName(username);

        if (user == null) {
            //首先检查根据username能否查到对象，查不到则账号不存在
            throw new UnknownAccountException();
        } else {
            //通过hash + salt 验证密码是否正确
            SimpleAuthenticationInfo auth = new SimpleAuthenticationInfo(user.getName(), password, new Md5Hash(user.getSalt()), getName());
            return auth;
        }
    }
}