package com.ac.smsf.codegen.core.service.impl;

import com.ac.smsf.codegen.core.mapper.BaseMapper;
import com.ac.smsf.codegen.core.service.MapperService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @param <T>
 * @author s.c.gao
 */
@Slf4j
public abstract class AbstractMapperServiceImpl<T> implements MapperService<T> {

    @Autowired
    BaseMapper<T> baseMapper;

    private Class<T> tClass;

    public AbstractMapperServiceImpl() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        tClass = (Class<T>) pt.getActualTypeArguments()[0];
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

    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T model = tClass.getConstructor().newInstance();
            Field field = tClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return baseMapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            log.error("查询操作异常", e);
            return null;
        }
    }

    @Override
    public List<T> findBy(T t, int pageNumber, int pageSize) {
        Condition condition = new Condition(t.getClass(), false, false);
        Example.Criteria criteria = condition.createCriteria();
        Field[] fields = t.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(t);
                if (value == null) {
                    continue;
                }
                Class<?> type = field.getType();
                if (type == int.class || type == Integer.class || type == long.class ||
                        type == Long.class || type == double.class || type == Double.class ||
                        type == float.class || type == Float.class || type == Date.class) {
                    // 数字和日期类型 == 匹配
                    criteria.andEqualTo(field.getName(), value);
                } else if (type == String.class) {
                    // 字符类型模糊匹配，为了使用索引，只支持后置模糊匹配
                    criteria.andLike(field.getName(), value + "%");
                } else {
                    // 其他情况暂不处理
                }
            }
        } catch (Exception e) {
            log.error("查询参数解析异常", e);
            return Collections.emptyList();
        }
        PageHelper.startPage(pageNumber, pageSize);
        return baseMapper.selectByCondition(condition);
    }

}
