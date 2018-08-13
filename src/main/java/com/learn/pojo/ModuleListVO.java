package com.learn.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ModuleListVO
{
    private Integer moduleId;
    private String moduleName;
    private String moduleDescription;
    private Integer moduleWeight;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    private String logo;
    private String stageName;
    private Integer stageWeight;
    private String courseName;
    private Integer courseWeight;

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setMooduleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    public Integer getModuleWeight() {
        return moduleWeight;
    }

    public void setModuleWeight(Integer moduleWeight) {
        this.moduleWeight = moduleWeight;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public Integer getStageWeight() {
        return stageWeight;
    }

    public void setStageWeight(Integer stageWeight) {
        this.stageWeight = stageWeight;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseWeight() {
        return courseWeight;
    }

    public void setCourseWeight(Integer courseWeight) {
        this.courseWeight = courseWeight;
    }

    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
