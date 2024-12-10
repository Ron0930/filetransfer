package com.ron123.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class FileUploadDownloadController {

    // 设置上传文件夹路径（Tomcat的应用目录下）
    private static final String UPLOAD_DIR = System.getProperty("catalina.base") + "/webapps/simple-spring-mvc/upload/";

    @GetMapping("/upload")
    public String showUploadForm() {
        return "upload";
    }

    // 处理文件上传
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
        if (!file.isEmpty()) {
            try {
                // 获取文件保存路径
                File uploadDir = new File(UPLOAD_DIR);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();  // 如果目录不存在，则创建
                }

                // 保存文件到指定目录
                File destFile = new File(uploadDir, file.getOriginalFilename());
                file.transferTo(destFile);

                model.addAttribute("message", "文件 '" + file.getOriginalFilename() + "' 上传成功！");
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "文件上传失败: " + e.getMessage());
            }
        } else {
            model.addAttribute("message", "请选择文件上传！");
        }
        return "upload";
    }

    // 显示文件列表并提供下载
    @GetMapping("/download")
    public String showFilesForDownload(Model model) {
        File uploadDir = new File(UPLOAD_DIR);
        File[] filesArray = uploadDir.listFiles();

        // 将File[]转换为List<File>
        List<File> filesList = filesArray != null ? Arrays.asList(filesArray) : Collections.emptyList();

        if (!filesList.isEmpty()) {
            model.addAttribute("files", filesList);  // 将文件列表传递给页面
        } else {
            model.addAttribute("message", "没有文件可下载！");
        }
        return "download";  // 返回文件下载页面
    }

    // 处理文件下载
    @GetMapping("/download-file")
    public ResponseEntity<FileSystemResource> downloadFile(@RequestParam("filename") String filename) {
        File file = new File(UPLOAD_DIR, filename);
        if (file.exists()) {
            // 创建文件资源
            FileSystemResource resource = new FileSystemResource(file);
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"")
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
