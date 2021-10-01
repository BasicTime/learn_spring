package cn.ms22.learn.dao;

import cn.ms22.learn.entity.Order;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * 需要添加@NoRepositoryBean注解，防止被注入为RepositoryBean
 * jpa通过derived-queries 来解析 https://www.baeldung.com/spring-data-derived-queries, 这种方式对命名有严格的要求，
 * 需要看如上的开发文档
 * jpa可以通过其他形式实现解析，https://www.baeldung.com/intro-to-querydsl
 * <p>
 * 因为继承了PagingAndSortingRepository，可以编写带有page的查询信息
 *
 * @param
 */
@NoRepositoryBean
public interface BaseRepository extends PagingAndSortingRepository<Order, Long> {
    List<Order> findTop2ByOrderByUpdateTimeDesc();
}
