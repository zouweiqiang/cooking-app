package com.term;

import java.io.Serializable;

class ItemBean implements Serializable {
    private String title;
    private String subTitle;
    private String content;
    private String userName;
    private String praiseNum;
    private String messageNum;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(String praiseNum) {
        this.praiseNum = praiseNum;
    }

    public String getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(String messageNum) {
        this.messageNum = messageNum;
    }
}
