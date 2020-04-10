package com.evan.controller;


import com.evan.mapper.second.OrderDao;
import com.evan.mapper.first.UserMapper;
import com.evan.model.first.UserModel;
import com.evan.model.second.OrderModel;
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
    public String demo(){
        HashMap<String, Object> map = new HashMap<>();
        UserModel userModels = userMapper.selectById(1);
        OrderModel orderModel = orderDao.selectById(1);
        map.put("userModel",userModels);
        map.put("orderModel",orderModel);
        UserModel userModel = userMapper.selectById(1);
        return "dddd";
    }

}

