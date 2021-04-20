package com.bysj.event.znz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bysj.event.znz.bean.EventInfoListDao;
import com.bysj.event.znz.entity.EventInfoEntity;
import com.bysj.event.znz.msg.BaseResponse;
import com.bysj.event.znz.mapper.EventInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: Hv
 * @E-MAIL: huowei@yuntongxun.com
 * @CreateDate: 2021/4/1 1:31
 * @Description:
 * @Version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/eventInfo")
public class EventController {
    @Autowired
    private EventInfoMapper eventInfoMapper;
    /**
     * 新增
     * @param eventInfoEntity
     * @return
     */
    @PostMapping(value = "/doSave")
    public BaseResponse<EventInfoEntity> saveEvent(@RequestBody EventInfoEntity eventInfoEntity) {
        BaseResponse<EventInfoEntity> baseResponse = new BaseResponse<>();
        eventInfoEntity.setEventId("LYSJ"+System.currentTimeMillis());
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String dateString = formatter.format(date);
        eventInfoEntity.setEventCreateTime(dateString);
        eventInfoMapper.insert(eventInfoEntity);
        baseResponse.setSuccess("1");
        return baseResponse;
    }
    /**
     * 查询
     * @return
     */
    @PostMapping(value = "/selectList")
    public BaseResponse<EventInfoListDao> getEventList() {
        BaseResponse<EventInfoListDao> baseResponse = new BaseResponse<>();
        List<EventInfoEntity> eventInfoEntities = eventInfoMapper.selectList(new QueryWrapper<EventInfoEntity>());
        EventInfoListDao eventInfoListDao = new EventInfoListDao();
        eventInfoListDao.setEventList(eventInfoEntities);
        baseResponse.setData(eventInfoListDao);
        baseResponse.setSuccess("1");
        return baseResponse;
    }

    /**
     * 查询详情
     * @return
     */
    @PostMapping(value = "/details")
    public BaseResponse<EventInfoEntity> getEventDetails(@RequestBody EventInfoEntity eventInfoEntity) {
        BaseResponse<EventInfoEntity> baseResponse = new BaseResponse<>();
        EventInfoEntity eventInfoEntities = eventInfoMapper.selectById(eventInfoEntity.getId());
        baseResponse.setData(eventInfoEntities);
        baseResponse.setSuccess("1");
        return baseResponse;
    }

}
