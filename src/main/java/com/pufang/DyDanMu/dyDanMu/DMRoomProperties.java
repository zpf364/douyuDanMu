package com.pufang.DyDanMu.dyDanMu;

import javax.persistence.MappedSuperclass;

/**
 * @author pufang.zpf
 * @date 2018/10/13
 **/
@MappedSuperclass
public class DMRoomProperties {

    int roomId;
    int groupId = -9999;
    String hostName = "danmu.douyu.com";
    int port = 8601;
    int MaxBufferLength = 8192;


    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getMaxBufferLength() {
        return MaxBufferLength;
    }

    public void setMaxBufferLength(int maxBufferLength) {
        MaxBufferLength = maxBufferLength;
    }
}
