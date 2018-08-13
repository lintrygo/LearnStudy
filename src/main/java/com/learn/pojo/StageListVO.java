package com.learn.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class StageListVO {
    private Integer courseId;
    private String courseName;
    private Integer courseWeight;
    private Integer stageId;
    private String stageName;
    private String stageDescription;
    private Integer stageWeight;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCoureseName(String coureseName) {
        this.courseName = coureseName;
    }

    public Integer getCourseWeight() {
        return courseWeight;
    }

    public void setCourseWeight(Integer courseWeight) {
        this.courseWeight = courseWeight;
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

    public String getStageDescription() {
        return stageDescription;
    }

    public void setStageDescription(String stageDescription) {
        this.stageDescription = stageDescription;
    }

    public Integer getStageWeight() {
        return stageWeight;
    }

    public void setStageWeight(Integer stageWeight) {
        this.stageWeight = stageWeight;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
