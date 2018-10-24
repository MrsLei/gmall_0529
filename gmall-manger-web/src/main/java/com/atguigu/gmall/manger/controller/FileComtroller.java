package com.atguigu.gmall.manger.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequestMapping("/file")
@Controller
public class FileComtroller {

    @ResponseBody
    @RequestMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file){
        if(!file.isEmpty()){
            String filename = file.getOriginalFilename();
            String name = file.getName();
            long size = file.getSize();
            log.info("文件项:{},名字:{},大小:{},长传成功:{}",name,filename,size);

            //获取StonageClient来储存文件

        }

        return "";
    }
}
