package com.yoc.model;

/**
 * @Description
 * @Author 李定军
 * @Date 2021-06-18
 */
public enum ResultModelEnum {
    ResponseSuccess(200, "操作成功！"),
    ResponseFail(400, ""),
    Unauthorized(401, "Unauthorized "),
    RefreshToekn(403, "Unauthorized Refresh Toekn"),
    IllegalParam(405, "参数异常");

    private int code;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    private ResultModelEnum(final int code, final String msg) {
        this.code = code;
        this.msg = msg;
    }
}
