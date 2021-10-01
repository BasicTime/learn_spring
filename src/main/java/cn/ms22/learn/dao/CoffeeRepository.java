package cn.ms22.learn.dao;

import cn.ms22.learn.entity.Coffee;
import org.springframework.data.repository.CrudRepository;

/**
 * 注意事项，这里的CrudRepository里面泛型需要指定具体的类型
 */
public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
