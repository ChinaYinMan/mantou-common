package com.mantou.common.core.page;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页响应对象
 * @author mantou
 */
@Data
public class PageInfo<T> implements Serializable {

    private static final long serialVersionUID = 7808414982741104306L;

    /**
     * 总条数
     */
    private Long total;

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 页容量
     */
    private Integer pageSize;

    /**
     * 是否最后一页
     */
    private boolean lastPage;

    /**
     * list数据
     */
    private List<T> list;


    public PageInfo(Long total, PageBean pageBean, List<T> list) {
        this(total, pageBean.getPageNum(), pageBean.getPageSize(), list);
    }

    public PageInfo(Long total, Integer pageNum, Integer pageSize, List<T> list) {
        this.pageNum = pageNum != null && pageNum > 0 ? pageNum : 0;
        this.pageSize = pageSize != null && pageSize > 0 ? pageSize : 0;
        this.list = (List)(list == null ? new ArrayList() : list);
        this.total = total;
        int endPage = (int)(this.total / (long)this.pageSize + (long)(this.total % (long)this.pageSize == 0L ? 0 : 1));
        this.lastPage = endPage == 0 || pageNum >= endPage;
    }


}
