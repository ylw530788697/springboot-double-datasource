package com.evan.controller;


import com.evan.mapper.second.OrderDao;
import com.evan.mapper.first.UserDao;
import com.evan.model.first.UserModel;
import com.evan.model.second.OrderModel;
import com.evan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public Map<String, Object> demo(){
        Map<String, Object> map = new HashMap<>();
        UserModel userModels = userDao.selectById(1);
        OrderModel orderModel = orderDao.selectById(1);
        map.put("userModel",userModels);
        map.put("orderModel",orderModel);
        UserModel userModel = userDao.selectById(1);
        return map;
    }
    @GetMapping("/list")
    public List<UserModel> setOrderDao(){
        List<UserModel> userModels = userService.queryUser();
        return userModels;
    }

}

