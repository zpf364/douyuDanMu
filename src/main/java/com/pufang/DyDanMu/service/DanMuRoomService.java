package com.pufang.DyDanMu.service;

import com.pufang.DyDanMu.domain.RoomInfo;

import java.util.List;

/**
 * @Author pufang.zpf
 * @Date 2018/10/13
 **/
public interface DanMuRoomService {

    boolean addNewRoom(int roomId,String owner);
    boolean removeRoom(int roomId);
    List<RoomInfo> listAllRoom();
}

