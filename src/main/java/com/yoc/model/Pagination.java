package com.yoc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description
 * @Author 李定军
 * @Date 2021-06-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagination<T> {
    /**
     * 总数量
     */
    private long total = 0L;
    /**
     * 返回数据
     */
    private List<T> rows;

    public static <T> Pagination<T> buildPageResult(Long total,List<T> rows){
        Pagination pagination = new Pagination<T>();
        pagination.setRows(rows);
        pagination.setTotal(total);
        return pagination;
    }
}
