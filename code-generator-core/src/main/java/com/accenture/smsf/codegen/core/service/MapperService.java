package com.accenture.smsf.codegen.core.service;

import java.util.List;

/**
 * @author s.c.gao
 * @param <T>
 */
public interface MapperService<T> {

    /**
     * 保存一条记录
     * @param model
     * @return
     */
    int save(T model);

    /**
     * 批量保存记录
     * @param models
     */
    int save(List<T> models);

    /**
     * 更新指定列
     * @param model
     * @return
     */
    int update(T model);

    /**
     * 删除一条记录
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 删除多条记录
     * @param ids   "a,b,c,d"
     * @return
     */
    int batchDelete(String ids);

    /**
     * 分页显示记录
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<T> list(int pageNumber, int pageSize);

    /**
     * 根据一个id查询记录
     * @param id
     * @return
     */
    T findById(String id);

}
