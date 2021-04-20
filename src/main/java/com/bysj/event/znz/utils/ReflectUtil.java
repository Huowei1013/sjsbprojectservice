package com.bysj.event.znz.utils;

import java.lang.reflect.Constructor;

/**
 * @Author: Hv
 * @E-MAIL: huowei@yuntongxun.com
 * @CreateDate: 2021/03/27 17:14
 * @Description: 反射
 * @Version: 1.0
 */
public class ReflectUtil {
    public static void main(String[] args) {
        try {
            Class entity = Class.forName("com.bysj.event.znz.entity.TestEntity");
            System.out.println("-----------------------------");
            //获取所有公开方法
            Constructor[] conArray = entity.getConstructors();
            for (Constructor constructor : conArray) {
                System.out.println("公开方法"+constructor);
            }
            System.out.println("-----------------------------");
            //获取所有方法
            Constructor[] decArray = entity.getDeclaredConstructors();
            for (Constructor constructor : decArray) {
                System.out.println("所有方法"+constructor);
            }

            System.out.println("*****************获取公有、无参的构造方法*******************************");
            Constructor con = entity.getConstructor(null);
            //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
            //2>、返回的是描述这个无参构造函数的类对象。
            System.out.println("con = " + con);

            System.out.println("-----------------------------");
            //获取私有方法
            con = entity.getDeclaredConstructor(char.class);
             System.out.println("私有方法"+con);
            //调用构造方法
            con.setAccessible(true);//暴力访问(忽略掉访问修饰符)







        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }



}
