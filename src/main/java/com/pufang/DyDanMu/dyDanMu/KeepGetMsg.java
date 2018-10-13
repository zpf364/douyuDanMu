package com.pufang.DyDanMu.dyDanMu;

import com.pufang.DyDanMu.model.DanMuRoomInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class KeepGetMsg extends Thread {

    static Logger logger = LoggerFactory.getLogger(KeepGetMsg.class);

    private DMClient danmuClient;
    private DanMuRoomInstance danMuRoomInstance;

    public KeepGetMsg(String name, DanMuRoomInstance danMuRoomInstance) {
        super(name);
        this.danmuClient = danMuRoomInstance.getDmClient();
        this.danMuRoomInstance = danMuRoomInstance;
    }

    @Override
    public void run() {
    	//判断客户端就绪状态
        while(danmuClient.getReadyFlag()) {
        	//获取服务器发送的弹幕信息
        	List<MsgView> msgViewList = danmuClient.getServerMsg();
            logger.info("room {} get message size:{}",danmuClient.getDmRoomProperties().getRoomId(),msgViewList.size());

            try {
                for (MsgView msgView:msgViewList){
                    danMuRoomInstance.doMessage(msgView);
                }
            } catch (Exception e) {
                logger.error("doMessage error",e);
            }
        }
    }
}
