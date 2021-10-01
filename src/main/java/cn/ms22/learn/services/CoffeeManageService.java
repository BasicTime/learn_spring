package cn.ms22.learn.services;

import cn.ms22.learn.entity.Coffee;

import java.util.List;

public interface CoffeeManageService {
    void saveAll(List<Coffee> list);
}
