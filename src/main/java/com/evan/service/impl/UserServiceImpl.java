package com.evan.service.impl;

import com.evan.model.first.UserModel;
import com.evan.mapper.first.UserDao;
import com.evan.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author EvanYang
 * @since 2020-04-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserModel> implements UserService {

    @Override
    public List<UserModel> queryUser() {
        List<UserModel> list = this.lambdaQuery()
                .select(UserModel::getId, UserModel::getPhone)
                .eq(UserModel::getId, 1)
                .list();
        return list;
    }
}
