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


    /**
     * 总条数, 分页对象, 分页数据 - 构造方法
     * @param total
     * @param pageBean
     * @param list
     */
    public PageInfo(Long total, PageBean pageBean, List<T> list) {
        this(total, pageBean.getPageNum(), pageBean.getPageSize(), list);
    }

    /**
     * 总条数, 页码, 页容量, 分页数据 - 构造方法
     * @param total
     * @param pageNum
     * @param pageSize
     * @param list
     */
    public PageInfo(Long total, Integer pageNum, Integer pageSize, List<T> list) {
        //页码    页码值无意义, 默认处理成0
        this.pageNum = pageNum != null && pageNum > 0 ? pageNum : 0;
        //页容量  页容量无意义, 默认处理成0
        this.pageSize = pageSize != null && pageSize > 0 ? pageSize : 0;
        //数据    数据无意义, 默认处理成new ArrayList();
        this.list = (List)(list == null ? new ArrayList() : list);
        //总数    总数无意义, 处理成0
        this.total = total != null && total >= 0 ? total : 0;

        if (this.pageNum != null && this.pageNum != 0 && this.pageSize != null && this.pageSize != 0) {
            //最后一页
            int endPage = (int)(this.total / (long)this.pageSize + (long)(this.total % (long)this.pageSize == 0L ? 0 : 1));
            // 是否最后一页
            this.lastPage = endPage == 0 || pageNum >= endPage;
        }
    }



}
