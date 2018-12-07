package com.accenture.smsf.codegen.core.mapper;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @author s.c.gao
 * @param <T>
 */
public interface BaseMapper<T> extends tk.mybatis.mapper.common.BaseMapper<T>, ConditionMapper<T>, IdsMapper<T>, InsertListMapper<T> {
}
