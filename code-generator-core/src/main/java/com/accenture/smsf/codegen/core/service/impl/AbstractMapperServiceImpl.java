package com.accenture.smsf.codegen.core.service.impl;

import com.accenture.smsf.codegen.core.mapper.BaseMapper;
import com.accenture.smsf.codegen.core.service.MapperService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author s.c.gao
 * @param <T>
 */
public abstract class AbstractMapperServiceImpl<T> implements MapperService<T> {

    BaseMapper<T> baseMapper;

    public AbstractMapperServiceImpl(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public int save(T model) {
        return baseMapper.insert(model);
    }

    @Override
    public int save(List<T> models) {
        return baseMapper.insertList(models);
    }

    @Override
    public int update(T model) {
        return baseMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public int delete(String id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int batchDelete(String ids) {
        return baseMapper.deleteByIds(ids);
    }

    @Override
    public List<T> list(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return baseMapper.selectAll();
    }

    @Override
    public T findById(String id) {
        return baseMapper.selectByPrimaryKey(id);
    }
}
