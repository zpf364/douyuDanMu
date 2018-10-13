package com.pufang.DyDanMu.model;

import com.pufang.DyDanMu.domain.RoomInfo;
import com.pufang.DyDanMu.dyDanMu.*;
import com.pufang.DyDanMu.service.SchedulerJobExecuteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author pufang.zpf
 * @date 2018/10/13
 **/
public class DanMuRoomInstance {
    Logger logger = LoggerFactory.getLogger(DanMuRoomInstance.class);
    RoomInfo roomProperties;
    DMClient dmClient;

    List<MessageListener> messageListeners = new ArrayList<>();
    Boolean isInit = false;
    Boolean isReady = false;

    public DanMuRoomInstance(RoomInfo roomProperties) {
        this.roomProperties = roomProperties;
        dmClient = new DMClient(roomProperties);
    }

    public void doMessage(MsgView msgView){
        if (msgView == null){
            return ;
        }

        Map<String, Object> msg = msgView.getMessageList();
        if(msg.get("type") != null){
            //服务器反馈错误信息
            if(msg.get("type").equals("error")){
                logger.error(msg.toString());
                //结束心跳和获取弹幕线程
                dmClient.setReadyFlag(false);
            }
            //判断消息类型
            if(msg.get("type").equals("chatmsg")){//弹幕消息
                logger.debug("弹幕消息===>" + msg.toString());
                for (MessageListener messageListener:messageListeners){
                    messageListener.doMessage(msgView);
                }
            }
            else if(msg.get("type").equals("dgb")){//赠送礼物信息
                logger.debug("礼物消息===>" + msg.toString());
            } else {
                logger.debug("其他消息===>" + msg.toString());
            }
        }
    }

    public Boolean getInit() {
        return isInit;
    }

    public void setInit(Boolean init) {
        isInit = init;
    }

    public Boolean getReady() {
        return isReady;
    }

    public void setReady(Boolean ready) {
        isReady = ready;
    }

    public DMClient getDmClient() {
        return dmClient;
    }

    public void setDmClient(DMClient dmClient) {
        this.dmClient = dmClient;
    }

    public boolean start(){
        logger.info("start room id:{}",roomProperties.getRoomId());
        KeepAlive keepAlive = new KeepAlive(dmClient);
        KeepGetMsg keepGetMsg = new KeepGetMsg(String.format("Room-%d",roomProperties.getRoomId()),this);
        SchedulerJobExecuteService.addKeepLiveJob(keepAlive);
        SchedulerJobExecuteService.addRepeatJob(keepGetMsg);
        return true;
    };

    public boolean stop(){
        if (dmClient == null){
            return true;
        }
        dmClient.setReadyFlag(false);
        return true;
    };

    public boolean addListener(MessageListener messageListener){
        return messageListeners.add(messageListener);
    }

    public boolean addListeners(List<MessageListener> messageListeners){
        return this.messageListeners.addAll(messageListeners);
    }
}
