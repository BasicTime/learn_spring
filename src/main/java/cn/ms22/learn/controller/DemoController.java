package cn.ms22.learn.controller;

import cn.ms22.learn.services.Dbservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class DemoController {

    @Autowired
    private Dbservice dbservice;

    @RequestMapping("/hello")
    public String hello() {
        return "hello spring.";
    }

    @RequestMapping("/accessDB")
    public String accessDB() {
        return dbservice.accessH2Info();
    }

    @RequestMapping("/accessDBread")
    public String accessDBread() {
        return dbservice.readH2Info();
    }


}
