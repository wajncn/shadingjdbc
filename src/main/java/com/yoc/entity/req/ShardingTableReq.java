package com.yoc.entity.req;

import lombok.Data;

/**
 * @Description
 * @Author 李定军
 * @Date 2021-06-17
 */
@Data
public class ShardingTableReq {
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 手机号码
     */
    private String mobilePhone;
}
