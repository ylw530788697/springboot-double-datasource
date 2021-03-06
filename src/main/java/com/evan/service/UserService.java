package com.evan.service;

import com.evan.model.first.UserModel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author EvanYang
 * @since 2020-04-08
 */
public interface UserService extends IService<UserModel> {

    List<UserModel> queryUser();

    void saveUserOrder();
}
