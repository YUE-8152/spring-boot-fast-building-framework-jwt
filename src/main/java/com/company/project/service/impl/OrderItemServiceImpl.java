package com.company.project.service.impl;

import com.company.project.dao.OrderItemMapper;
import com.company.project.model.OrderItem;
import com.company.project.service.OrderItemService;
import com.company.project.common.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @Author: YUEXIN
 * @Date: 2020-05-28 14:05:09
 */
@Service
@Transactional
public class OrderItemServiceImpl extends AbstractService<OrderItem> implements OrderItemService {
    @Resource
    private OrderItemMapper orderItemMapper;

}
