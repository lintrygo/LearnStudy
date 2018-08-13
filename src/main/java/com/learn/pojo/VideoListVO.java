package com.learn.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class VideoListVO {
    private Integer videoClassId;
    private String videoClassName;
    private Integer videoClassWeight;
    private Integer videoId;
    private String videoName;
    private String videoUrl;
    private String videoDescription;
    private Integer videoWeight;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getVideoClassId() {
        return videoClassId;
    }

    public void setVideoClassId(Integer videoClassId) {
        this.videoClassId = videoClassId;
    }

    public String getVideoClassName() {
        return videoClassName;
    }

    public void setVideoClassName(String videoClassName) {
        this.videoClassName = videoClassName;
    }

    public Integer getVideoClassWeight() {
        return videoClassWeight;
    }

    public void setVideoClassWeight(Integer videoClassWeight) {
        this.videoClassWeight = videoClassWeight;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    public Integer getVideoWeight() {
        return videoWeight;
    }

    public void setVideoWeight(Integer videoWeight) {
        this.videoWeight = videoWeight;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
