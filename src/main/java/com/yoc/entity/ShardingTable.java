package com.yoc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author 李定军
 * @Date 2021-06-17
 */
@TableName("sharding_table")
@Data
public class ShardingTable implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 手机号码
     */
    private String mobilePhone;
    /**
     * 更新人
     */
    private Date createDate;
}