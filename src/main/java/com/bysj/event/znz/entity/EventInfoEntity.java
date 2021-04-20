package com.bysj.event.znz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hv
 * @since 2021-04-1
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("event_info")
public class EventInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 事件编号
     */
    @TableField("event_id")
    private String eventId;

    /**
     * 事件地址
     */
    @TableField("event_address")
    private String eventAddress;

    /**
     * 事件类型
     */
    @TableField("event_type")
    private String eventType;

    /**
     * 事件时间
     */
    @TableField("event_time")
    private String eventTime;

    /**
     * 事件人数 
     */
    @TableField("event_number")
    private Integer eventNumber;

    /**
     * 事件场所
     */
    @TableField("event_org")
    private String eventOrg;

    /**
     * 事件人员
     */
    @TableField("event_person")
    private String eventPerson;

    /**
     * 事件详情
     */
    @TableField("event_content")
    private String eventContent;

    /**
     * 事件名称
     */
    @TableField("event_create_time")
    private String eventCreateTime;

    /**
     * 上报人
     */
    @TableField("event_fact_person")
    private String eventFactPerson;
}
