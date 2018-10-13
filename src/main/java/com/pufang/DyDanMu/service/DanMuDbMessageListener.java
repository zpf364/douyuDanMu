package com.pufang.DyDanMu.service;

import com.alibaba.fastjson.JSON;
import com.pufang.DyDanMu.domain.DanMu;
import com.pufang.DyDanMu.domain.DanMuRepository;
import com.pufang.DyDanMu.dyDanMu.MessageListener;
import com.pufang.DyDanMu.dyDanMu.MsgView;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author pufang.zpf
 * @date 2018/10/13
 **/
@Component
public class DanMuDbMessageListener implements MessageListener {

    Logger logger = LoggerFactory.getLogger(DanMuDbMessageListener.class);

    @Autowired
    DanMuRepository danMuRepository;

    @Override
    public void doMessage(MsgView msgView) {
        logger.debug("DanMuDbMessageListener save data {}",msgView.getMessageList().toString());

        Map<String,Object> message = msgView.getMessageList();

        String cst = message.getOrDefault("cst",System.currentTimeMillis()).toString();
        if (StringUtils.length(cst)<11){
            message.put("cst",Long.valueOf(cst)*1000);
        }

        logger.debug("DanMuDbMessageListener save data json{}",JSON.toJSONString(message));
        DanMu danmu = JSON.parseObject(JSON.toJSONString(message),DanMu.class);
        danMuRepository.save(danmu);
    }
}
