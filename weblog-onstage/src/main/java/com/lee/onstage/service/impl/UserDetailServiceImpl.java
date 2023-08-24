package com.lee.onstage.service.impl;

import com.lee.onstage.entity.Menu;
import com.lee.onstage.entity.Role;
import com.lee.onstage.entity.User;
import com.lee.onstage.entity.UserRole;
import com.lee.onstage.entity.LoginUser;
import com.lee.onstage.service.MenuService;
import com.lee.onstage.service.RoleService;
import com.lee.onstage.service.UserRoleService;
import com.lee.onstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    @Override
    public LoginUser loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名获取用户
        User user = userService.getUserByName(username);
        //用户不存在
        if(user==null){
            throw new BadCredentialsException("用户名或者密码错误");
        } else if (user.getIsDisable()==0) {
            throw new LockedException(
                    "Access to your account has been suspended due to a violation of our Terms of Service.\n" +
                    "\n" +"Please contact support for more information.");
        }
        List< GrantedAuthority> grantedAuthorities = new ArrayList<>();
        //获取用户对应的菜单信息
        List<Menu> menuList =menuService.getByUserId(user.getId());
        //获取菜单权限
        List<String> permsList = menuList.stream().map(Menu::getPerms).collect(Collectors.toList());
        permsList.forEach(perms->{
            if(!("").equals(perms)&perms!=null){
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(perms);
                //添加进权限集合
                grantedAuthorities.add(grantedAuthority);
            }
        });
        //将用户拥有的权限加入LoginUser对象的权限集合
        LoginUser loginUser = new LoginUser(user,grantedAuthorities);
        loginUser.setRoleInfo(getRoleInfo(user));
        return loginUser;

    }

    private List<Role> getRoleInfo(User user) {
       List<UserRole> userRoleList =  userRoleService.getUserRoleByUserId(user.getId());
       List<Role> list = new ArrayList<>();
        for (UserRole userRole : userRoleList) {
            Role role = roleService.getByRoleId(userRole.getRoleId());
            list.add(role);
        }
        return list;
    }
}
