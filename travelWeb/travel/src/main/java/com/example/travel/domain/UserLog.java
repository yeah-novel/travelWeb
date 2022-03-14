package com.example.travel.domain;

import java.util.Date;

public class UserLog {
    private long id;   //心得id
    private long userId; //分享用户id
    private Date date;  //分享时间
    private String logContent;  //心得内容
    private int logStatus;  //心得分享状态

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    public int getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(int logStatus) {
        this.logStatus = logStatus;
    }
}
