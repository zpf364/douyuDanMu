package com.pufang.DyDanMu.dyDanMu;

public class KeepAlive extends Thread {

    private DMClient danmuClient;

    public KeepAlive(DMClient dmClient) {
        super();
        this.danmuClient = dmClient;
    }

    @Override
    public void run() {

    	//判断客户端就绪状态
        while(danmuClient.getReadyFlag())
        {
        	//发送心跳保持协议给服务器端
        	danmuClient.keepAlive();
            try
            {
            	//设置间隔45秒再发送心跳协议
                Thread.sleep(45000);        //keep live at least once per minute
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
