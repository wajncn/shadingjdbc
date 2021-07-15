package com.yoc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yoc.entity.ShardingTable;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description
 * @Author 李定军
 * @Date 2021-06-17
 */
@Mapper
public interface ShardingTableMapper extends BaseMapper<ShardingTable> {

}
