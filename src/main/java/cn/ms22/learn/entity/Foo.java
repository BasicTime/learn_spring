package cn.ms22.learn.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;

public class Foo {
    @GeneratedValue()
    private int id;
    private int name;
}
