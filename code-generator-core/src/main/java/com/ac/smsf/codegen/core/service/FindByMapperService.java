package com.ac.smsf.codegen.core.service;

import java.util.List;

/**
 * @param <T>
 * @author s.c.gao
 */
public interface FindByMapperService<T> {

    /**
     * 根据输入条件查询
     *
     * @param t
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<T> findBy(T t, int pageNumber, int pageSize);

    /**
     * 根据输入条件查询, 无分页
     *
     * @param t
     * @return
     */
    List<T> findBy(T t);

    /**
     * 根据输入条件查询, 无分页
     *
     * @param t
     * @return
     */
    List<T> findByColumns(T t, String columns);

    /**
     * 单条件，指定查询
     *
     * @param fieldName
     * @param value
     * @return
     */
    T findBy(String fieldName, Object value);
}
