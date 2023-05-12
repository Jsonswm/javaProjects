package com.ming.logistics.controller;


import com.ming.logistics.utils.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController {

    @RequestMapping(value = "/upload", method= RequestMethod.POST)
    public Result uploadImg(@RequestParam("file")MultipartFile file, HttpServletRequest request){

        String fileName = file.getOriginalFilename();
        String filePath = "src/main/resources/static/goodsImages/";

        try {
//            uploadImg(fileName,filePath);
            uploadFile(file.getBytes(),filePath,fileName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.success(fileName);
    }

    public static void uploadFile(byte[] file, String filePath, String fileName) throws IOException {
        File targetFile = new File(filePath);
        if (!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
