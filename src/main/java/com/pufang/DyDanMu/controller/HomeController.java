package com.pufang.DyDanMu.controller;

import com.pufang.DyDanMu.service.DanMuRoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pufang.zpf
 * @date 2018/10/13
 **/
@RestController
public class HomeController {

    @GetMapping({"/",""})
    public String home(){
        return "HelloWorld";
    }


}
