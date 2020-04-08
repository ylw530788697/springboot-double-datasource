package com.evan.service.impl;

import com.evan.model.OrderModel;
import com.evan.mapper.OrderDao;
import com.evan.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author EvanYang
 * @since 2020-04-08
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderModel> implements OrderService {

}
