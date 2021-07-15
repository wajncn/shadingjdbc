package com.yoc.model;

import java.io.Serializable;

/**
 * @Description
 * @Author 李定军
 * @Date 2021-06-18
 */
public class ResultModel<T> implements Serializable {
    private Integer status;
    private String msg;
    private T data;

    private ResultModel() {
    }

    public ResultModel(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResultModel(T data) {
        this.status = ResultModelEnum.ResponseSuccess.getCode();
        this.msg = ResultModelEnum.ResponseSuccess.getMsg();
        this.data = data;
    }

    public static ResultModel build(Integer status, String msg, Object data) {
        return new ResultModel(status, msg, data);
    }

    public static ResultModel ok(Object data) {
        return new ResultModel(data);
    }

    public static ResultModel ok() {
        return new ResultModel((Object) null);
    }

    public static ResultModel build(Integer status, String msg) {
        return new ResultModel(status, msg, (Object) null);
    }

    public static ResultModel fail(String msg) {
        return new ResultModel(ResultModelEnum.ResponseFail.getCode(), msg, (Object) null);
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
