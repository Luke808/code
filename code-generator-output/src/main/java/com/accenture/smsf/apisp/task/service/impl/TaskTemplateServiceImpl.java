package com.accenture.smsf.apisp.task.service.impl;

import com.accenture.smsf.apisp.task.core.entity.TaskTemplate;
import com.accenture.smsf.apisp.task.service.TaskTemplateService;
import com.ac.smsf.codegen.core.service.impl.AbstractMapperServiceImpl;
import com.accenture.smsf.framework.boot.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author s.c.gao
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class TaskTemplateServiceImpl extends AbstractMapperServiceImpl<TaskTemplate> implements TaskTemplateService {


}
