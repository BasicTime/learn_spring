package cn.ms22.learn.services.impl;

import cn.ms22.learn.dao.DBdao;
import cn.ms22.learn.dao.JdbcTemplateDao;
import cn.ms22.learn.services.Dbservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
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
}
