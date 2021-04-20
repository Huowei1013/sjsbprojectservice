package com.bysj.event.znz.bean;

import com.bysj.event.znz.entity.EventInfoEntity;
import lombok.Data;

import java.util.List;

/**
 * @Author: Hv
 * @E-MAIL: huowei@yuntongxun.com
 * @CreateDate: 2021/4/09 1:45
 * @Description:
 * @Version: 1.0
 */
@Data
public class EventInfoListDao {
    private List<EventInfoEntity> eventList;
}
