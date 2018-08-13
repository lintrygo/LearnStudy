package com.learn.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CatalogListVO {
    private Integer catalogId;
    private String catalogTitle;
    private String catalogDescription;
    private String catalogVideo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date catalogCreateTime;
    private Integer catalogWeight;
    private Integer moduleId;
    private String moduleName;
    private Integer stageId;
    private String stageName;
    private Integer courseId;
    private String courseName;

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogTitle() {
        return catalogTitle;
    }

    public void setCatalogTitle(String catalogTitle) {
        this.catalogTitle = catalogTitle;
    }

    public String getCatalogDescription() {
        return catalogDescription;
    }

    public void setCatalogDescription(String catalogDescription) {
        this.catalogDescription = catalogDescription;
    }

    public String getCatalogVideo() {
        return catalogVideo;
    }

    public void setCatalogVideo(String catalogVideo) {
        this.catalogVideo = catalogVideo;
    }

    public Date getCatalogCreateTime() {
        return catalogCreateTime;
    }

    public void setCatalogCreateTime(Date catalogCreateTime) {
        this.catalogCreateTime = catalogCreateTime;
    }

    public Integer getCatalogWeight() {
        return catalogWeight;
    }

    public void setCatalogWeight(Integer catalogWeight) {
        this.catalogWeight = catalogWeight;
    }

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

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
