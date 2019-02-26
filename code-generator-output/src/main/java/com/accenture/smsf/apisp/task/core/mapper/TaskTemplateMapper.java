package com.accenture.smsf.apisp.task.core.mapper;

import com.ac.smsf.codegen.core.mapper.BaseMapper;
import com.accenture.smsf.apisp.task.core.entity.TaskTemplate;
import com.accenture.smsf.apisp.task.core.entity.TaskTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskTemplateMapper extends BaseMapper<TaskTemplate> {
    long countByExample(TaskTemplateExample example);

    int deleteByExample(TaskTemplateExample example);

    List<TaskTemplate> selectByExample(TaskTemplateExample example);

    int updateByExampleSelective(@Param("record") TaskTemplate record, @Param("example") TaskTemplateExample example);

    int updateByExample(@Param("record") TaskTemplate record, @Param("example") TaskTemplateExample example);
}