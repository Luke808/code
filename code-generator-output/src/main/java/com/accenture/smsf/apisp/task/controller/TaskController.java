package com.accenture.smsf.apisp.task.controller;

import com.accenture.smsf.apisp.task.core.entity.Task;
import com.accenture.smsf.apisp.task.service.TaskService;
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
@RequestMapping("/task/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/save")
    public int taskSave(@RequestBody Task task) {
        return taskService.save(task);
    }

    @PostMapping("/batch-save")
    public int taskBatchSave(@RequestBody List<Task> tasks) {
        return taskService.save(tasks);
    }

    @DeleteMapping("/delete")
    public int taskDelete(@RequestParam("id") String id) {
	    return taskService.delete(id);
    }

    @DeleteMapping("/batch-delete")
    public int taskBatchDelete(@RequestParam("ids") String ids) {
        return taskService.batchDelete("\"" + String.join("\",\"", ids.split(",")) + "\"");
    }

    @PutMapping("/update")
    public int taskUpdate(@RequestBody Task task) {
	    return taskService.update(task);
    }

    @GetMapping("/find")
    public Task taskFind(@RequestParam("id") String id) {
        return taskService.findById(id);
    }

    @GetMapping("/list-paged/{page-no}/{page-size}")
    public PageInfo<Task> taskListPaged(@PathVariable(value="page-no") int
    pageNumber,
    @PathVariable(value="page-size") int pageSize) {
        List<Task> list = taskService.list(pageNumber, pageSize);
        return new PageInfo<>(list);
    }

    @GetMapping("/list")
    public List<Task> taskList() {
        return taskService.list();
    }

    @PostMapping("/find-by-paged/{page-no}/{page-size}")
    public PageInfo<Task> taskFindByPaged(@RequestBody Task
    task, @PathVariable("page-no") int pageNumber, @PathVariable("page-size") int pageSize) {
        List<Task> list = taskService.findBy(task, pageNumber, pageSize);
        return new PageInfo<>(list);
    }

    @PostMapping("/find-by")
    public List<Task> taskFindBy(@RequestBody Task
    task) {
        return taskService.findBy(task);
    }

    @GetMapping("/find-one")
    public Task taskFindOne(@RequestParam("fieldName") String fieldName,
    @RequestParam("value") String
    value) {
        return taskService.findBy(fieldName, value);
    }

    @PostMapping("/find-by/{columns}")
    public List<Task> taskFindByColumnsPaged(@RequestBody Task task,
    @PathVariable("columns") String columns) {
        return taskService.findByColumns(task, columns);
    }
}
