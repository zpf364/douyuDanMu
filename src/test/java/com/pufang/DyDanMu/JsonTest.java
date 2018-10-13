package com.pufang.DyDanMu;

import com.alibaba.fastjson.JSON;
import com.pufang.DyDanMu.domain.DanMu;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author pufang.zpf
 * @date 2018/10/13
 **/
public class JsonTest {

    String data="{\"nn\":\"来瓶营养快线666\",\"bnn\":\"蘑菇\",\"level\":\"16\",\"cst\":\"1539414698617\",\"brid\":\"71017\","
        + "\"el\":{\"eid@A=1500000113@Setp@A=1@Ssc@A=1@Sef@A=0@S\":\"\"},\"bl\":\"12\",\"type\":\"chatmsg\","
        + "\"rid\":\"74751\",\"ct\":\"1\",\"uid\":\"142817875\",\"txt\":\"嬲啊\",\"cbid\":\"71017\",\"sahf\":\"0\","
        + "\"ic\":\"avatar_v3@S201809@Sc964fc03deda995e213f427b6f977c8f\","
        + "\"hc\":\"d875d2cd24df63829aa2cf5d3b6eb0f2\",\"nl\":\"7\",\"cid\":\"3b49cbd78ea3489f1c6f180000000000\","
        + "\"lk\":\"\"}\n";


    @Test
    public void testJson(){
        DanMu danmu = JSON.parseObject(data,DanMu.class);
        Assert.assertNotNull(danmu);
    }
}
