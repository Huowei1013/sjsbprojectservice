package com.bysj.event.znz.msg;

/**
 * @Author: Hv
 * @E-MAIL: huowei@yuntongxun.com
 * @CreateDate: 2021/03/20 19:07
 * @Description:
 * @Version: 1.0
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.logging.log4j.ThreadContext;

public class BaseJsonResp {
    @JsonProperty("msgId")
    String msgId;
    @JsonProperty("statusCode")
    String statusCode;
    @JsonProperty("statusMsg")
    String statusMsg;

    public BaseJsonResp() {
        this.statusCode = "1002";
        this.statusMsg = "哈哈哈";
        this.msgId = ThreadContext.get("SID");
    }


    public BaseJsonResp(String statuscode, String statusMsg) {
        this.statusCode = "1002";
        this.statusMsg = "哈哈哈";
        this.statusCode = statuscode;
        this.statusMsg = statusMsg;
        this.msgId = ThreadContext.get("SID");
    }


    public String getMsgId() {
        return this.msgId;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMsg() {
        return this.statusMsg;
    }

    public void setMsgId(final String msgId) {
        this.msgId = msgId;
    }

    public void setStatusCode(final String statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusMsg(final String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public String toString() {
        return "BaseJsonResp(msgId=" + this.getMsgId() + ", statusCode=" + this.getStatusCode() + ", statusMsg=" + this.getStatusMsg() + ")";
    }
}
