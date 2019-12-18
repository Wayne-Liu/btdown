package org.wayne.btdown.domain;

import java.util.Date;

public class SearchInfo {
    private String url;
    private String title;
    private int searchHot;
    private double size;
    private Date createTime;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSearchHot() {
        return searchHot;
    }

    public void setSearchHot(int searchHot) {
        this.searchHot = searchHot;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SearchInfo{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", searchHot=" + searchHot +
                ", size=" + size +
                ", createTime=" + createTime +
                '}';
    }
}
