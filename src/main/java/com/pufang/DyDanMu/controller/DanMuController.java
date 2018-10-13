package com.pufang.DyDanMu.controller;

import com.pufang.DyDanMu.domain.DanMu;
import com.pufang.DyDanMu.domain.DanMuRepository;
import com.pufang.DyDanMu.model.DanMuQuery;
import com.pufang.DyDanMu.service.DanMuQueryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author pufang.zpf
 * @date 2018/10/13
 **/
@RestController
@RequestMapping("/danmu")
public class DanMuController {

    @Autowired
    DanMuQueryService danMuQueryService;

    @GetMapping("/query")
    public Page<DanMu> queryDanmu(@RequestParam(value = "name",required = false)String name,
                                  @RequestParam("roomId")int roomId,
                                  @RequestParam(value = "pageSize",defaultValue = "100")int pageSize,
                                  @RequestParam(value = "pageNumber",defaultValue ="1")int pageNumber){
        DanMuQuery danMuQuery = new DanMuQuery();
        danMuQuery.setRoomId(roomId);
        danMuQuery.setName(name);
        return danMuQueryService.queryWithCondition(pageNumber,pageSize,danMuQuery);
    }
}
