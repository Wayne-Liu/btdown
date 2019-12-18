package org.wayne.btdown.domain;

import java.util.Date;

public class TorrentDO {
    private int id;
    private String torrentId;
    private String url;
    private int hasDown;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTorrentId() {
        return torrentId;
    }

    public void setTorrentId(String torrentId) {
        this.torrentId = torrentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHasDown() {
        return hasDown;
    }

    public void setHasDown(int hasDown) {
        this.hasDown = hasDown;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
