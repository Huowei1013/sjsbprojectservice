package com.bysj.event.znz.service;

/**
 * @Author: Hv
 * @E-MAIL: huowei@yuntongxun.com
 * @CreateDate: 2021/03/20 16:43
 * @Description:
 * @Version: 1.0
 */

//import TestDao;

import com.bysj.event.znz.msg.WsJsonResp;
import com.bysj.event.znz.utils.BeanOrStrUtil;
import com.bysj.event.znz.bean.TestDao;
import com.bysj.event.znz.entity.TestEntity;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Service
public class TestService {

    @Autowired
    private TestDao testDao ;



    public WsJsonResp getById(Integer id){
        return new WsJsonResp(testDao.getById(id));
    }

    public WsJsonResp listTaskId(String params){
        System.out.println("我执行了"+params);
        TestEntity entity = BeanOrStrUtil.readValue(params,TestEntity.class);
//        QueryWrapper<TestEntity> wrapper = new QueryWrapper<>();
//        wrapper.eq("magicId")
        List<TestEntity> records = testDao.listTaskId(entity);
        // 组装VIEW展示数据
        List<Object> respBody = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(records)) {
            for (TestEntity record : records) {
                Map<String, Object> bean = new HashMap<>();
                bean.put("firstName", record.getFirstName());
                respBody.add(bean);
            }
        }
        return new WsJsonResp(respBody);
    }


}