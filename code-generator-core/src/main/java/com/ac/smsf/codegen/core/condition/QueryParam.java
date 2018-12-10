package com.ac.smsf.codegen.core.condition;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 通用查询检索条件参数
 */
@Getter
@Setter
public class QueryParam implements Serializable {

    // 检索条件
    private FilterRule filterrule;

    // 排序
    private String sorting;

    // tenant Table
    private String tenantTable;

    //第几页
    private int currentpage;

    //每页几条数据
    private int rowsperpage;

    public String getSorting() {
        if (sorting == null || sorting.equals("")) {
            return "id asc";
        }
        return this.sorting;
    }

}
