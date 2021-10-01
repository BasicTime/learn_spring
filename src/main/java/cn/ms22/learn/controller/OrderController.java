package cn.ms22.learn.controller;

import cn.ms22.learn.entity.Coffee;
import cn.ms22.learn.entity.Order;
import cn.ms22.learn.entity.OrderState;
import cn.ms22.learn.services.CoffeeManageService;
import cn.ms22.learn.services.OrderManageService;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderManageService orderManageService;

    @Autowired
    private CoffeeManageService coffeeManageService;

    @RequestMapping("/commit")
    public String commitOrder() {
        try {
            //Coffee
            Coffee latte = Coffee.builder()
                    .name("拿铁")
                    .price(Money.of(CurrencyUnit.of("CNY"), 20.0)).build();
            Coffee milkShake = Coffee.builder().name("奶昔")
                    .price(Money.of(CurrencyUnit.of("CNY"), 20.0)).build();

            coffeeManageService.saveAll(Arrays.asList(latte, milkShake));

            //Order
            Order zsOrder = Order.builder().customer("张三").items(Collections.singletonList(latte)).state(OrderState.INIT).build();
            Order lsOrder = Order.builder().customer("李四").items(Arrays.asList(latte, milkShake)).state(OrderState.INIT).build();

            orderManageService.addCoffeeToOrder(Arrays.asList(zsOrder, lsOrder));
        } catch (Exception e) {
            return "error";
        }
        return "success";
    }

    @RequestMapping("/allOrder")
    public List<Order> getAllOrders() {
        List<Order> orders = null;
        try {
            orders = orderManageService.getAllOrders();
        } catch (Exception e) {
            return null;
        }
        return orders;
    }

    @RequestMapping("/customer/{customer}")
    public List<Order> getOrderByCustomer(@PathVariable String customer) {
        List<Order> orders = orderManageService.getOrderByCustomer(customer);
        return orders;
    }

    @RequestMapping("/findTop2OrderByUpdateTime")
    public List<Order> findTop2OrderByUpdateTimeDescIdAsc() {
        List<Order> orders = orderManageService.findTop2OrderByUpdateTime();
        return orders;
    }

    @RequestMapping("/getPage2OfSize3")
    public Page<Order> getPage2OfSize3() {
        return orderManageService.getPage2OfSize3();
    }

}
