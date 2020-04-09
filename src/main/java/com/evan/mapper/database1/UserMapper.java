package com.evan.mapper.database1;

import com.evan.model.UserModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author EvanYang
 * @since 2020-04-08
 */
public interface UserMapper extends BaseMapper<UserModel> {
    List<UserModel> seleteAll ();

}
