package com.pufang.DyDanMu.domain;

import com.pufang.DyDanMu.dyDanMu.DMRoomProperties;

import javax.persistence.*;

/**
 * @author pufang.zpf
 * @date 2018/10/13
 **/
@Entity
public class RoomInfo extends DMRoomProperties {

    @Id
    @GeneratedValue
    long id;

    String owner;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
