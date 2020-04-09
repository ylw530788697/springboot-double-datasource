package com.evan.controller;


import com.evan.mapper.database2.OrderDao;
import com.evan.mapper.database1.UserMapper;
import com.evan.model.OrderModel;
import com.evan.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author EvanYang
 * @since 2020-04-08
 */
@RestController
@RequestMapping("/userModel")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderDao orderDao;

    @GetMapping("/index")
    public UserModel demo(){
        HashMap<String, Object> map = new HashMap<>();
        List<UserModel> userModels = userMapper.seleteAll();
        OrderModel orderModel = orderDao.selectById(1);
        map.put("userModel",userModels);
        map.put("orderModel",orderModel);
        return null;
    }

}

