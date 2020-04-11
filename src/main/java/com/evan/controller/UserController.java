package com.evan.controller;


import com.evan.dto.UserSaveReq;
import com.evan.mapper.second.OrderDao;
import com.evan.mapper.first.UserDao;
import com.evan.model.first.UserModel;
import com.evan.model.second.OrderModel;
import com.evan.service.UserService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
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

    @GetMapping("save")
    public void save(){
        userService.saveUserOrder();
    }

    @PostMapping("/saveUser")
    public String saveUser(HttpServletRequest request, HttpServletResponse response,
                         @ApiParam(value = "查询订单列表") @RequestBody @Valid UserSaveReq req){
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(req,userModel);
        userService.save(userModel);
        return "添加成功";

    }

}

