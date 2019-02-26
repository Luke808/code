package com.accenture.smsf.apisp.task.core.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_task_template")
public class TaskTemplate {
    @Id
    private String id;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "data_url")
    private String dataUrl;

    @Column(name = "result_url")
    private String resultUrl;

    @Column(name = "process_url")
    private String processUrl;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_time")
    private Date modifiedTime;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return task_name
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * @param taskName
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * @return data_url
     */
    public String getDataUrl() {
        return dataUrl;
    }

    /**
     * @param dataUrl
     */
    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    /**
     * @return result_url
     */
    public String getResultUrl() {
        return resultUrl;
    }

    /**
     * @param resultUrl
     */
    public void setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl;
    }

    /**
     * @return process_url
     */
    public String getProcessUrl() {
        return processUrl;
    }

    /**
     * @param processUrl
     */
    public void setProcessUrl(String processUrl) {
        this.processUrl = processUrl;
    }

    /**
     * @return create_by
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return modified_by
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * @param modifiedBy
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * @return modified_time
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * @param modifiedTime
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}