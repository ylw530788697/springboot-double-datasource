package com.evan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evan.mapper.second.OrderDao;
import com.evan.model.second.OrderModel;
import com.evan.service.OrderService;
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
