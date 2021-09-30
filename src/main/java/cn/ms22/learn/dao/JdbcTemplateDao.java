package cn.ms22.learn.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class JdbcTemplateDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String readH2Info() {
        //插入
        Arrays.asList("a", "b", "c").forEach(s -> {
            jdbcTemplate.update("insert into foo(BAR) values(?)", s);
        });

        //统计
        Long count = jdbcTemplate.queryForObject("select count(1) from foo", long.class);
        System.out.println("一共插入数据量：" + count);

        //查询出数据
        List<String> rs = jdbcTemplate.queryForList("select bar FROM foo", String.class);
        StringBuilder stringBuilder = new StringBuilder();
        rs.forEach(s -> stringBuilder.append(s));
        return stringBuilder.toString();
    }
}
