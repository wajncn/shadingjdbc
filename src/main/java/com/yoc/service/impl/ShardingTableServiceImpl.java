package com.yoc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoc.entity.ShardingTable;
import com.yoc.mapper.ShardingTableMapper;
import com.yoc.service.IShardingTableService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author 李定军
 * @Date 2021-06-17
 */
@Service
public class ShardingTableServiceImpl extends ServiceImpl<ShardingTableMapper, ShardingTable> implements IShardingTableService {

}
