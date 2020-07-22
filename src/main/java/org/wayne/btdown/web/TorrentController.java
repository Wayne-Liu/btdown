package org.wayne.btdown.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wayne.btdown.service.BtDownRpcService;

@Controller
@RequestMapping("/send")
public class TorrentController {

    @Autowired
    private BtDownRpcService btDownRpcService;

    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        //System.out.println("hello world!");
        return "hello";
    }

    @RequestMapping("/torrent")
    @ResponseBody
    public String torrent(@RequestBody String torrNum) {
        String result = btDownRpcService.btdownUrl(torrNum);
        return "success";
    }
}
