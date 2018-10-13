package com.pufang.DyDanMu.controller;

import com.pufang.DyDanMu.domain.RoomInfo;
import com.pufang.DyDanMu.service.DanMuRoomService;
import com.pufang.DyDanMu.service.DanMuRoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pufang.zpf
 * @date 2018/10/13
 **/
@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    DanMuRoomService danMuRoomService;

    @PostMapping("/add")
    public String addRoom(@RequestParam("roomId")int roomId,@RequestParam("owner")String owner){
        boolean result = danMuRoomService.addNewRoom(roomId,owner);
        return String.valueOf(result);
    }

    @GetMapping("/list")
    public List<RoomInfo> listAllRoom(){
        return danMuRoomService.listAllRoom();
    }

    @PostMapping("/delete")
    public String deleteRoom(@RequestParam("roomId")int roomId ){
        boolean result =danMuRoomService.removeRoom(roomId);
        return String.valueOf(result);
    }
}
