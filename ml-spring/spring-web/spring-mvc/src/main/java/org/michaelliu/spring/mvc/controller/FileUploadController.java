package org.michaelliu.spring.mvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Michael on 7/11/16
 * upload file
 */
@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

    private static final Log log = LogFactory.getLog(FileUploadController.class);

    /**
     * http://localhost:8080/fileupload/index
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String formUpload() {
        return "file/form";
    }

    /**
     * http://localhost:8080/fileupload/form
     */
    @PostMapping("/form")
    public String handleFormUpload(@RequestParam("name") String name,
                                   @RequestParam("file") MultipartFile file) {
        log.info("handleFormUpload file name: " + name);
        try {
            if (!file.isEmpty()) {
                // get byte stream for upload file
                byte[] bytes = file.getBytes();
                log.info("handleFormUpload file size: " + bytes.length);
                FileOutputStream fos = new FileOutputStream(new File("test.txt"));
                fos.write(bytes);
                fos.close();
                return "redirect:uploadSuccess";
            }
        } catch (IOException e) {
            log.error("handleFormUpload throws exception: " + e);
        }
        return "redirect:uploadFail";
    }

    /**
     * http://localhost:8080/fileupload/uploadSuccess
     */
    @RequestMapping(value = "/uploadSuccess", method = RequestMethod.GET)
    public String formUploadSuccess() {
        return "file/uploadSuccess";
    }

    /**
     * http://localhost:8080/fileupload/uploadFail
     */
    @RequestMapping(value = "/uploadFail", method = RequestMethod.GET)
    public String formUploadFail() {
        return "file/uploadFail";
    }

}
