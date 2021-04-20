package com.bysj.event.znz.bean;

/**
 * @Author: Hv
 * @E-MAIL: huowei@yuntongxun.com
 * @CreateDate: 2021/03/20 16:43
 * @Description:
 * @Version: 1.0
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bysj.event.znz.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TestDao extends BaseMapper {

    TestEntity getById(Integer id);

    List<TestEntity> listTaskId(@Param("condition") TestEntity condition);

}
