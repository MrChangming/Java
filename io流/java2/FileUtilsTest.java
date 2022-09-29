package com.atguigu.java;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author MrChangMing
 * @Descriptio
 * @data 2022/9/29
 */
public class FileUtilsTest {

    public static void main(String[] args) {
        File srcFile = new File("day10\\爱情与友情.jpg");
        File destFile = new File("day10\\爱情与友情2.jpg");

        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
