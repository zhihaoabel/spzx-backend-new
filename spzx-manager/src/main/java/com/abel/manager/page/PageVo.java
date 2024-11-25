package com.abel.manager.page;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageInfo;

import lombok.Data;

@Data
public class PageVo<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 53023383L;

    private List<T> records;      // 数据列表
    private Long total;           // 总记录数
    private Integer prev;         // 上一页
    private Integer current;      // 当前页码
    private Integer next;         // 下一页
    private Integer pageSize;     // 每页记录数
    private Integer pages;        // 总页数

    public PageVo(PageInfo<T> pageInfo) {
        this.records = pageInfo.getList();
        this.total = pageInfo.getTotal();
        this.prev = pageInfo.getPrePage();
        this.current = pageInfo.getPageNum();
        this.next = pageInfo.getNextPage();
        this.pageSize = pageInfo.getPageSize();
        this.pages = pageInfo.getPages();
    }
}
