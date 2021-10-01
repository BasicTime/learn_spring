package cn.ms22.learn.services.impl;

import cn.ms22.learn.dao.CoffeeOrderRepository;
import cn.ms22.learn.dao.CoffeeRepository;
import cn.ms22.learn.dao.OrderRepository;
import cn.ms22.learn.entity.Order;
import cn.ms22.learn.services.OrderManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderManageServiceImpl implements OrderManageService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    @Override
    @Transactional
    public void addCoffeeToOrder(List<Order> items) {
        orderRepository.saveAll(items);
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> items = new ArrayList<>();
        orderRepository.findAll().forEach(items::add);
        return items;
    }

    @Override
    public List<Order> getOrderByCustomer(String customer) {
        return coffeeOrderRepository.findOrderByCustomerOrderById(customer);
    }

    @Override
    public List<Order> findTop2OrderByUpdateTime() {

        return coffeeOrderRepository.findTop2ByOrderByUpdateTimeDesc();
    }

    @Override
    public Page<Order> getPage2OfSize3() {
        return coffeeOrderRepository.findAll(PageRequest.of(2, 3).withSort(Sort.by(Sort.Order.asc("createTime"))));
    }

}
