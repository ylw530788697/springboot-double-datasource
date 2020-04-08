package com.evan.controller;


import com.evan.mapper.database2.OrderDao;
import com.evan.mapper.database1.UserDao;
import com.evan.model.OrderModel;
import com.evan.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

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
    private UserDao userDao;

    @Autowired
    private OrderDao orderDao;

    @GetMapping("/index")
    public UserModel demo(){
        HashMap<String, Object> map = new HashMap<>();
        UserModel userModel = userDao.selectById(1);
        OrderModel orderModel = orderDao.selectById(1);
        map.put("userModel",userModel);
        map.put("orderModel",orderModel);
        return userModel;
    }

}

