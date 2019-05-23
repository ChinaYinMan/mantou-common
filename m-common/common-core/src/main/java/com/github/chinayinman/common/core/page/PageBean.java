package com.github.chinayinman.common.core.page;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页请求对象
 * (注: 该分页对象不作默认分页处理, pageNum pageSize值不合理; 统一处理成null)
 * @author mantou
 */
@Data
public class PageBean implements Serializable {

    private static final long serialVersionUID = 1865530443683692164L;

    /**
     * 查询索引, 该索引从0开始; 用于Mysql Limit 分页 Limit  limitOffset, limitRows
     */
    private Integer limitOffset;

    /**
     * 查询条数, 从查询索引limitOffset开始; 用于Mysql Limit 分页 Limit  limitOffset, limitRows
     */
    private Integer limitRows;

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 页容量
     */
    private Integer pageSize;


    /**
     * 自定义页码, 页容量 - 构造方法
     * @param pageNum
     * @param pageSize
     */
    public PageBean(Integer pageNum, Integer pageSize) {

        if (pageNum != null && pageSize != null) {

            if (pageNum > 0 && pageSize >0 ) {
                this.pageNum = pageNum;
                this.pageSize = pageSize;

                //计算 Mysql Limit 查询索引, 查询条数计数
                this.limitOffset = (pageNum - 1) * pageSize;
                this.limitRows = pageSize;
            }
        }
    }

    /**
     * 私有的构造方法, 只能通过pageNum, pageSize来构造pageBean
     */
    private PageBean() {

    }

    /**
     * 私有Set方法, limitOffset只能通过PageBean构造方法计算而出
     * @param limitOffset
     */
    private void setLimitOffset(Integer limitOffset) {
        this.limitOffset = limitOffset;
    }

    /**
     * 私有Set方法, limitRows只能通过PageBean构造方法计算而出
     * @param limitRows
     */
    private void setLimitRows(Integer limitRows) {
        this.limitRows = limitRows;
    }

    /**
     * pageNum排除无意义的值, 例如: 0, 负数
     * @param pageNum
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum != null && pageNum > 0 ? pageNum : null;
    }

    /**
     * pageSize排除无意义的值, 例如: 0, 负数
     * @param pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize != null && pageSize > 0 ? pageSize : null;
    }
}
