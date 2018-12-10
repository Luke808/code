package com.ac.smsf.codegen.core.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

/**
 * @param <T>
 * @author s.c.gao
 */
@RegisterMapper
public interface QueryConditionMapper<T> {

    List<T> findBy(@Param("condition") String condition);
}
