package com.bysj.event.znz.msg;

/**
 * @Author: Hv
 * @E-MAIL: huowei@yuntongxun.com
 * @CreateDate: 2021/03/20 19:19
 * @Description:
 * @Version: 1.0
 */
import com.fasterxml.jackson.annotation.JsonProperty;

public class WsJsonResp extends BaseJsonResp {
    @JsonProperty("token")
    private String token;
    @JsonProperty("data")
    private Object data;

    public WsJsonResp() {
    }

    public WsJsonResp(Object data) {
        this.data = data;
    }


    public WsJsonResp(String statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    public WsJsonResp(String statusCode, String statusMsg, Object data) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
        this.data = data;
    }

    public String getToken() {
        return this.token;
    }

    public Object getData() {
        return this.data;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public void setData(final Object data) {
        this.data = data;
    }

    public String toString() {
        return "WsJsonResp(token=" + this.getToken() + ", data=" + this.getData() + ")";
    }
}
