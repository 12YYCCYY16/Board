package kr.ac.kopo.board.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@Log4j2
public class UploadController {
    @Value("${kr.ac.kopo.upload.path}")
    private String uploadPath;
    @PostMapping("/uploadAjax")
    public void uploadFile(MultipartFile[] uploadFiles) {
        for (MultipartFile uploadFile : uploadFiles) {
            String originalName = uploadFile.getOriginalFilename();
            String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);
            log.info("파일명: " + fileName);
            Path savePath = Paths.get(uploadPath + File.separator+fileName);
            try{
                uploadFile.transferTo(savePath);
            }catch (IOException e){
        }
    }
}
}
