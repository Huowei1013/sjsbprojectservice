package com.bysj.event.znz.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: Hv
 * @E-MAIL: huowei@yuntongxun.com
 * @CreateDate: 2021/03/20 16:43
 * @Description:
 * @Version: 1.0
 */
@Getter
@Setter
@ToString
public class TestEntity {

    protected Integer id ;

    protected String magicId ;

    protected String firstName ;

    protected String lastName ;

    //无参构造方法
    public TestEntity(){
        System.out.println("调用了公有、无参构造方法执行了。。。");
    }
    //有一个参数的构造方法
    public TestEntity(char name){
        System.out.println("姓名：" + name);
    }
    //有多个参数的构造方法
    public TestEntity(String name ,int age){
        System.out.println("姓名："+name+"年龄："+ age);//这的执行效率有问题，以后解决。
    }
    //受保护的构造方法
    protected TestEntity(boolean n){
        System.out.println("受保护的构造方法 n = " + n);
    }
    //私有构造方法
    private TestEntity(int age){
        System.out.println("私有的构造方法   年龄："+ age);
    }


}