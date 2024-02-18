package com.example.tmp.service.impl;

import com.example.tmp.entity.User;
import com.example.tmp.mapper.UserMapper;
import com.example.tmp.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author hbw
 * @since 2024-02-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
