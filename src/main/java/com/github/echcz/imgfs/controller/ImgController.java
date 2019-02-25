package com.github.echcz.imgfs.controller;

import com.github.echcz.imgfs.domain.Img;
import com.github.echcz.imgfs.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("img")
public class ImgController {
    private ImgService imgService;
    @Value("${img.prefix}")
    private String prefix;

    @Autowired
    public ImgController(ImgService imgService) {
        this.imgService = imgService;
    }

    @GetMapping("{id}")
    public void download(@PathVariable("id") String id, HttpServletResponse response) {
        Img img = imgService.find(id);
        if (img != null) {
            response.setStatus(HttpStatus.OK.value());
            response.setContentType(img.getContentType());
            try {
                response.getOutputStream().write(img.getContent());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @PostMapping("")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, HttpServletResponse response) {
        if (file.isEmpty()) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return "上传失败，请选择文件";
        }
        String filename = file.getOriginalFilename();
        byte[] content = null;
        try {
            content = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return "发生IO错误，上传失败";
        }
        String contentType = file.getContentType();
        return prefix + imgService.save(new Img(null, filename, contentType, content));
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public boolean delete(@PathVariable("id") String id) {
        imgService.delete(id);
        return true;
    }

    @GetMapping("exist/{id}")
    @ResponseBody
    public boolean exit(@PathVariable("id") String id) {
        return imgService.exist(id);
    }
}
