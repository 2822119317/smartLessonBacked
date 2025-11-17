package com.neu.smartLesson.service.impl;

import com.neu.smartLesson.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Spring Security 用于加载用户数据的服务。
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper; // 注入 MyBatis Mapper

    /**
     * Spring Security 调用此方法来获取用户信息
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 使用 MyBatis Mapper 从数据库中查找用户

        // 返回的 User 对象（它实现了 UserDetails）将被 Spring Security 用于认证
        return userMapper.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("用户名或密码错误")
                );
    }
}