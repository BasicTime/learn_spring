package cn.ms22.learn.dao;

import cn.ms22.learn.entity.Order;

import java.util.List;

/**
 * 自定义的Repository
 */
public interface CoffeeOrderRepository extends BaseRepository {
    List<Order> findOrderByCustomerOrderById(String customer);

    List<Order> findByItems_name(String item);

}
