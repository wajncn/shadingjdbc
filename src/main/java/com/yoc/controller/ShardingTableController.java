package com.yoc.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yoc.entity.ShardingTable;
import com.yoc.entity.req.ShardingTableReq;
import com.yoc.model.Pagination;
import com.yoc.model.ResultModel;
import com.yoc.service.IShardingTableService;
import com.yoc.utils.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author 李定军
 * @Date 2021-06-17
 */
@RestController
public class ShardingTableController {

    @Autowired
    private IShardingTableService shardingTableService;

    @PostMapping("/shardingtable/save")
    public ResultModel save(@RequestBody ShardingTableReq request) {
        ShardingTable shardingTable = new ShardingTable();
        shardingTable.setId(request.getId());
        shardingTable.setMobilePhone(request.getMobilePhone());
        shardingTable.setName(request.getName());
        shardingTable.setCreateDate(new Date());
        shardingTableService.save(shardingTable);
        return ResultModel.ok();
    }

    @PostMapping("/shardingtable/batch/add")
    public ResultModel batchAdd() {
        long start = System.currentTimeMillis();
        for (Long i = 7656L; i < 50000000; i++) {
            ShardingTable shardingTable = new ShardingTable();
            shardingTable.setId(i);
            shardingTable.setMobilePhone(StringTools.createMobile(0));
            shardingTable.setName(StringTools.genRandomNum(6));
            shardingTable.setCreateDate(new Date());
            shardingTableService.save(shardingTable);
        }
        long end = System.currentTimeMillis();
        return ResultModel.ok((end - start));
    }
    @GetMapping("/shardingtable/batch/add")
    public ResultModel batchAdd2() {
        long start = System.currentTimeMillis();
        for (int i = 1; i < 20; i++) {
            ShardingTable shardingTable = new ShardingTable();
//            shardingTable.setId(i);
            shardingTable.setMobilePhone(StringTools.createMobile(0));
            shardingTable.setName(StringTools.genRandomNum(6));
            shardingTable.setCreateDate(new Date());
            shardingTableService.save(shardingTable);
        }
        long end = System.currentTimeMillis();
        return ResultModel.ok((end - start));
    }

    @GetMapping("/shardingtable/{id}")
    public ResultModel getUserById(@PathVariable("id") Long id) {
        return ResultModel.ok(shardingTableService.getById(id));
    }

    @PostMapping("/shardingtable/updatebyid")
    public ResultModel updateById(@RequestBody ShardingTableReq request) {
        ShardingTable shardingTable = new ShardingTable();
        shardingTable.setId(request.getId());
        shardingTable.setMobilePhone(request.getMobilePhone());
        shardingTable.setName(request.getName());
        shardingTableService.updateById(shardingTable);
        return ResultModel.ok();
    }

    @DeleteMapping("/shardingtable/{id}")
    public ResultModel deleteById(@PathVariable("id") Long id) {
        shardingTableService.removeById(id);
        return ResultModel.ok();
    }

    @GetMapping("/shardingtable/selectbyids")
    public ResultModel selectByIds(@RequestParam(value = "ids") List<Long> ids) {
        return ResultModel.ok(shardingTableService.listByIds(ids));
    }

    @GetMapping("/shardingtable/deletebymap")
    public ResultModel deleteByMap(String name) {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("name", name);
        shardingTableService.removeByMap(columnMap);
        return ResultModel.ok();
    }

    @GetMapping("/shardingtable/delete")
    public ResultModel delete(String name) {
        LambdaQueryWrapper<ShardingTable> queryWrapper = new LambdaQueryWrapper<ShardingTable>();
        queryWrapper.eq(ShardingTable::getName, name);
        shardingTableService.remove(queryWrapper);
        return ResultModel.ok();
    }


    @PostMapping("/shardingtable/update")
    public ResultModel update() {
        ShardingTable shardingTable = new ShardingTable();
        shardingTable.setMobilePhone("15882428153");

        LambdaQueryWrapper<ShardingTable> queryWrapper = new LambdaQueryWrapper<ShardingTable>();
        queryWrapper.eq(ShardingTable::getName, "lidingjun");

        shardingTableService.update(shardingTable, queryWrapper);
        return ResultModel.ok();
    }

    @GetMapping("/shardingtable/selectbymap")
    public ResultModel selectByMap(String name) {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("name", name);
        return ResultModel.ok(shardingTableService.listByMap(columnMap));
    }

    @GetMapping("/shardingtable/selectone")
    public ResultModel selectOne(String name) {
        LambdaQueryWrapper<ShardingTable> queryWrapper = new LambdaQueryWrapper<ShardingTable>();
        queryWrapper.eq(ShardingTable::getName, name);
        return ResultModel.ok(shardingTableService.getOne(queryWrapper));
    }

    @GetMapping("/shardingtable/selectcount")
    public ResultModel selectCount(String name) {
        LambdaQueryWrapper<ShardingTable> queryWrapper = new LambdaQueryWrapper<ShardingTable>();
        queryWrapper.eq(ShardingTable::getName, name);
        return ResultModel.ok(shardingTableService.count(queryWrapper));
    }

    @GetMapping("/shardingtable/selectlist")
    public ResultModel selectList(String name) {
        LambdaQueryWrapper<ShardingTable> queryWrapper = new LambdaQueryWrapper<ShardingTable>();
        queryWrapper.eq(ShardingTable::getName, name);
        return ResultModel.ok(shardingTableService.list(queryWrapper));
    }

    @GetMapping("/shardingtable/selectmaps")
    public ResultModel selectMaps(String name) {
        LambdaQueryWrapper<ShardingTable> queryWrapper = new LambdaQueryWrapper<ShardingTable>();
        queryWrapper.eq(ShardingTable::getName, name);
        return ResultModel.ok(shardingTableService.listMaps(queryWrapper));
    }

    @GetMapping("/shardingtable/selectobjs")
    public ResultModel selectObjs(String name) {
        LambdaQueryWrapper<ShardingTable> queryWrapper = new LambdaQueryWrapper<ShardingTable>();
        queryWrapper.eq(ShardingTable::getName, name);
        return ResultModel.ok(shardingTableService.listObjs(queryWrapper));
    }

    @GetMapping("/shardingtable/selectpage")
    public ResultModel selectPage(int start, String name) {
        LambdaQueryWrapper<ShardingTable> queryWrapper = new LambdaQueryWrapper<ShardingTable>();
        queryWrapper.like(ShardingTable::getName, name);
        IPage<ShardingTable> page = new Page<>(start, 10);
        IPage<ShardingTable> tableIPage = shardingTableService.page(page, queryWrapper);
        return ResultModel.ok(Pagination.buildPageResult(tableIPage.getTotal(), tableIPage.getRecords()));
    }
}
