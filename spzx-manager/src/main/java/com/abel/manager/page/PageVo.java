package com.abel.manager.page;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

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


    public <E> PageVo(Page<E> page, List<T> records) {
        this.records = records;
        this.total = page.getTotal();
        this.current = (int)page.getCurrent();
        this.pageSize = (int)page.getSize();
        this.pages = (int)page.getPages();
        this.prev = this.current > 1 ? this.current - 1 : 1;
        this.next = this.current < this.pages ? this.current + 1 : this.pages;
    }
}
