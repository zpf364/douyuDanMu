package com.pufang.DyDanMu.model;

import java.util.Date;

/**
 * @author pufang.zpf
 * @date 2018/10/13
 **/
public class DanMuQuery {

    Integer roomId;
    String name;
    Date gmtStart;
    Date gmtEnd;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getGmtStart() {
        return gmtStart;
    }

    public void setGmtStart(Date gmtStart) {
        this.gmtStart = gmtStart;
    }

    public Date getGmtEnd() {
        return gmtEnd;
    }

    public void setGmtEnd(Date gmtEnd) {
        this.gmtEnd = gmtEnd;
    }
}
