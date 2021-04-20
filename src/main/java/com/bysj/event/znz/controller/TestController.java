package com.bysj.event.znz.controller;

/**
 * @Author: Hv
 * @E-MAIL: huowei@yuntongxun.com
 * @CreateDate: 2021/03/20 16:42
 * @Description:
 * @Version: 1.0
 */


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bysj.event.znz.entity.EditPassWordEntity;
import com.bysj.event.znz.entity.UserInfoEntity;
import com.bysj.event.znz.mapper.UserInfoMapper;
import com.bysj.event.znz.mapper.UserMapper;
import com.bysj.event.znz.msg.BaseResponse;
import com.bysj.event.znz.msg.WsJsonResp;
import com.bysj.event.znz.entity.TestEntity;
import com.bysj.event.znz.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/userInfo")
public class TestController {

    @Autowired
    private TestService testService ;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("get/{id}")
    public WsJsonResp test(@PathVariable Integer id){
        System.out.println("id:" + id);
        TestEntity testEntity =  userMapper.selectById(id);
        return testService.getById(id);
    }

    @PostMapping("users")
    public WsJsonResp testUser(@RequestBody String params){
        System.out.println("我执行了"+params);
        return testService.listTaskId(params);
    }


    /**
     * 新增
     * @param userInfoEntity
     * @return
     */
    @PostMapping(value = "/doSave")
    public BaseResponse<UserInfoEntity> savePersonal(@RequestBody UserInfoEntity userInfoEntity) {
        BaseResponse<UserInfoEntity> baseResponse = new BaseResponse<>();
        userInfoMapper.insert(userInfoEntity);
        baseResponse.setSuccess("1");
        return baseResponse;
    }

    /**
     * 登录
     * @param userInfoEntity
     * @return
     */
    @PostMapping(value = "/login")
    public BaseResponse<UserInfoEntity> login(@RequestBody UserInfoEntity userInfoEntity) {
        BaseResponse<UserInfoEntity> baseResponse = new BaseResponse<>();
        QueryWrapper<UserInfoEntity> condition1 = new QueryWrapper<>();
        condition1.eq("user_name", userInfoEntity.getUserName());
        UserInfoEntity queryU = userInfoMapper.selectOne(condition1);
        if(Optional.ofNullable(queryU).isPresent()){
            if(userInfoEntity.getPassWord().equals(queryU.getPassWord())){
                baseResponse.setSuccess("1");
                baseResponse.setData(queryU);
                baseResponse.setErrMsg("登录成功");
            }else {
                baseResponse.setSuccess("0");
                baseResponse.setErrMsg("密码错误");
            }
        }else {
            baseResponse.setSuccess("0");
            baseResponse.setErrMsg("用户不存在");
        }

        return baseResponse;
    }

    @PostMapping(value = "/getUserInfo")
    public BaseResponse<UserInfoEntity> getUserInfo(@RequestBody UserInfoEntity userInfoEntity) {
         BaseResponse<UserInfoEntity> baseResponse = new BaseResponse<>();
        UserInfoEntity resultUserInfoEntity = userInfoMapper.selectOne(new QueryWrapper<UserInfoEntity>().eq("user_name", userInfoEntity.getUserName()));
        baseResponse.setData(resultUserInfoEntity);
        baseResponse.setSuccess("1");
        log.info("getUserInfo = {}", resultUserInfoEntity.toString());
        return baseResponse;
    }

    @PostMapping(value = "/editPassWord")
    public BaseResponse<UserInfoEntity> editPassWord(@RequestBody EditPassWordEntity editPassWordEntity) {
        BaseResponse<UserInfoEntity> baseResponse = new BaseResponse<>();
        UserInfoEntity resultUserInfoEntity = userInfoMapper.selectOne(new QueryWrapper<UserInfoEntity>().eq("user_name", editPassWordEntity.getUserName()));
        if(Optional.ofNullable(resultUserInfoEntity).isPresent()){
            if(resultUserInfoEntity.getPassWord().equals(editPassWordEntity.getPassWord())){
                resultUserInfoEntity.setPassWord(editPassWordEntity.getNewPassWord());
                userInfoMapper.updateById(resultUserInfoEntity);
                baseResponse.setSuccess("1");
                baseResponse.setErrMsg("密码修改成功");
            }else {
                baseResponse.setSuccess("0");
                baseResponse.setErrMsg("原密码输入错误");
            }
        }else {
            baseResponse.setSuccess("0");
            baseResponse.setErrMsg("用户不存在");
        }
        log.info("editPassWord = {}", baseResponse.toString());
        return baseResponse;
    }



}
