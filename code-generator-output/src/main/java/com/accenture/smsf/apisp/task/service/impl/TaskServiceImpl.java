package com.accenture.smsf.apisp.task.service.impl;

import com.accenture.smsf.apisp.task.core.entity.Task;
import com.accenture.smsf.apisp.task.service.TaskService;
import com.ac.smsf.codegen.core.service.impl.AbstractMapperServiceImpl;
import com.accenture.smsf.framework.boot.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author s.c.gao
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class TaskServiceImpl extends AbstractMapperServiceImpl<Task> implements TaskService {


}
