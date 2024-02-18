package com.example.tmp.mapper;

import com.example.tmp.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author hbw
 * @since 2026-02-18
 */
@Mapper

public interface UserMapper extends BaseMapper<User> {


      @Select("SELECT * FROM USER WHERE name =#{userName}")

      User getByUserName(String userName);
}
