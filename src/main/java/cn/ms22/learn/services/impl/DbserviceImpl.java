package cn.ms22.learn.services.impl;

import cn.ms22.learn.dao.DBdao;
import cn.ms22.learn.dao.JdbcTemplateDao;
import cn.ms22.learn.services.Dbservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class DbserviceImpl implements Dbservice {

    @Autowired
    private DBdao dBdao;
    @Autowired
    private JdbcTemplateDao jdbcTemplateDao;

    @Override
    public String accessH2Info() {
        try {
            return dBdao.accessH2ReadInfo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Read error.";
    }

    @Override
    public String readH2Info() {
        return jdbcTemplateDao.readH2Info();
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    @Override
    public String transactionInfo() {
        System.out.println("插入之前查询数据" + jdbcTemplateDao.getCountFromTable("foo"));
        try {
            jdbcTemplateDao.inputAmsg("1 msg.");
            System.out.println("插入之后查询数据" + jdbcTemplateDao.getCountFromTable("foo"));
            System.out.println("sub插入之前查询数据" + jdbcTemplateDao.getCountFromTable("foo"));
            subCommit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("sub插入之后查询数据" + jdbcTemplateDao.getCountFromTable("foo"));
        return "msg";
    }

    @Transactional(propagation = Propagation.NESTED, rollbackFor = SQLException.class)
    void subCommit() throws SQLException {
        jdbcTemplateDao.inputAmsg("a msg.");
    }
}
