package com.pufang.DyDanMu.service;

import com.pufang.DyDanMu.dyDanMu.KeepAlive;
import com.pufang.DyDanMu.dyDanMu.KeepGetMsg;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * @author pufang.zpf
 * @date 2018/10/13
 **/
public class SchedulerJobExecuteService {

    static ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(4,
                                                                                  new BasicThreadFactory.Builder().namingPattern("schedule-pool-%d").daemon(true).build());
    static ThreadPoolExecutor tpe = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());


    public static boolean addKeepLiveJob(KeepAlive keepAlive){
        executorService.scheduleWithFixedDelay(keepAlive,0,45, TimeUnit.SECONDS);
        return true;
    }

    public static boolean addRepeatJob(KeepGetMsg keepGetMsg){
        tpe.submit(keepGetMsg);
        return true;
    }

}
