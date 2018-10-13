package com.pufang.DyDanMu.service;

import com.pufang.DyDanMu.domain.DanMuRepository;
import com.pufang.DyDanMu.domain.RoomInfo;
import com.pufang.DyDanMu.domain.RoomInfoRepository;
import com.pufang.DyDanMu.dyDanMu.DMClient;
import com.pufang.DyDanMu.dyDanMu.DMRoomProperties;
import com.pufang.DyDanMu.dyDanMu.MessageListener;
import com.pufang.DyDanMu.model.DanMuRoomInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Lists;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author pufang.zpf
 * @date 2018/10/13
 **/
@Service
public class DanMuRoomServiceImpl implements DanMuRoomService{

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RoomInfoRepository roomInfoRepository;

    @Autowired
    List<MessageListener> messageListenerList;

    Map<Integer,DanMuRoomInstance> clientList = new Hashtable();

    @PostConstruct
    public void init(){
        Iterable<RoomInfo> roomInfos = roomInfoRepository.findAll();
        for (RoomInfo roomInfo:roomInfos){
            DanMuRoomInstance instance = new DanMuRoomInstance(roomInfo);
            instance.addListeners(messageListenerList);
            clientList.put(roomInfo.getRoomId(),instance);
            Boolean result = instance.start();
            logger.info("start listener room {} result {}",roomInfo.getRoomId(),result);
        }
    }

    @Override
    public boolean addNewRoom(int roomId,String owner){
        RoomInfo roomInfo = new RoomInfo();
        roomInfo.setRoomId(roomId);
        roomInfo.setOwner(owner);
        roomInfoRepository.save(roomInfo);
        DanMuRoomInstance instance = new DanMuRoomInstance(roomInfo);
        instance.addListeners(messageListenerList);
        boolean result=instance.start();
        logger.info("add listener room {} result {}",roomInfo.getRoomId(),result);
        clientList.put(roomInfo.getRoomId(),instance);
        return result;
    }

    @Override
    public boolean removeRoom(int roomId){

        DanMuRoomInstance danMuRoomInstance = clientList.getOrDefault(roomId,null);

        if (danMuRoomInstance == null){
            return true;
        }

        danMuRoomInstance.stop();
        clientList.put(roomId,null);
        return true;
    }

    @Override
    public List<RoomInfo> listAllRoom() {
        Iterable<RoomInfo> roomInfos=roomInfoRepository.findAll();
        List<RoomInfo> roomInfoList = new ArrayList<>();
        roomInfos.forEach(e->{roomInfoList.add(e);});
        return roomInfoList;
    }
}
