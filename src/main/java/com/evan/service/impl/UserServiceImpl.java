package com.evan.service.impl;

import com.evan.model.first.UserModel;
import com.evan.mapper.first.UserDao;
import com.evan.model.second.OrderModel;
import com.evan.service.OrderService;
import com.evan.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private OrderService orderService;

    @Override
    @Transactional
    public void saveUserOrder() {
        UserModel userModel = new UserModel("测试事务","1112233");
        save(userModel);
        OrderModel orderModel = new OrderModel();
        orderModel.setPhone("18575522");
        orderService.save(orderModel);
    }

}
