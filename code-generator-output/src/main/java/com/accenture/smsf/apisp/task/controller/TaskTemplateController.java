package com.accenture.smsf.apisp.task.controller;

import com.accenture.smsf.apisp.task.core.entity.TaskTemplate;
import com.accenture.smsf.apisp.task.service.TaskTemplateService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import com.accenture.smsf.framework.starter.web.core.annotation.RestController;

import java.util.List;

/**
 *
 * @author s.c.gao
 */
@RestController
@RequestMapping("/task/taskTemplate")
public class TaskTemplateController {

    @Autowired
    TaskTemplateService taskTemplateService;

    @PostMapping("/save")
    public int taskTemplateSave(@RequestBody TaskTemplate taskTemplate) {
        return taskTemplateService.save(taskTemplate);
    }

    @PostMapping("/batch-save")
    public int taskTemplateBatchSave(@RequestBody List<TaskTemplate> taskTemplates) {
        return taskTemplateService.save(taskTemplates);
    }

    @DeleteMapping("/delete")
    public int taskTemplateDelete(@RequestParam("id") String id) {
	    return taskTemplateService.delete(id);
    }

    @DeleteMapping("/batch-delete")
    public int taskTemplateBatchDelete(@RequestParam("ids") String ids) {
        return taskTemplateService.batchDelete("\"" + String.join("\",\"", ids.split(",")) + "\"");
    }

    @PutMapping("/update")
    public int taskTemplateUpdate(@RequestBody TaskTemplate taskTemplate) {
	    return taskTemplateService.update(taskTemplate);
    }

    @GetMapping("/find")
    public TaskTemplate taskTemplateFind(@RequestParam("id") String id) {
        return taskTemplateService.findById(id);
    }

    @GetMapping("/list-paged/{page-no}/{page-size}")
    public PageInfo<TaskTemplate> taskTemplateListPaged(@PathVariable(value="page-no") int
    pageNumber,
    @PathVariable(value="page-size") int pageSize) {
        List<TaskTemplate> list = taskTemplateService.list(pageNumber, pageSize);
        return new PageInfo<>(list);
    }

    @GetMapping("/list")
    public List<TaskTemplate> taskTemplateList() {
        return taskTemplateService.list();
    }

    @PostMapping("/find-by-paged/{page-no}/{page-size}")
    public PageInfo<TaskTemplate> taskTemplateFindByPaged(@RequestBody TaskTemplate
    taskTemplate, @PathVariable("page-no") int pageNumber, @PathVariable("page-size") int pageSize) {
        List<TaskTemplate> list = taskTemplateService.findBy(taskTemplate, pageNumber, pageSize);
        return new PageInfo<>(list);
    }

    @PostMapping("/find-by")
    public List<TaskTemplate> taskTemplateFindBy(@RequestBody TaskTemplate
    taskTemplate) {
        return taskTemplateService.findBy(taskTemplate);
    }

    @GetMapping("/find-one")
    public TaskTemplate taskTemplateFindOne(@RequestParam("fieldName") String fieldName,
    @RequestParam("value") String
    value) {
        return taskTemplateService.findBy(fieldName, value);
    }

    @PostMapping("/find-by/{columns}")
    public List<TaskTemplate> taskTemplateFindByColumnsPaged(@RequestBody TaskTemplate taskTemplate,
    @PathVariable("columns") String columns) {
        return taskTemplateService.findByColumns(taskTemplate, columns);
    }
}
