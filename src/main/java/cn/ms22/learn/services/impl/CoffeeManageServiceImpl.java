package cn.ms22.learn.services.impl;

import cn.ms22.learn.dao.CoffeeRepository;
import cn.ms22.learn.entity.Coffee;
import cn.ms22.learn.services.CoffeeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service

public class CoffeeManageServiceImpl implements CoffeeManageService {

    @Autowired
    private CoffeeRepository coffeeRepository;
    @Override
    @Transactional
    public void saveAll(List<Coffee> list) {
        coffeeRepository.saveAll(list);
    }

}
