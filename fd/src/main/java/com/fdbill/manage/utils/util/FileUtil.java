package com.fdbill.manage.utils.util;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 甘银涛 on 2019/5/2 21:44
 */
public class FileUtil{

    /**
     * 获取上传文件的后缀
     * @param file
     * @return
     */
    public static String getFilePrefix(MultipartFile file){
        String originalFilename = file.getOriginalFilename();

        return originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
    }

    /**
     * 将文件名称改成备份名，加上了.bak
     * @param file
     * @return
     */
    public static String getBakFileName(MultipartFile file){
        String originalFilename = file.getOriginalFilename();

        String prefix = getFilePrefix(file);

        return originalFilename.substring(0, originalFilename.lastIndexOf(".")) + ".bak." + prefix;
    }
}