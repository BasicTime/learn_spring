package cn.ms22.learn.services;

import cn.ms22.learn.entity.Order;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderManageService {

    void addCoffeeToOrder(List<Order> items);

    List<Order> getAllOrders();

    List<Order> getOrderByCustomer(String customer);

    List<Order> findTop2OrderByUpdateTime();

    Page<Order> getPage2OfSize3();
}
